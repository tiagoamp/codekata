// https://www.hackerrank.com/challenges/day-of-the-programmer/problem

function dayOfProgrammer(year) {
    let day = 13;
    if (year == 1918)
        day += 13;  // lost days from Feb 1st to Feb 14th
    if (isLeap(year))
        day -= 1;
    return `${day}.09.${year}`;
}

const isLeap = (year) => {
    if (year <= 1918)
        return year % 4 == 0;
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
}


test("sample 0", () => {
	const year = 2017;
    const expected = "13.09.2017";
    const result = dayOfProgrammer(year);
	expect(result).toBe(expected);
});

test("sample 1", () => {
	const year = 2016;
    const expected = "12.09.2016";
    const result = dayOfProgrammer(year);
	expect(result).toBe(expected);
});

test("sample 2", () => {
	const year = 1800;
    const expected = "12.09.1800";
    const result = dayOfProgrammer(year);
	expect(result).toBe(expected);
});   

test("sample 11", () => {
	const year = 1916;
    const expected = "12.09.1916";
    const result = dayOfProgrammer(year);
	expect(result).toBe(expected);
});
