// https://www.hackerrank.com/challenges/equality-in-a-array/problem
'use strict';

function equalizeArray_solution3(arr) {
    let mostFreqNr = arr[0];
    const amount = arr.reduce((obj,n) => {
        obj[n] = obj[n] ? obj[n]+1 : 1;
        if (obj[mostFreqNr] < obj[n]) 
            mostFreqNr = n;
        return obj;
    }, {});
    return arr.length - amount[mostFreqNr];
}

function equalizeArray_solution2(arr) {
    const amount = arr.reduce((obj,n) => {
        obj[n] = obj[n] ? obj[n]+1 : 1;
        return obj;
    }, {});
    const mostFreqNr = Object.keys(amount).reduce((highest,n) => amount[n] > amount[highest] ? n : highest, arr[0]);
    const deletions = arr.reduce((acc,n) => n != mostFreqNr ? acc+1 : acc, 0);
    return deletions;
}

function equalizeArray_solution1(arr) {
    const amount = {};
    arr.forEach(n => amount[n] = amount[n] ? amount[n]+1 : 1);
    let mostFreqNr = arr[0];
    for (let n in amount) {
        if (amount[n] > amount[mostFreqNr]) 
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