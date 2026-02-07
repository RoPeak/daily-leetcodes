/**
 * @param {string} s
 * @return {number}
 */
var minimumDeletions = function (s) {
  let countB = 0;
  let deletions = 0;

  for (const ch of s) {
    if (ch === "b") {
      countB++;
    } else {
      deletions = Math.min(deletions + 1, countB);
    }
  }

  return deletions;
};
