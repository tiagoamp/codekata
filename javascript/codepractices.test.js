const practices = require('./codepractices.js');


test('Best Divisor', () => {
    const sample = 12; 
    const expectedVal = 6;
	const result = practices.bestDivisor(sample);
	expect(result).toEqual(expectedVal);
});

test("Superdigit", () => {
    let n = "148"; k = 3, expected = 3, result = 0;
    result = practices.superdigit(n,k);
    expect(result).toEqual(expected);
	n = "9875"; k = 4; expected = 8;
	result = practices.superdigit(n,k);
	expect(result).toEqual(expected);
	n = "123"; k = 3; expected = 9;
	result = practices.superdigit(n,k);
    expect(result).toEqual(expected);
	n = "100000"; k = 100000;  // superior threshold 
    result = practices.superdigit(n,k);
    expect(result).toBeGreaterThan(0);
});

test("CountApplesAndOranges", () => {
    // sample case
    let s = 7, t = 11;  // house
    let a = 5, b = 15;  // tree
    let apples = [-2, 2, 1];   // fruits array
    let oranges = [5, -6];     // fruits array
    let result = practices.countApplesAndOranges(s, t, a, b, apples, oranges);
    expect(result[0]).toEqual(1);
    expect(result[1]).toEqual(1);
    // test case 2
    s = 2; t = 3;
    a = 1; b = 5;
    apples = [2];
    oranges = [-2];
    result = practices.countApplesAndOranges(s, t, a, b, apples, oranges);
    expect(result[0]).toEqual(1);
    expect(result[1]).toEqual(1);
});

test("minMaxSum", () => {
    const arr = [1, 2, 3, 4, 5];
    const result = practices.minMaxSum(arr);
    expect(result[0]).toEqual(10);
    expect(result[1]).toEqual(14);    
});

test("Fibonacci", () => {
    let result = practices.fibonacci(10);
    expect(result).toEqual(55);
});

test("Staircase", () => {
    const n = 6;
    const result = practices.staircase(n);
    for (let i = 0; i < n; i++) expect(result[0][i]).toEqual( (i >= 5) ? '#' : ' ');
	for (let i = 0; i < n; i++) expect(result[1][i]).toEqual( (i >= 4) ? '#' : ' ');
	for (let i = 0; i < n; i++) expect(result[5][i]).toEqual( (i >= 0) ? '#' : ' ');
});

test("birthdayCakeCandles", () => {
    let arr = [3, 2, 1, 3];
	let result = practices.birthdayCakeCandles(arr);
	expect(result).toEqual(2);
	// threshold case 
	const n = 100000;
	arr = Array(n).fill(9999999);
	result = practices.birthdayCakeCandles(arr);
	expect(result).toEqual(100000);
});

test("kangaroo", () => {
    let x1 = 0; v1 = 3; x2 = 4; v2 = 2;
	let result = practices.kangaroo(x1, v1, x2, v2);
	expect(result).toEqual("YES");
	x1 = 0; v1 = 2; x2 = 5; v2 = 3;
	result = practices.kangaroo(x1, v1, x2, v2);
	expect(result).toEqual("NO");
	x1 = 43; v1 = 2; x2 = 70; v2 = 2;
	result = practices.kangaroo(x1, v1, x2, v2);
    expect(result).toEqual("NO");
});

test("breakingRecords", () => {
    const sample0 = [10, 5, 20, 20, 4, 5, 2, 25, 1];
	let result = practices.breakingRecords(sample0);
	expect(result[0]).toEqual(2);
	expect(result[1]).toEqual(4);
	const sample1 = [3, 4, 21, 36, 10, 28, 35, 5, 24, 42];
	result = practices.breakingRecords(sample1);
	expect(result[0]).toEqual(4);
	expect(result[1]).toEqual(0);
});

test("sockMerchant", () => {
    let n = 9;
    let arr = [10, 20, 20, 10, 10, 30, 50, 10, 20];
    let result = practices.sockMerchant(n, arr);
    expect(result).toEqual(3);
    n = 10;
    arr = [1, 1, 3, 1, 2, 1, 3, 3, 3, 3];
    result = practices.sockMerchant(n, arr);
    expect(result).toEqual(4);
});

test("birthdayChoc", () => {
    let s = [1, 2, 1, 3, 2];
	let d = 3, m = 2;
	let result = practices.birthdayChoc(s, d, m);
	expect(result).toEqual(2);
	s = [1, 1, 1, 1, 1, 1];
	result = practices.birthdayChoc(s, d, m);
	expect(result).toEqual(0);
	s = [2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1];
	d = 18; m = 7;
	result = practices.birthdayChoc(s, d, m);
	expect(result).toEqual(3);
});

test("bigSorting", () => {
    let input = ["1", "2", "100", "12303479849857341718340192371", "3084193741082937", "3084193741082938", "111", "200"];
    let result = practices.bigSorting(input);
    let expectedArr = ["1", "2", "100", "111", "200", "3084193741082937", "3084193741082938", "12303479849857341718340192371"];
    expect(result).toEqual(expectedArr);
});

test("catAndMouse", () => {
    let x = 1, y = 2, z = 3;
	let result = practices.catAndMouse(x, y, z);
	expect(result).toEqual("Cat B");
	x = 1; y = 3; z = 2;
    result = practices.catAndMouse(x, y, z);
    expect(result).toEqual("Mouse C");
});

test("gradingStudents", () => {
    const input = [73, 67, 38, 33];
	const expected = [75,67,40,33];
	const result = practices.gradingStudents(input);
	for (let i = 0; i < result.length; i++) {
        expect(expected[i]).toEqual(result[i]);
	}
});

test("hurdleRace", () => {
    const k0 = 4, k1 = 7;
    const height0 = [1, 6, 3, 5, 2], height1 = [2, 5, 4, 5, 2];
    let result = practices.hurdleRace(k0, height0);
    expect(2).toEqual(result);
    result = practices.hurdleRace(k1, height1);
    expect(0).toEqual(result);
});

test("utopianTree", () => {
    const inputs = [0, 1, 4];
	const expected = [1, 2, 7];
	for (let i=0; i<inputs.length; i++) {
        expect(expected[i]).toEqual(practices.utopianTree(inputs[i]));
	}
});

test("formingMagicSquare", () => {
    const sample0 = [ [4,9,2],[3,5,7],[8,1,5] ];
	const sample1 = [ [4,8,2],[4,5,7],[6,1,6] ];
	const expectedResult0 = 1, expectedResult1 = 4;
	let result = practices.formingMagicSquare(sample0);
	expect(result).toEqual(expectedResult0);
	result = practices.formingMagicSquare(sample1);
	expect(result).toEqual(expectedResult1);
});
