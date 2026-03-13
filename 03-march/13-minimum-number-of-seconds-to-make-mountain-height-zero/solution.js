/**
 * @param {number} mountainHeight
 * @param {number[]} workerTimes
 * @return {number}
 */
var minNumberOfSeconds = function(mountainHeight, workerTimes) {
  const maxUnits = (timeLimit, workerTime) => {
    let units = Math.floor((Math.sqrt(1 + (8 * timeLimit) / workerTime) - 1) / 2);
    if (units > mountainHeight) {
      units = mountainHeight;
    }

    while (workerTime * units * (units + 1) / 2 > timeLimit) {
      units--;
    }
    while (units < mountainHeight && workerTime * (units + 1) * (units + 2) / 2 <= timeLimit) {
      units++;
    }

    return units;
  };

  const feasible = (timeLimit) => {
    let removed = 0;
    for (const workerTime of workerTimes) {
      removed += maxUnits(timeLimit, workerTime);
      if (removed >= mountainHeight) {
        return true;
      }
    }
    return false;
  };

  const fastest = Math.min(...workerTimes);
  let lo = 0;
  let hi = fastest * mountainHeight * (mountainHeight + 1) / 2;

  while (lo < hi) {
    const mid = lo + Math.floor((hi - lo) / 2);
    if (feasible(mid)) {
      hi = mid;
    } else {
      lo = mid + 1;
    }
  }

  return lo;
};
