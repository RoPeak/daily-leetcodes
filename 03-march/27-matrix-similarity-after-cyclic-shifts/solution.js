var areSimilar = function(mat, k) {
    const n = mat[0].length;
    const shift = k % n;
    if (shift === 0) return true;
    for (let i = 0; i < mat.length; i++) {
        const row = mat[i];
        for (let j = 0; j < n; j++) {
            const orig = row[j];
            const shifted = i % 2 === 0
                ? row[(j + shift) % n]       // left shift: check element at j+shift wraps to j
                : row[(j - shift + n) % n];  // right shift
            if (orig !== shifted) return false;
        }
    }
    return true;
};
