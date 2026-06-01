/**
 * @param {number[]} cost
 * @return {number}
 */
var minimumCost = function(cost) {
    cost.sort((a, b) => b - a);

    let answer = 0;
    for (let i = 0; i < cost.length; i++) {
        if (i % 3 !== 2) {
            answer += cost[i];
        }
    }

    return answer;
};
