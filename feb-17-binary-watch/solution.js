/**
 * @param {number} turnedOn
 * @return {string[]}
 */
var readBinaryWatch = function(turnedOn) {
  const ans = [];

  const bitCount = (x) => {
    let count = 0;
    while (x > 0) {
      x &= x - 1;
      count++;
    }
    return count;
  };

  for (let hour = 0; hour < 12; hour++) {
    for (let minute = 0; minute < 60; minute++) {
      if (bitCount(hour) + bitCount(minute) === turnedOn) {
        ans.push(`${hour}:${String(minute).padStart(2, '0')}`);
      }
    }
  }

  return ans;
};
