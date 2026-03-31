var generateString = function(str1, str2) {
    const n = str1.length, m = str2.length, L = n + m - 1;
    const word = new Array(L).fill('a');
    const locked = new Array(L).fill(false);

    // Stamp str2 at all 'T' positions
    for (let i = 0; i < n; i++) {
        if (str1[i] === 'T') {
            for (let j = 0; j < m; j++) {
                const pos = i + j;
                if (locked[pos] && word[pos] !== str2[j]) return "";
                word[pos] = str2[j];
                locked[pos] = true;
            }
        }
    }

    // Fix 'F' windows that match str2
    for (let i = 0; i < n; i++) {
        if (str1[i] === 'F') {
            let match = true;
            for (let j = 0; j < m; j++) {
                if (word[i + j] !== str2[j]) { match = false; break; }
            }
            if (match) {
                let fixed = false;
                for (let j = m - 1; j >= 0; j--) {
                    if (!locked[i + j]) {
                        word[i + j] = 'b';
                        fixed = true;
                        break;
                    }
                }
                if (!fixed) return "";
            }
        }
    }

    // Final validation
    for (let i = 0; i < n; i++) {
        if (str1[i] === 'F') {
            let match = true;
            for (let j = 0; j < m; j++) {
                if (word[i + j] !== str2[j]) { match = false; break; }
            }
            if (match) return "";
        }
    }

    return word.join('');
};
