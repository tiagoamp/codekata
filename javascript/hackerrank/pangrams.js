// https://www.hackerrank.com/challenges/pangrams/problem

const pangrams = (s) => {
    const letters = "abcdefghijklmnopqrstuvxywz";
    const charArr = letters.split('');
    const qt = Array(charArr.length).fill(0);    	
    if (s == null || s.length < charArr.length)
        return "not pangram";    	
    for (let i=0; i<s.length; i++) {
        const currChar = s.toLowerCase().charAt(i);
        for(let j=0; j<charArr.length; j++) {
            if (currChar == charArr[j]) {
                qt[j]++;
                break;
            }
        }
    }    	
    let result = true;
    for(let j=0; j<charArr.length; j++) 
        result = result && (qt[j] > 0);
    return result ? "pangram" : "not pangram";	
}


test("sample 0", () => {
	const s = "We promptly judged antique ivory buckles for the next prize";
	const result = pangrams(s);
	expect(result).toBe("pangram");
})

test("sample 1", () => {
	const s = "We promptly judged antique ivory buckles for the prize";
	const result = pangrams(s);
	expect(result).toBe("not pangram");
})
