var canPartitionGrid = function(grid) {
    const m = grid.length, n = grid[0].length;
    let total = 0;
    for (let i = 0; i < m; i++)
        for (let j = 0; j < n; j++)
            total += grid[i][j];

    if (total % 2 !== 0)
        return false;

    const half = total >> 1;

    let rowSum = 0;
    for (let i = 0; i < m - 1; i++) {
        for (let j = 0; j < n; j++)
            rowSum += grid[i][j];
        if (rowSum === half)
            return true;
    }

    let colSum = 0;
    for (let j = 0; j < n - 1; j++) {
        for (let i = 0; i < m; i++)
            colSum += grid[i][j];
        if (colSum === half)
            return true;
    }

    return false;
};
