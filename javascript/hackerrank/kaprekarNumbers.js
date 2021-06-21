// https://www.hackerrank.com/challenges/kaprekar-numbers/problem

function kaprekarNumbers(p, q) {
    const arr = range(p,q);
    const filtered = arr.filter(i => {
        const sq = i * i;
        const sqAsStr = sq.toString();
        const d = i.toString().length;
        const r = sqAsStr.substring(sqAsStr.length - d);
        const l = (r.length < sqAsStr.length) ? sqAsStr.substring(0, sqAsStr.length - r.length) : "0";
        return +l + +r == i;
    });
//    if (filtered.length == 0)
//        console.log("INVALID RANGE")
//    else 
//        printValues(filtered);
    return filtered;
}

const range = (from, to) => {
    const arr = [];
    for(let i=from; i <= to; i++) 
        arr.push(i);
    return arr;
};

const printValues = (arr) => {
    let vals = "";
    arr.forEach(e => vals += e + " ");
    console.log(vals);
}


test("sample 0", () => {
	const p =1, q = 100;
    const expected = [1,9,45,55,99];
    const result = kaprekarNumbers(p,q);
	expect(result).toEqual(expected);
});