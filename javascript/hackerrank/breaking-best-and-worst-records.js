// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

const breakingRecords = (scores) => {
    let countMin = 0, countMax = 0;
    let min = scores[0], max = scores[0];
    
    for (let i = 0; i < scores.length; i++) {
        if (scores[i] < min) {
            min = scores[i];
            countMin++;
        } else if (scores[i] > max) {
            max = scores[i];
            countMax++;
        }
    }
    
    const result = [countMax, countMin];
    return result;
}

test("sample 0", () => {
    const sample0 = [10, 5, 20, 20, 4, 5, 2, 25, 1];
	const result = breakingRecords(sample0);
	expect(result[0]).toEqual(2);
	expect(result[1]).toEqual(4);
});

test("sample 1", () => {
    const sample1 = [3, 4, 21, 36, 10, 28, 35, 5, 24, 42];
	const result = breakingRecords(sample1);
	expect(result[0]).toEqual(4);
	expect(result[1]).toEqual(0);
});
