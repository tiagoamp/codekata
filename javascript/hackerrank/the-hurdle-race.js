// https://www.hackerrank.com/challenges/the-hurdle-race/problem

const hurdleRace = (k, height) => {
    height.sort((a, b) => a - b);
    const max = height[height.length-1];
    return k >= max ? 0 : (max-k);
}


test("hurdleRace", () => {
    const k0 = 4, k1 = 7;
    const height0 = [1, 6, 3, 5, 2], height1 = [2, 5, 4, 5, 2];
    let result = hurdleRace(k0, height0);
    expect(2).toEqual(result);
    result = hurdleRace(k1, height1);
    expect(0).toEqual(result);
});
