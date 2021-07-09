package hackerrank;

// https://www.hackerrank.com/challenges/cavity-map/problem

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CavityMap {

    public static List<String> cavityMap(List<String> grid) {
        var transformedGrid = new ArrayList<String>();
        transformedGrid.add(grid.get(0));  // add first row
        if (grid.size() == 1) return transformedGrid;
        for (int i = 1; i < grid.size()-1; i++) {
            var str = grid.get(i);
            transformedGrid.add( transformRow(str, grid.get(i-1), grid.get(i+1)) );
        }
        transformedGrid.add(grid.get(grid.size()-1));  // add last row
        return transformedGrid;
    }

    private static String transformRow(String row, String rowAbove, String rowBelow) {
        var transformedRow = new StringBuilder(row);
        var charArr = row.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            var isBorderCell = i == 0 || i == charArr.length-1;
            if (isBorderCell) continue;
            int v = Character.getNumericValue(charArr[i]);
            var isCavity = v > Character.getNumericValue(rowAbove.charAt(i)) && v > Character.getNumericValue(rowBelow.charAt(i))
                    && v > Character.getNumericValue(charArr[i-1]) && v > Character.getNumericValue(charArr[i+1]);
            if (isCavity)
                transformedRow.setCharAt(i, 'X');
        }
        return transformedRow.toString();
    }


    @Test
    @DisplayName("Test sample input 0")
    void test0() {
        var grid = List.of("1112", "1912", "1892", "1234");
        var expected = List.of("1112", "1X12", "18X2", "1234");
        var result = cavityMap(grid);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test sample input 1")
    void test1() {
        var grid = List.of("9");
        var expected = List.of("9");
        var result = cavityMap(grid);
        assertEquals(expected, result);
    }

}
