// https://www.hackerrank.com/challenges/bon-appetit/problem

const bonAppetit = (bill, k, b) => {
    const total = bill.reduce((acc, e) => acc + e, 0);
    const actualCharge = (total - bill[k]) / 2; 
    return (b == actualCharge) ? "Bon Appetit" : (b - actualCharge).toString();
}


test("sample 0", () => {
	const bill = [3, 10, 2, 9], k = 1, b = 12;
	const result = bonAppetit(bill, k, b);
	expect(result).toBe("5");		
})

test("sample 1", () => {
	const bill = [3, 10, 2, 9], k = 1, b = 7;
	const result = bonAppetit(bill, k, b);
	expect(result).toBe("Bon Appetit");		
})

test("sample 2", () => {
	const bill = [72, 53, 60, 66, 90, 62, 12, 31, 36, 94], k = 6; b = 288;
	const result = bonAppetit(bill, k, b);
	expect(result).toBe("6");		
})
