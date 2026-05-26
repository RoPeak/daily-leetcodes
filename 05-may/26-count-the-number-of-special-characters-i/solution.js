/**
 * @param {string} word
 * @return {number}
 */
var numberOfSpecialChars = function(word) {
    const lowercase = new Set();
    const uppercase = new Set();

    for (const ch of word) {
        if (ch >= 'a' && ch <= 'z') {
            lowercase.add(ch);
        } else {
            uppercase.add(ch.toLowerCase());
        }
    }

    let answer = 0;
    for (const ch of lowercase) {
        if (uppercase.has(ch)) {
            answer++;
        }
    }

    return answer;
};
