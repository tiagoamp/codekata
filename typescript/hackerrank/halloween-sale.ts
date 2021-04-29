// https://www.hackerrank.com/challenges/halloween-sale/problem

function howManyGames(p: number, d: number, m: number, s: number): number {
    let nrOfGames = 0, budget = s, currGameVal = p;
    while (currGameVal <= budget) {
        nrOfGames++;
        budget -= currGameVal;
        currGameVal = ( (currGameVal-d) >= m ) ? (currGameVal - d) : m;
    }
    return nrOfGames;
}


test("sample 0", () => {
    const p = 20, d = 3, m = 6, s = 80, expected = 6;
    const result = howManyGames(p, d, m, s)
    expect(result).toBe(expected);
});

test("sample 1", () => {
    const p = 20, d = 3, m = 6, s = 85, expected = 7;
    const result = howManyGames(p, d, m, s)
    expect(result).toBe(expected);
});
