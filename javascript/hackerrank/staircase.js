// https://www.hackerrank.com/challenges/staircase/problem

staircase = (n) => {
    if (n == 0) return null;
    const stairMatrix = [];
    for (let row = 0; row < n; row++) {
        let mRow = [];
        for (let col = 0; col < n; col++) {
            const value = (col >=  parseInt((n-row) - 1 )) ? '#' : ' ';
            mRow.push(value);
        }
        stairMatrix.push(mRow);
    }        
    return stairMatrix;
}


test("Staircase", () => {
    const n = 6;
    const result = staircase(n);
    for (let i = 0; i < n; i++) expect(result[0][i]).toEqual( (i >= 5) ? '#' : ' ');
	for (let i = 0; i < n; i++) expect(result[1][i]).toEqual( (i >= 4) ? '#' : ' ');
	for (let i = 0; i < n; i++) expect(result[5][i]).toEqual( (i >= 0) ? '#' : ' ');
});
