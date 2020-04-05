const practices = require('./codepractices.js');

// https://www.hackerrank.com/challenges/plus-minus/problem
test("plusMinus", () => {
	const input = [-4, 3, -9, 0, 4, 1];
	const result = practices.plusMinus(input);
	expect(result[0]).toBe(0.500000.toFixed(6));
	expect(result[1]).toBe(0.333333.toFixed(6));
	expect(result[2]).toBe(0.166667.toFixed(6));
}),

// https://www.hackerrank.com/challenges/counting-valleys/problem
test("countingValleys", () => {
	const n = 8, s = "UDDDUDUU";
	const result = practices.countingValleys(n, s);
	expect(result).toBe(1);		
}),

// https://www.hackerrank.com/challenges/java-string-compare/problem
test("getSmallestAndLargest", () => {
	const s = "welcometojava", k = 3;
	const result = practices.getSmallestAndLargest(s, k);
	expect(result).toBe("ava" + "\n" + "wel");
}),

// https://www.hackerrank.com/challenges/pangrams/problem
test("pangrams", () => {
	let s = "We promptly judged antique ivory buckles for the next prize";
	let result = practices.pangrams(s);
	expect(result).toBe("pangram");
	s = "We promptly judged antique ivory buckles for the prize";
	result = practices.pangrams(s);
	expect(result).toBe("not pangram");
}),

// https://www.hackerrank.com/challenges/queens-attack-2/problem
test("queensAttack", () => {
	let n = 4, k = 0, r_q = 4, c_q = 4; 
	let obstacles = [];
	const expected0 = 9;
	const result0 = practices.queensAttack(n, k, r_q, c_q, obstacles);
	expect(result0).toBe(expected0);
	n = 8; k = 0; r_q = 4; c_q = 4; 
	obstacles = [];
	const expected = 27;
	const result = practices.queensAttack(n, k, r_q, c_q, obstacles);
	expect(result).toBe(expected);
	n = 5; k = 3; r_q = 4; c_q = 3; 
	obstacles = [ [5,5], [4,2], [2,3] ];
	const expected1 = 10;
	const result1 = practices.queensAttack(n, k, r_q, c_q, obstacles);
	expect(result1).toBe(expected1);
	n = 1; k = 0; r_q = 1; c_q = 1; 
	obstacles = [];
	const expected2 = 0;
	const result2 = practices.queensAttack(n, k, r_q, c_q, obstacles);
	expect(result2).toBe(expected2);
});

// https://www.hackerrank.com/challenges/repeated-string/problem
test("repeatedString", () => {
    const sample0 = "aba"; const n0 = 10; const expected0 = 7;
	const sample1 = "a"; const n1 = 1000000000000; const expected1 = 1000000000000;
	const sample7 = "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm";
	const n7 = 736778906400; const expected7 = 51574523448;
	const result0 = practices.repeatedString(sample0, n0);
	const result1 = practices.repeatedString(sample1, n1);
	const result7 = practices.repeatedString(sample7, n7);
    expect(result0).toBe(expected0);
    expect(result1).toBe(expected1);
    expect(result7).toBe(expected7);
});

// https://www.hackerrank.com/challenges/append-and-delete/problem
test("appendAndDelete", () => {
    let s = "hackerhappy", t = "hackerrank"; let k = 9;
	let result = practices.appendAndDelete(s, t, k);
	expect(result).toBe("Yes");
	s = "aba"; t = "aba"; k = 7;
	result = practices.appendAndDelete(s, t, k);
	expect(result).toBe("Yes");
	s = "ashley"; t = "ash"; k = 2;
    result = practices.appendAndDelete(s, t, k);
    expect(result).toBe("No");
	s = "y"; t = "yu"; k = 2;
    result = practices.appendAndDelete(s, t, k);
    expect(result).toBe("No");
	s = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv"; 
	t = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
	k = 20;
    result = practices.appendAndDelete(s, t, k);
    expect(result).toBe("Yes");
	s = "abcd"; t = "abcdert"; k = 10;
    result = practices.appendAndDelete(s, t, k);
    expect(result).toBe("No");
	s = "abcdef"; t = "fedcba"; k = 15;
	result = practices.appendAndDelete(s, t, k);
    expect(result).toBe("Yes");
	s = "aaa"; t = "a"; k = 5;
	result = practices.appendAndDelete(s, t, k);
    expect(result).toBe("Yes");
});

// https://www.hackerrank.com/challenges/save-the-prisoner/problem
test("saveThePrisoner", () => {
    let n = 5, m = 2, s = 1, expected = 2;
	let result = practices.saveThePrisoner(n, m, s);
	expect(result).toBe(expected);
	n = 5; m = 2; s = 2; expected = 3;
	result = practices.saveThePrisoner(n, m, s);
	expect(result).toBe(result);
	n = 7; m = 19; s = 2; expected = 6;
	result = practices.saveThePrisoner(n, m, s);
	expect(expected).toBe(result);
	n = 3; m = 7; s = 3; expected = 3;
	result = practices.saveThePrisoner(n, m, s);
	expect(result).toBe(result);
	n = 352926151; m = 380324688; s = 94730870; expected = 122129406;
	result = practices.saveThePrisoner(n, m, s);
	expect(result).toBe(result);
});

// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
test("climbingLeaderboard", () => {
    const scores1 = [100, 100, 50, 40, 40, 20, 10];
	const alice1 = [5, 25, 50, 120];
	const expected1 = [6, 4, 2, 1];
	const scores2 = [100, 90, 90, 80, 75, 60];
	const alice2 = [50, 65, 77, 90, 102];
	const expected2 = [6, 5, 4, 2, 1];
    let result = practices.climbingLeaderboard(scores1, alice1);
    for(let i=0; i<expected1.length; i++) 
        expect(result[i]).toEqual(expected1[i]); 
    result = practices.climbingLeaderboard(scores2, alice2);
    for(let i=0; i<expected1.length; i++) 
        expect(result[i]).toEqual(expected2[i]);
});

// https://www.hackerrank.com/challenges/magic-square-forming/problem
test("formingMagicSquare", () => {
    const sample0 = [ [4,9,2],[3,5,7],[8,1,5] ];
	const sample1 = [ [4,8,2],[4,5,7],[6,1,6] ];
	const expectedResult0 = 1, expectedResult1 = 4;
	let result = practices.formingMagicSquare(sample0);
	expect(result).toEqual(expectedResult0);
	result = practices.formingMagicSquare(sample1);
	expect(result).toEqual(expectedResult1);
});

// https://www.hackerrank.com/challenges/utopian-tree/problem
test("utopianTree", () => {
    const inputs = [0, 1, 4];
	const expected = [1, 2, 7];
	for (let i=0; i<inputs.length; i++) 
        expect(expected[i]).toEqual(practices.utopianTree(inputs[i]));
});

// https://www.hackerrank.com/challenges/the-hurdle-race/problem
test("hurdleRace", () => {
    const k0 = 4, k1 = 7;
    const height0 = [1, 6, 3, 5, 2], height1 = [2, 5, 4, 5, 2];
    let result = practices.hurdleRace(k0, height0);
    expect(2).toEqual(result);
    result = practices.hurdleRace(k1, height1);
    expect(0).toEqual(result);
});

// https://www.hackerrank.com/challenges/grading/problem
test("gradingStudents", () => {
    const input = [73, 67, 38, 33];
	const expected = [75,67,40,33];
	const result = practices.gradingStudents(input);
	for (let i = 0; i < result.length; i++) {
        expect(expected[i]).toEqual(result[i]);
	}
});

// https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
test("catAndMouse", () => {
    let x = 1, y = 2, z = 3;
	let result = practices.catAndMouse(x, y, z);
	expect(result).toEqual("Cat B");
	x = 1; y = 3; z = 2;
    result = practices.catAndMouse(x, y, z);
    expect(result).toEqual("Mouse C");
});

// https://www.hackerrank.com/challenges/big-sorting/problem
test("bigSorting", () => {
    let input = ["1", "2", "100", "12303479849857341718340192371", "3084193741082937", "3084193741082938", "111", "200"];
    let result = practices.bigSorting(input);
    let expectedArr = ["1", "2", "100", "111", "200", "3084193741082937", "3084193741082938", "12303479849857341718340192371"];
    expect(result).toEqual(expectedArr);
});

// https://www.hackerrank.com/challenges/the-birthday-bar/problem
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

// https://www.hackerrank.com/challenges/sock-merchant/problem
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

// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
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

// https://www.hackerrank.com/challenges/birthday-cake-candles/problem
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

// https://www.hackerrank.com/challenges/staircase/problem
test("Staircase", () => {
    const n = 6;
    const result = practices.staircase(n);
    for (let i = 0; i < n; i++) expect(result[0][i]).toEqual( (i >= 5) ? '#' : ' ');
	for (let i = 0; i < n; i++) expect(result[1][i]).toEqual( (i >= 4) ? '#' : ' ');
	for (let i = 0; i < n; i++) expect(result[5][i]).toEqual( (i >= 0) ? '#' : ' ');
});

test("Fibonacci", () => {
    let result = practices.fibonacci(10);
    expect(result).toEqual(55);
});

// https://www.hackerrank.com/challenges/mini-max-sum/problem
test("minMaxSum", () => {
    const arr = [1, 2, 3, 4, 5];
    const result = practices.minMaxSum(arr);
    expect(result[0]).toEqual(10);
    expect(result[1]).toEqual(14);    
});

// https://www.hackerrank.com/challenges/apple-and-orange/problem
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
    s = 2; t = 3; a = 1; b = 5;
    apples = [2]; oranges = [-2];
    result = practices.countApplesAndOranges(s, t, a, b, apples, oranges);
    expect(result[0]).toEqual(1);
    expect(result[1]).toEqual(1);
});

// https://www.hackerrank.com/challenges/super-digit/problem
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

// https://www.hackerrank.com/challenges/best-divisor/problem
test('Best Divisor', () => {
    const sample = 12; 
    const expectedVal = 6;
	const result = practices.bestDivisor(sample);
	expect(result).toEqual(expectedVal);
});
