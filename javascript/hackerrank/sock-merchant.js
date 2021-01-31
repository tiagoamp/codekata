// https://www.hackerrank.com/challenges/sock-merchant/problem

const sockMerchant = (n, arr) => {
    const colors = [];
    let pairs = 0;
    for (let i = 0; i < n; i++) {
        if (!colors.includes(arr[i])) {
            colors.push(arr[i]);
        } else {
            pairs++;
            const index = arr.indexOf(arr[i]);
            colors.splice(index, 1);
        }
    }
    return pairs;
}


test("sample 0", () => {
    const n = 9;
    const arr = [10, 20, 20, 10, 10, 30, 50, 10, 20];
    const result = sockMerchant(n, arr);
    expect(result).toEqual(3);
});

test("sample 1", () => {
    const n = 10;
    const arr = [1, 1, 3, 1, 2, 1, 3, 3, 3, 3];
    const result = sockMerchant(n, arr);
    expect(result).toEqual(4);
});
