// https://www.hackerrank.com/challenges/extra-long-factorials/problem

function extraLongFactorials(n) {
    factorial(n);  // at hackerrank site should be ==> console.log( factorial(n) )
}

var memo = {};

const factorial = n => {
    if (n == 1) return 1;
    if (!memo[n])
        memo[n] = n * factorial(n-1);
    return memo[n];
}


test("input value 25", () => {
    const n = 25, expected = 15511210043330985984000000;
    const result = factorial(n);
    expect(result).toBe(expected);
});

test("input value 45", () => {
    const n = 45, expected = 119622220865480194561963161495657715064383733760000000000;
    const result = factorial(n);
    expect(result).toBe(expected);
});

test("edge case", () => {
    const n = 100;
    const result = factorial(n);
    expect(result).not.toBeNull();
});

test("input value 1", () => {
    const n = 1, expected = 1;
    const result = factorial(n);
    expect(result).toBe(expected);
});