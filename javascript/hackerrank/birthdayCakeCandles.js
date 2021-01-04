// https://www.hackerrank.com/challenges/birthday-cake-candles/problem

birthdayCakeCandles = (arr) => {
    arr.sort((a, b) => a - b);
    const lastIndex = arr.length -1;
    let tallest = arr[lastIndex];
    let count = 0;		
    for (let i = lastIndex; i >= 0; i--) {
        if (arr[i] == tallest) count++;
        else break;			
    }		
    return count;
}


test("birthdayCakeCandles", () => {
    let arr = [3, 2, 1, 3];
	let result = practices.birthdayCakeCandles(arr);
	expect(result).toEqual(2);
	// threshold case 
	const n = 100000;
	arr = Array(n).fill(9999999);
	result = birthdayCakeCandles(arr);
	expect(result).toEqual(100000);
});