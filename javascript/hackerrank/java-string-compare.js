// https://www.hackerrank.com/challenges/java-string-compare/problem

const getSmallestAndLargest = (s, k) => {
    const substrings = [];
    for(let i=0; i<=s.length-k; i++) 
        substrings.push(s.substr(i, k));
    const smallest = substrings.sort()[0];
    const largest = substrings.sort()[substrings.length-1];
    return smallest + "\n" + largest;
}


test("getSmallestAndLargest", () => {
	const s = "welcometojava", k = 3;
	const result = getSmallestAndLargest(s, k);
	expect(result).toBe("ava" + "\n" + "wel");
})