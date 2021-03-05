// https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem

function beautifulDays_solution1(i: number, j: number, k: number): number {
    const range = createRange(i,j);
    let counter = 0;
    range.forEach(n => {
        const isBeautiful = (Math.abs(n - reverse(n))) % k == 0;
        if (isBeautiful) counter++;
    });
    return counter;
}

function beautifulDays_solution2(i: number, j: number, k: number): number {
    const range = Array<number>(j-i+1).fill(0).map((_, index) => index + i);
    return range.filter(n => (Math.abs(n - reverse(n))) % k == 0).length;
}


const createRange = (from: number, to: number): number[] => {
    const list: number[] = [];
    for (let i = from; i <=to; i++)
        list.push(i);
    return list;
}

const reverse = (nr: number): number => {
    const nrAsStr = String(nr).split("");
    const reversedNrAsStr = nrAsStr.reverse().join("");
    return parseInt(reversedNrAsStr, 10);
}


test("sample 0", () => {
	const i = 20, j = 23, k = 6, expected = 2;
    const result1 = beautifulDays_solution1(i,j,k);
    const result2 = beautifulDays_solution2(i,j,k);
    expect(result1).toEqual(result2);
	expect(result1).toBe(expected);
});

test("edge cases", () => {
	const i = 1, j = 1000000, k = 100000000;
	const result = beautifulDays_solution1(i,j,k);
	expect(result).not.toBeNull();
});