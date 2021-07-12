// https://www.hackerrank.com/challenges/cavity-map/problem

function cavityMap(grid) {
    return grid.map( (str, index) => {
        if (index == 0 || index == (grid.length-1)) return str
        else return transformRow(str, grid[index-1], grid[index + 1])
    });
}

const transformRow = (row, rowAbove, rowBelow) => {
    var transformedRow = row;
    row.split('').forEach( (value, index) => {
        const isBorderCell = index == 0 || index == row.length-1;
        if (isBorderCell) return;
        const v = +value;
        const isCavity = v > +rowAbove[index] && v > +rowBelow[index]
                && v > +row[index-1] && v > +row[index+1];
        if (isCavity)
            transformedRow = setCharAtPosition(index, 'X', transformedRow);
    });
    return transformedRow;
}

const setCharAtPosition = (index, char, string) => {
    return string.substring(0, index) + char + string.substring(index + 1);
}


test("sample 0", () => {
	const grid = ["1112", "1912", "1892", "1234"];
    const expected = ["1112", "1X12", "18X2", "1234"];
    const result = cavityMap(grid);
	expect(result).toEqual(expected);
});

test("sample 1", () => {
	const grid = ["9"];
    const expected = ["9"];
    const result = cavityMap(grid);
	expect(result).toEqual(expected);
});

test("sample 21", () => {
	const grid     = ["179443854", "961621369", "164139922", "968633951", "812882578", "257829163", "812438597", "176656233", "485773814"];
    const expected = ["179443854", "961X21369", "164139922", "96X633951", "812882578", "25782X163", "8124385X7", "176656233", "485773814"];
    const result = cavityMap(grid);
	expect(result).toEqual(expected);
});

