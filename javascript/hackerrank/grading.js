// https://www.hackerrank.com/challenges/grading/problem

const gradingStudents = (grades) => {
    if (grades == null || grades.length === 0) return grades;
    const roundedGrades = grades.map(n => {
        if (n < 38) {
            return n;
        } else {
            const nextMultipleOfFive = 5*Math.ceil(n/5);
            return (nextMultipleOfFive - n) < 3 ? nextMultipleOfFive : n;
        }
    });
    return roundedGrades;
}


test("gradingStudents", () => {
    const input = [73, 67, 38, 33];
	const expected = [75,67,40,33];
	const result = gradingStudents(input);
	for (let i = 0; i < result.length; i++) {
        expect(expected[i]).toEqual(result[i]);
	}
});
