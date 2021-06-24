// https://www.hackerrank.com/challenges/taum-and-bday/problem

function taumBday(b, w, bc, wc, z) {
    if (bc > (wc + z))
        return BigInt(wc) * (BigInt(b) + BigInt(w)) + (BigInt(b) * BigInt(z));
    else if (wc > (bc + z)) 
        return BigInt(bc) * (BigInt(b) + BigInt(w)) + (BigInt(w) * BigInt(z));
    return (BigInt(b) * BigInt(bc)) + (BigInt(w) * BigInt(wc));
}


test("sample 0", () => {
	const b  = [10, 5, 3, 7, 3];
    const w  = [10, 9, 6, 7, 3];
    const bc = [1, 2, 9, 4, 1];
    const wc = [1, 3, 1, 2, 9];
    const z  = [1, 4, 1, 1, 2];
    const expected = [20n, 37n, 12n, 35n, 12n];
    for (let i=0; i< expected.length; i++) {
        const result = taumBday(b[i], w[i], bc[i], wc[i], z[i]);
        expect(result).toBe(expected[i]);
    }
});

test("sample 11", () => {
	const b  = [742407782, 142640749, 736418699, 177076565, 232813954, 988402860, 571683259, 810421806, 235081335, 547257058];
    const w  = [90529439, 652432197, 754161925, 651852957, 654376491, 283959645, 397259663, 414506999, 101052703, 324443644];
    const bc = [847666641, 701695848, 912285746, 926160119, 933554781, 572488886, 136103531, 58343377, 957899374, 594266462];
    const wc = [8651519, 936714099, 841360803, 137199984, 63130979, 802335530, 271866251, 512117653, 147367080, 325933528];
    const z  = [821801924, 324221606, 736841333, 872396383, 441062505, 193057740, 405911181, 203737449, 942413506, 461643627];
    const expected = [617318315833461267n, 711232858900355655n, 1306346564995590229n, 253435467783263923n, 158694707102490425n, 
        783234000390521730n, 185809605416820942n, 155917081637180036n, 240076105402801530n, 430963577188284828n];
    for (let i=0; i< expected.length; i++) {
        const result = taumBday(b[i], w[i], bc[i], wc[i], z[i]);
        expect(result).toBe(expected[i]);
    }
});  
