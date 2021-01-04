// https://www.hackerrank.com/challenges/mini-max-sum/problem

minMaxSum = (arr) => {
    arr.sort(function(a, b){return a-b});
    let min = 0, max = 0;
    const len = 5;    	
    for (let i = 0; i < arr.length; i++) {
        if (i < len-1) min += arr[i];
        if (i > 0) max += arr[i];
    }
    return [min,max];
}


test("minMaxSum", () => {
    const arr = [1, 2, 3, 4, 5];
    const result = minMaxSum(arr);
    expect(result[0]).toEqual(10);
    expect(result[1]).toEqual(14);    
});
