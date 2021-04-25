// https://www.hackerrank.com/challenges/beautiful-triplets/problem

function beautifulTriplets_Solution2(d: number, arr: number[]): number {
    return arr.reduce( (acc, n) => {
        return ( arr.find(a => a == n + d) && arr.find(a => a == n + 2 * d) ) ?
            acc+1 : acc;
    }, 0);
}

function beautifulTriplets_Solution1(d: number, arr: number[]): number {
    let result = 0
    arr.forEach(n => {
        if ( arr.find(a => a == n + d) && arr.find(a => a == n + 2 * d) )
            result++
    });
    return result
}


test("sample 0", () => {
    const arr = [1, 2, 4, 5, 7, 8, 10];
    const d = 3, expected = 3;
    const result2 = beautifulTriplets_Solution2(d, arr);
    const result1 = beautifulTriplets_Solution1(d, arr);
    expect(result2).toBe(expected);
    expect(result1).toBe(expected);
});