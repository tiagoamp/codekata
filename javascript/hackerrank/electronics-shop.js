// https://www.hackerrank.com/challenges/electronics-shop/problem

const getMoneySpent = (keyboards, drives, b) => {
    const results = [];
    for (let i = 0; i < keyboards.length; i++) {
        for (let j = 0; j < drives.length; j++) {
            const sum = keyboards[i] + drives[j];
            if (b >= sum) results.push(sum);
        }
    }
    return results.length === 0 ? -1 : Math.max(...results);
}


test("sample 0", () => {
    const keyboards = [3,1], drives = [5,2,8]; 
    const b = 10, expected = 9;
	const result = getMoneySpent(keyboards, drives, b);
	expect(result).toBe(expected);
})

test("sample 1", () => {
	const keyboards = [4], drives = [5]; 
	const b = 5, expected = -1;
	const result = getMoneySpent(keyboards, drives, b);
	expect(result).toBe(expected);
})