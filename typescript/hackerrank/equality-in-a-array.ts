// https://www.hackerrank.com/challenges/equality-in-a-array/problem

function equalizeArray_solution3(arr: number[]): number {
    let mostFreqNr: number = arr[0];
    let map = new Map();
    arr.forEach( n => { 
        map.set(n, map.has(n) ? map.get(n)+1 : 1);
        if (map.get(mostFreqNr) < map.get(n)) 
            mostFreqNr = n;
    });
    return arr.length - map.get(mostFreqNr);
}

function equalizeArray_solution2(arr: number[]): number {
    let map = new Map();
    arr.forEach( n => map.set(n, map.has(n) ? map.get(n)+1 : 1) );
    const mostFreqNr = Array.from(map.keys()).reduce((highest:number,n:number) => map.get(n) > map.get(highest) ? n : highest, arr[0]);
    const deletions = arr.reduce((acc,n) => n != mostFreqNr ? acc+1 : acc, 0);
    return deletions;
}

function equalizeArray_solution1(arr: number[]): number {
    let map = new Map();
    arr.forEach( n => map.set(n, map.has(n) ? map.get(n)+1 : 1) );
    let mostFreqNr = arr[0];
    for (let n of map.keys()) {
        if ( map.get(n) > map.get(mostFreqNr) ) 
            mostFreqNr = n;
    }
    const deletions = arr.filter(n => n != mostFreqNr).length;
    return deletions;
}


test("sample input 0", () => {
    const arr = [3, 3, 2, 1, 3], expected = 2;
    const result3 = equalizeArray_solution3(arr);
   const result2 = equalizeArray_solution2(arr);
    const result1 = equalizeArray_solution1(arr);
   expect(result1).toEqual(result2);
   expect(result2).toEqual(result3);
    expect(result3).toEqual(expected);
});

test("sample input 1", () => {
    const arr = [1, 2, 3, 1, 2, 3, 3, 3], expected = 4;
    const result3 = equalizeArray_solution3(arr);
    const result2 = equalizeArray_solution2(arr);
    const result1 = equalizeArray_solution1(arr);
    expect(result1).toEqual(result2);
    expect(result2).toEqual(result3);
    expect(result3).toEqual(expected);
});

test("edge case", () => {
    const arr = [], expected = 0;
    for (let i=0; i<100; i++)
        arr[0] = i+1;
    const result = equalizeArray_solution3(arr);
    expect(result).toEqual(expected);
});