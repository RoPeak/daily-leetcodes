var findTheString = function(lcp) {
    const n = lcp.length;
    const word = new Array(n).fill('');

    let charIdx = 0;
    for (let i = 0; i < n; i++) {
        if (word[i]) continue;
        if (charIdx >= 26) return "";
        word[i] = String.fromCharCode(97 + charIdx++);
        for (let j = i + 1; j < n; j++) {
            if (lcp[i][j] > 0) {
                if (word[j] && word[j] !== word[i]) return "";
                word[j] = word[i];
            }
        }
    }

    const dp = Array.from({length: n}, () => new Int32Array(n));
    for (let i = n - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            if (word[i] === word[j]) {
                dp[i][j] = (i + 1 < n && j + 1 < n ? dp[i + 1][j + 1] : 0) + 1;
            }
            if (dp[i][j] !== lcp[i][j]) return "";
        }
    }

    return word.join('');
};
