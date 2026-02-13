/**
 * @param {string} s
 * @return {number}
 */
var longestBalanced = function(s) {
  const firstA = new Map([[`0#0`, 0]]);     // key: (b, c)
  const firstB = new Map([[`0#0`, 0]]);     // key: (a, c)
  const firstC = new Map([[`0#0`, 0]]);     // key: (a, b)
  const firstAB = new Map([[`0#0`, 0]]);    // key: (a - b, c)
  const firstAC = new Map([[`0#0`, 0]]);    // key: (a - c, b)
  const firstBC = new Map([[`0#0`, 0]]);    // key: (b - c, a)
  const firstABC = new Map([[`0#0`, 0]]);   // key: (a - b, a - c)

  let a = 0;
  let b = 0;
  let c = 0;
  let best = 0;

  for (let i = 1; i <= s.length; i++) {
    const ch = s[i - 1];
    if (ch === "a") {
      a++;
    } else if (ch === "b") {
      b++;
    } else {
      c++;
    }

    let key = `${b}#${c}`;
    if (firstA.has(key)) {
      best = Math.max(best, i - firstA.get(key));
    } else {
      firstA.set(key, i);
    }

    key = `${a}#${c}`;
    if (firstB.has(key)) {
      best = Math.max(best, i - firstB.get(key));
    } else {
      firstB.set(key, i);
    }

    key = `${a}#${b}`;
    if (firstC.has(key)) {
      best = Math.max(best, i - firstC.get(key));
    } else {
      firstC.set(key, i);
    }

    key = `${a - b}#${c}`;
    if (firstAB.has(key)) {
      best = Math.max(best, i - firstAB.get(key));
    } else {
      firstAB.set(key, i);
    }

    key = `${a - c}#${b}`;
    if (firstAC.has(key)) {
      best = Math.max(best, i - firstAC.get(key));
    } else {
      firstAC.set(key, i);
    }

    key = `${b - c}#${a}`;
    if (firstBC.has(key)) {
      best = Math.max(best, i - firstBC.get(key));
    } else {
      firstBC.set(key, i);
    }

    key = `${a - b}#${a - c}`;
    if (firstABC.has(key)) {
      best = Math.max(best, i - firstABC.get(key));
    } else {
      firstABC.set(key, i);
    }
  }

  return best;
};
