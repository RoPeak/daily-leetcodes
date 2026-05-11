/**
 * @param {number[]} nums
 * @return {number[]}
 */
var separateDigits = function(nums) {
    const answer = [];
    for (const num of nums) {
        for (const ch of String(num)) {
            answer.push(ch.charCodeAt(0) - 48);
        }
    }
    return answer;
};
