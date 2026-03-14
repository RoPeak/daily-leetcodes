/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
var getHappyString = function(n, k) {
  const total = 3 * (1 << (n - 1));
  if (k > total) {
    return "";
  }

  const chars = [];
  let prev = "";
  k--;

  for (let i = 0; i < n; i++) {
    const choices = [];
    for (const ch of "abc") {
      if (ch !== prev) {
        choices.push(ch);
      }
    }

    const block = 1 << (n - i - 1);
    for (const ch of choices) {
      if (k >= block) {
        k -= block;
      } else {
        chars.push(ch);
        prev = ch;
        break;
      }
    }
  }

  return chars.join("");
};
