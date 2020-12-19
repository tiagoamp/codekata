// https://www.hackerrank.com/challenges/super-digit/problem

test("Superdigit", () => {
    const n = ["148", "9875", "123"];
    const k = [3, 4, 3];
    const expected = [3, 8, 9];
    for(let i=0; i < expected.length; i++) {
        const result = superdigit(n[i],k[i]);
        expect(result).toEqual(expected[i]);
    }
});

superdigit = (n, k) => {
    if (n.length <= 1) return parseInt(n);
    let sum = 0;
    for (let i = 0; i < n.length; i++) {
        const digit = n.charAt(i);
        sum += parseInt(digit);
    }
    if (k > 1) sum *= k;
    return superdigit(sum.toString(), 1);
}