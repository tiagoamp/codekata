// https://www.hackerrank.com/challenges/fair-rations/problem

/*
 * The function is expected to return a STRING.
 * The function accepts ARRAY B as parameter.
 */

function fairRations(B) {
    const totalOddNrs = B.reduce((acc, b) => acc = isOdd(b) ? acc+1 : acc, 0);
    if (totalOddNrs == 0)  // only even numbers
        return "0";
    if (isOdd(totalOddNrs))
        return "NO";
    let count = 0;
    for (let i = 0; i < B.length-1; i++) {
        if (isOdd(B[i])) {
            B[i+1] = B[i+1] +1;
            count += 2;
        }
    }
    return count.toString();
}

const isOdd = n => n % 2 != 0; 


test("sample input 0", () => {
    const b = [2, 3, 4, 5, 6];
    const expected = "4";
    const result = fairRations(b);
    expect(result).toBe(expected);
});

test("sample input 1", () => {
    const b = [1, 2];
    const expected = "NO";
    const result = fairRations(b);
    expect(result).toBe(expected);
});
