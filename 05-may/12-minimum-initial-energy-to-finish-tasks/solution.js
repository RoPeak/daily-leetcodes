/**
 * @param {number[][]} tasks
 * @return {number}
 */
var minimumEffort = function(tasks) {
    tasks.sort((a, b) => (b[1] - b[0]) - (a[1] - a[0]));

    let spent = 0;
    let answer = 0;

    for (const [actual, minimum] of tasks) {
        answer = Math.max(answer, spent + minimum);
        spent += actual;
    }

    return answer;
};
