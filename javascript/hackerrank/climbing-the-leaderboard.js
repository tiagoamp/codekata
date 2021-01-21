// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

const climbingLeaderboard = (scores, alice) => {
    const uniqueScores = [...new Set(scores)];
    let result = [];
    let i = uniqueScores.length-1;
    for(let j=0; j<alice.length; j++) {
        const a = alice[j];
        while(i>=0) {
            if(a>=uniqueScores[i]) { 
                i--;
            } else {
                result[j] = i+2; 
                break;
            }
        }
        if(i<0) result[j] = 1;
    }
    return result;
}


test("sample 0", () => {
    const scores = [100, 100, 50, 40, 40, 20, 10];
	const alice = [5, 25, 50, 120];
	const expected = [6, 4, 2, 1];
	const result = climbingLeaderboard(scores, alice);
    for(let i=0; i<expected.length; i++) 
        expect(result[i]).toEqual(expected[i]); 
});

test("sample 1", () => {
    const scores = [100, 90, 90, 80, 75, 60];
	const alice = [50, 65, 77, 90, 102];
	const expected = [6, 5, 4, 2, 1];
    const result = climbingLeaderboard(scores, alice);
    for(let i=0; i<expected.length; i++) 
        expect(result[i]).toEqual(expected[i]);
});
