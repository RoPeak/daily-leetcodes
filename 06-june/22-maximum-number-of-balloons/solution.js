/**
 * @param {string} text
 * @return {number}
 */
var maxNumberOfBalloons = function(text) {
    const counts = new Int32Array(26);
    const aCode = "a".charCodeAt(0);

    for (const char of text) {
        counts[char.charCodeAt(0) - aCode]++;
    }

    return Math.min(
        counts[1],
        counts[0],
        Math.floor(counts[11] / 2),
        Math.floor(counts[14] / 2),
        counts[13]
    );
};
