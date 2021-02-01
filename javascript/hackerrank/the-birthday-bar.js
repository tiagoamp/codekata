// https://www.hackerrank.com/challenges/the-birthday-bar/problem

const birthdayChoc = (s, d, m) => {
    let result = 0, index  = 0;
    if (s == null || s.length == 0) return result;
    let isOver = m > s.length;
    while (!isOver) {    		
        let inner = s.slice(index, m);
        const sum = inner.reduce((x,y) => x+y, 0);
        if (sum == d) result++;
        index++;
        m++;
        isOver = m > s.length;
    }    	
    return result;
}


test("sample 0", () => {
    const s = [1, 2, 1, 3, 2];
	const d = 3, m = 2;
	const result = birthdayChoc(s, d, m);
	expect(result).toEqual(2);
});

test("sample 1", () => {
    const s = [1, 1, 1, 1, 1, 1];
    const d = 3, m = 2;
	const result = birthdayChoc(s, d, m);
	expect(result).toEqual(0);
});

test("sample 2", () => {
    const s = [2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1];
	const d = 18; m = 7;
	result = birthdayChoc(s, d, m);
	expect(result).toEqual(3);
});
