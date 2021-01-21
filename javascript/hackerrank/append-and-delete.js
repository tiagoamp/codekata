// https://www.hackerrank.com/challenges/append-and-delete/problem

const appendAndDelete = (s, t, k) => {
    if (s === t) {
        if (k > s.length) return k > 2 ? "Yes" : "No";
        else return k%2 == 0 ? "Yes" : "No"; 
    }    		
    let commonChars = -1;  // find out index until 't' equals 's' 
    for (let i = 0; i < s.length; i++) {
        if ( (i > (t.length-1)) || s.charAt(i) != t.charAt(i) )
            break;
        commonChars++;  // increment if same char in both strings
    }
    const diffOfS = s.substring(commonChars+1);
    const diffOfT = t.substring(commonChars+1);
    if (diffOfS.length == 0) {
        return k >= diffOfT.length && (k - diffOfT.length)%2 == 0 ? "Yes": "No";
    } else if (diffOfT.length == 0) {
        return k >= diffOfS.length && (k > s.length || (k - diffOfS.length)%2 == 0) ? "Yes": "No";
    } 
    if (k > diffOfS.length+diffOfT.length) return k > 2 ? "Yes" : "No";
    return (k >= diffOfS.length+diffOfT.length) && (k - diffOfS.length+diffOfT.length)%2==0 ? "Yes" : "No";
}


test("sample 0", () => {
    const s = "hackerhappy", t = "hackerrank", k = 9;
	const result = appendAndDelete(s, t, k);
	expect(result).toBe("Yes");
});

test("sample 1", () => {
    const s = "aba", t = "aba", k = 7;
	const result = appendAndDelete(s, t, k);
	expect(result).toBe("Yes");
});

test("sample 2", () => {
    const s = "ashley", t = "ash", k = 2;
    const result = appendAndDelete(s, t, k);
    expect(result).toBe("No");
});

test("sample 3", () => {
    const s = "y", t = "yu", k = 2;
    const result = appendAndDelete(s, t, k);
    expect(result).toBe("No");
});

test("sample 4", () => {
    const s = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv"; 
	const t = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
	const k = 20;
    const result = appendAndDelete(s, t, k);
    expect(result).toBe("Yes");
});

test("sample 5", () => {
    const s = "abcd", t = "abcdert", k = 10;
    const result = appendAndDelete(s, t, k);
    expect(result).toBe("No");
});

test("sample 6", () => {
    const s = "abcdef", t = "fedcba", k = 15;
	const result = appendAndDelete(s, t, k);
    expect(result).toBe("Yes");
});

test("sample 7", () => {
    const s = "aaa", t = "a", k = 5;
	const result = appendAndDelete(s, t, k);
    expect(result).toBe("Yes");
});
