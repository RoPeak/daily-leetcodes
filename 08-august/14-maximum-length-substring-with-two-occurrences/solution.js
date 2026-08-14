/**
 * @param {string} s
 * @return {number}
 */
var maximumLengthSubstring = function(s) {
    const counts = new Array(26).fill(0);
    let left = 0;
    let answer = 0;

    for (let right = 0; right < s.length; right++) {
        const idx = s.charCodeAt(right) - 97;
        counts[idx]++;

        while (counts[idx] > 2) {
            counts[s.charCodeAt(left) - 97]--;
            left++;
        }

        answer = Math.max(answer, right - left + 1);
    }

    return answer;
};
