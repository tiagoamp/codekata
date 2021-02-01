// https://www.hackerrank.com/challenges/utopian-tree/problem

const utopianTree = (n) => {
    let result = 1;
    if (n == 0) return result;
    for(let i=1; i <=n; i++) {
        const shouldDoubleSize = i%2 != 0; // odd numbers double size
        result = shouldDoubleSize ? result * 2 : result + 1; 
    }
    return result;
}


test("utopianTree", () => {
    const inputs = [0, 1, 4];
	const expected = [1, 2, 7];
    for (let i=0; i<inputs.length; i++) { 
        const result = utopianTree(inputs[i]);
        expect(expected[i]).toEqual(result);
    }
});
