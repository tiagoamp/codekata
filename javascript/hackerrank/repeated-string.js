// https://www.hackerrank.com/challenges/repeated-string/problem

const repeatedString = (s, n) => {
    if (s.length == 1) return s === "a" ? n : 0;
    if (!s.includes("a")) return 0;
    let count = 0;
    for (let i = 0; i < s.length; i++) {
        const ch = s.charAt(i);
        if (ch == 'a') count++;
    }
    const d = n / s.length;
    const r =  n % s.length;
    count *=  Math.trunc(d);
    for(let i=0;i<r;i++)
        if(s.charAt(i) == 'a') count++;
    return count;
}


test("repeatedString", () => {
    const sample = ["aba", "a", "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm"];
    const n = [10, 1000000000000, 736778906400];
    const expected = [7, 1000000000000, 51574523448];
    for(let i=0; i<expected.length; i++) {
        const result = repeatedString(sample[i], n[i]);
        expect(result).toBe(expected[i]);
    } 
});