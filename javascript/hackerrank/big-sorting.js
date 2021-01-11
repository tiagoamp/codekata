// https://www.hackerrank.com/challenges/big-sorting/problem

const bigSorting = (unsorted) => {    	
    const comparator = (a, b) => {
        // different sizes
        if (a.length != b.length) 
            return a.length - b.length;
        // same sizes, compare per digits
        for (let i = 0; i < a.length; i++) {
            const digitFromA = a.charAt(i);
            const digitFromB = b.charAt(i);
            if (digitFromA != digitFromB) 
                return digitFromA - digitFromB;
        }
        // numbers are the same.
        return 0;
    };
    const result = unsorted.sort(comparator);
    return result;
}


test("bigSorting", () => {
    const input = ["1", "2", "100", "12303479849857341718340192371", "3084193741082937", "3084193741082938", "111", "200"];
    const result = bigSorting(input);
    const expectedArr = ["1", "2", "100", "111", "200", "3084193741082937", "3084193741082938", "12303479849857341718340192371"];
    expect(result).toEqual(expectedArr);
});
