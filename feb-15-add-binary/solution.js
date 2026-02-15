/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
  let i = a.length - 1;
  let j = b.length - 1;
  let carry = 0;
  const out = [];

  while (i >= 0 || j >= 0 || carry > 0) {
    let total = carry;
    if (i >= 0) {
      total += a.charCodeAt(i) - 48;
      i--;
    }
    if (j >= 0) {
      total += b.charCodeAt(j) - 48;
      j--;
    }

    out.push(String(total & 1));
    carry = total >> 1;
  }

  out.reverse();
  return out.join("");
};
