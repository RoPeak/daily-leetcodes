/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkStrings = function(s1, s2) {
    const counts = new Array(52).fill(0);

    for (let i = 0; i < s1.length; i++) {
        const offset = (i & 1) * 26;
        counts[offset + s1.charCodeAt(i) - 97]++;
        counts[offset + s2.charCodeAt(i) - 97]--;
    }

    for (const count of counts) {
        if (count !== 0) {
            return false;
        }
    }

    return true;
};
