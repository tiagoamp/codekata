// https://www.hackerrank.com/challenges/circular-array-rotation/problem

function circularArrayRotation_arraySliceSolution(a: number[], k: number, queries: number[]): number[] {
    const lastKelemts = a.slice( k * (-1) );
    const firstElemtsUntilKindex = a.slice(0, k-1); 
    return [ ...lastKelemts , ...firstElemtsUntilKindex ]; 
}

function circularArrayRotation_naiveSolution1(a: number[], k: number, queries: number[]): number[] {
    let result = [...a], lastArrIndex = a.length - 1;
    for(let rotation=1; rotation<=k; rotation++) {
        const curr = [...result];
        const lastElem = result[lastArrIndex];
        result = [lastElem];
        for (let i=0; i<=lastArrIndex-1; i++) 
            result.push(curr[i]);
    }
    return result; 
}

function circularArrayRotation_naiveSolution2(a: number[], k: number, queries: number[]): number[] {
    let result = [...a], lastArrIndex = a.length - 1;
    for(let rotation=1; rotation<=k; rotation++) {
        const curr = [...result];
        const lastElem = result[lastArrIndex];
        const elemtsBeforeLast = curr.slice(0, lastArrIndex); 
        result = [lastElem, ...elemtsBeforeLast];
    }
    return result; 
}

test("sample input 0", () => {
    const a = [1,2,3], k = 2, queries = [0,1,2], expected = [2,3,1];
    const result1 = circularArrayRotation_arraySliceSolution(a,k,queries);
    const result2 = circularArrayRotation_naiveSolution1(a,k,queries);
    const result3 = circularArrayRotation_naiveSolution2(a,k,queries);
    expect(result1).toEqual(result2);
    expect(result2).toEqual(result3);
    expect(result1).toEqual(expected);
});

test("edge cases", () => {
    const a = [Math.pow(10,5),Math.pow(10,5),Math.pow(10,5)], k = Math.pow(10,5), queries = [1,1000,Math.pow(10,4)];
    const result = circularArrayRotation_arraySliceSolution(a,k,queries);
    expect(result).not.toBeNull();
});
