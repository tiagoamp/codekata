// https://www.hackerrank.com/challenges/lisa-workbook/problem

function workbook(n: number, k: number, arr: number[]): number {
    let nrOfSpecialProblems = 0;
    let page = 1;
    for (const nrOfProblems of arr) { // problems per chapter
        let problemCount = 0;
        while (problemCount < nrOfProblems) {
            const pgFirstProblem = problemCount + 1;
            const pgLastProblem = (nrOfProblems <= k) ? nrOfProblems
                : ( (problemCount + k <= nrOfProblems) ? problemCount + k : problemCount + (nrOfProblems % k) );
            const currPage = page;
            if ( rangeOf(pgFirstProblem,pgLastProblem).includes(currPage) )
                nrOfSpecialProblems++;
            problemCount = pgLastProblem;
            page++;
        }
    }
    return nrOfSpecialProblems;
}

const rangeOf = (start: number, end: number): number[] => {
    if(start === end) return [start];
    return [start, ...rangeOf(start + 1, end)];
}


test("sample 0", () => {
	const n = 5, k = 3, expected = 4;
    const arr = [4, 2, 6, 1, 10];
    const result = workbook(n, k, arr);
	expect(result).toEqual(expected);
});