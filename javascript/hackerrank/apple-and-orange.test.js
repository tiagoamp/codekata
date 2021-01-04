// https://www.hackerrank.com/challenges/apple-and-orange/problem

countApplesAndOranges = (s, t, a, b, apples, oranges) => {
    let appleCount = 0;
    for (let i = 0; i < apples.length; i++) {
        let distance = apples[i] + a;
        if ( distance >= s && distance <= t ) appleCount++;
    }
    let orangeCount = 0;
    for (let i = 0; i < oranges.length; i++) {
        let distance = oranges[i] + b;
        if ( distance >= s && distance <= t ) orangeCount++;
    }
    return [appleCount, orangeCount];
}


test("CountApplesAndOranges", () => {
    // sample case
    let s = 7, t = 11;  // house
    let a = 5, b = 15;  // tree
    let apples = [-2, 2, 1];   // fruits array
    let oranges = [5, -6];     // fruits array
    let result = countApplesAndOranges(s, t, a, b, apples, oranges);
    expect(result[0]).toEqual(1);
    expect(result[1]).toEqual(1);
    // test case 2
    s = 2; t = 3; a = 1; b = 5;
    apples = [2]; oranges = [-2];
    result = countApplesAndOranges(s, t, a, b, apples, oranges);
    expect(result[0]).toEqual(1);
    expect(result[1]).toEqual(1);
});
