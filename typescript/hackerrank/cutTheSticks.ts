// https://www.hackerrank.com/challenges/cut-the-sticks/problem

function cutTheSticks_IterativeSolution(arr: number[]): number[] {
    const result: number[] = [];
    let inputArr = [...arr];
    while (inputArr.length > 0) {
        const min = Math.min(...inputArr)
        if (min != null) {
             result.push(inputArr.length);
             inputArr = inputArr.filter(i => i != min).map(i => i - min);
         }
    }
     return result;
}

function cutTheSticks_RecursiveSolution(arr: number[]): number[] {
    const result = _cutArray(arr)
    return result;
}

function _cutArray(input: number[], output: number[] = []): number[] {
    if (input.length == 0) return output
    let inputArr = [...input];
    const min = Math.min(...inputArr);
    if (min != null) {
        output.push(inputArr.length)
        inputArr = inputArr.filter(i => i != min).map(i => i - min);
    }
    return _cutArray(inputArr, output);
}


test("sample input 0", () => {
    const arr = [5, 4, 4, 2, 2, 8], expected = [6, 4, 2, 1];
    const result2 = cutTheSticks_RecursiveSolution(arr);
    const result1 = cutTheSticks_IterativeSolution(arr);
    expect(result2).toEqual(expected);
    expect(result1).toEqual(expected);
});

test("sample input 1", () => {
    const arr = [1, 2, 3, 4, 3, 3, 2, 1], expected = [8, 6, 4, 1];
    const result2 = cutTheSticks_RecursiveSolution(arr);
    const result1 = cutTheSticks_IterativeSolution(arr);
    expect(result2).toEqual(expected);
    expect(result1).toEqual(result2);
});
