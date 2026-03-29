var canBeEqual = function(s1, s2) {
    const sortPair = (a, b) => a < b ? [a, b] : [b, a];
    const [e10, e12] = sortPair(s1[0], s1[2]);
    const [e20, e22] = sortPair(s2[0], s2[2]);
    const [e11, e13] = sortPair(s1[1], s1[3]);
    const [e21, e23] = sortPair(s2[1], s2[3]);
    return e10 === e20 && e12 === e22 && e11 === e21 && e13 === e23;
};
