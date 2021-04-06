// https://www.hackerrank.com/challenges/minimum-distances/problem

function minimumDistances_solution2(a) {  // O(n) 
    let minDist = a.length+1;
    const map = {};
    for (let i=0; i<a.length; i++) {
        const curr = a[i]
        if (map[curr] == null) {
            map[curr] = i;
            continue;
        } 
        const dist = i - map[curr];
        if ( dist < minDist )
            minDist = dist;
        map[curr] = i;
    }
    return minDist == a.length+1 ? -1 : minDist;
}

function minimumDistances_solution1(a) {  // O(n^2)
    let minDist = a.length+1;
    for (let i=0; i<(a.length-1); i++) {
        for (let j=i+1; j<a.length; j++) {
            if (a[i] == a[j] && (j-i) < minDist) 
                minDist = j-i;
        }
    }
    return minDist == a.length+1 ? -1 : minDist;
}


test("sample input 0", () => {
    const arr = [7, 1, 3, 4, 1, 7], expected = 3;
    const result2 = minimumDistances_solution2(arr);
    const result1 = minimumDistances_solution1(arr);
    expect(result2).toEqual(expected);
    expect(result1).toEqual(result2);
});

test("sample input 8", () => {
    const arr = [1,1], expected = 1;
    const result2 = minimumDistances_solution2(arr);
    const result1 = minimumDistances_solution1(arr);
    expect(result2).toEqual(expected);
    expect(result1).toEqual(result2);
});
