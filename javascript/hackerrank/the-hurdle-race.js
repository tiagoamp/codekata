// https://www.hackerrank.com/challenges/the-hurdle-race/problem

const hurdleRace = (k, height) => {
    height.sort((a, b) => a - b);
    const max = height[height.length-1];
    return k >= max ? 0 : (max-k);
}


test("hurdleRace", () => {
    const k0 = 4, k1 = 7;
    const height0 = [1, 6, 3, 5, 2], height1 = [2, 5, 4, 5, 2];
    const expected0 = 2, expected1 = 0;
    const result0 = hurdleRace(k0, height0);
    const result1 = hurdleRace(k1, height1);
    expect(result0).toEqual(expected0);
    expect(result1).toEqual(expected1);
});
