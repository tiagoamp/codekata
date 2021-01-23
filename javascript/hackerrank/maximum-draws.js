// https://www.hackerrank.com/challenges/maximum-draws/problem

const maximumDraws = (n) => {
    return ( (n * 2) / 2 ) + 1;
}


test("maximumDraws", () => {
    const n = [1, 2], expected = [2, 3];
    for(let i=0; i<expected.length; i++) {
        const result = maximumDraws(n[i]);
        expect(result).toBe(expected[i]);
    }
})
