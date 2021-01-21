// https://www.hackerrank.com/challenges/counting-valleys/problem

const countingValleys = (n, s) => {
    let countOfValleys = 0, path = 0, enteredValley = false;
    const seaLevel = 0;		
    for (let i = 0; i < n; i++) {
        const letter = s.charAt(i);
        if (letter === 'U') path += 1;
        else if (letter === 'D') path -= 1;
        if (path === seaLevel && enteredValley)
            countOfValleys++;
        enteredValley = path < 0;
    }
    return countOfValleys;
}


test("countingValleys", () => {
	const n = 8, s = "UDDDUDUU";
	const result = countingValleys(n, s);
	expect(result).toBe(1);		
})