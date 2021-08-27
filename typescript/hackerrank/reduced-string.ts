// https://www.hackerrank.com/challenges/reduced-string/problem

function superReducedString(s: string) {
    let r = s;
    let wasReduced = true;
    while (wasReduced) {
        var tokens = breakInRepeatedTokens(r);
        var reducedStr = "";
        tokens.forEach(token => {
            if ( isOddCount(token.length) )
                reducedStr += token.charAt(0);
        });
        wasReduced = reducedStr != r;
        r = reducedStr;
    }
    return r == "" ? "Empty String" : r;
}

const breakInRepeatedTokens = (value: string) : string[] => {
    const tokens: string[] = [];
    if (value == "") return tokens;
    let token = "";
    let arr = value.split("");
    var currCh = arr[0];
    for (let i = 0; i < arr.length; i++) {
        var ch = arr[i];
        if (ch == currCh) {
            token += ch;
            continue;
        }
        tokens.push(token);
        token = "" + ch;
        currCh = ch;
    }
    tokens.push(token);
    return tokens;
}

const isOddCount = (value: number) : boolean => value % 2 != 0;


test("samples", () => {
	const input = ["aaabccddd", "aa", "baab"];
    const expected = ["abd", "Empty String", "Empty String"];
    for (let i=0; i < expected.length; i++) {
        const s = input[i];
        const result = superReducedString(s);
        expect(result).toEqual(expected[i]);
    }
});