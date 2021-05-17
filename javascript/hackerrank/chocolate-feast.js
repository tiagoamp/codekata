// https://www.hackerrank.com/challenges/chocolate-feast/problem

function chocolateFeast(n, c, m) {
    if (n < c) return 0;
    let totalBars = Math.trunc( n / c ) ;
    let wrappersToExchange = totalBars;
    while (wrappersToExchange >= m) {
        const remainderWrapper = wrappersToExchange % m;
        wrappersToExchange = Math.trunc( wrappersToExchange / m );
        totalBars += wrappersToExchange;
        wrappersToExchange += remainderWrapper;
    }
    return totalBars;
}


test("sample 0", () => {
    const n = [ 10, 12, 6 ], c = [ 2, 4, 2 ], m = [ 5, 4, 2 ], expected = [ 6, 3, 5 ];
    for (let i = 0; i<expected.length; i++) {
        const result = chocolateFeast(n[i], c[i], m[i])
        expect(result).toBe(expected[i]);
    }
});
