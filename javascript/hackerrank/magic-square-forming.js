// https://www.hackerrank.com/challenges/magic-square-forming/problem

const formingMagicSquare = (s) => {
    let costs = [0,0,0,0,0,0,0,0];
    const magicSquares = 
    [ [2,7,6,9,5,1,4,3,8], [6,7,2,1,5,9,8,3,4], [8,3,4,1,5,9,6,7,2], [4,3,8,9,5,1,2,7,6],
      [6,1,8,7,5,3,2,9,4], [2,9,4,7,5,3,6,1,8], [4,9,2,3,5,7,8,1,6], [8,1,6,3,5,7,4,9,2]
    ];
    for (let i=0;i<magicSquares.length;i++) {        
        costs[i] = Math.abs(magicSquares[i][0]-s[0][0]) + Math.abs(magicSquares[i][1]-s[0][1]) + Math.abs(magicSquares[i][2]-s[0][2]);
        costs[i] = costs[i] + Math.abs(magicSquares[i][3]-s[1][0]) + Math.abs(magicSquares[i][4]-s[1][1]) + Math.abs(magicSquares[i][5]-s[1][2]);
        costs[i] = costs[i] + Math.abs(magicSquares[i][6]-s[2][0]) + Math.abs(magicSquares[i][7]-s[2][1]) + Math.abs(magicSquares[i][8]-s[2][2]);
    }
    const minCost = Math.min( ...costs );
    return minCost;
}


test("formingMagicSquare", () => {
    const sample0 = [ [4,9,2],[3,5,7],[8,1,5] ];
	const sample1 = [ [4,8,2],[4,5,7],[6,1,6] ];
	const expectedResult0 = 1, expectedResult1 = 4;
	let result = formingMagicSquare(sample0);
	expect(result).toEqual(expectedResult0);
	result = formingMagicSquare(sample1);
	expect(result).toEqual(expectedResult1);
});
