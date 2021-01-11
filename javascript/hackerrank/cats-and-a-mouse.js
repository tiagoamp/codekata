// https://www.hackerrank.com/challenges/cats-and-a-mouse/problem

const catAndMouse = (x, y, z) => {
    const distanceCatAFromMouse = Math.abs(z - x);
    const distanceCatBFromMouse = Math.abs(z - y);
    if (distanceCatAFromMouse == distanceCatBFromMouse) return "Mouse C";
    return distanceCatAFromMouse < distanceCatBFromMouse ? "Cat A" : "Cat B";
}


test("sample 0", () => {
    const x = 1, y = 2, z = 3;
	const result = catAndMouse(x, y, z);
	expect(result).toEqual("Cat B");
});

test("sample 1", () => {
    const x = 1; y = 3; z = 2;
    const result = catAndMouse(x, y, z);
    expect(result).toEqual("Mouse C");
});
