package hackerrank;

// https://www.hackerrank.com/challenges/reduced-string/problem

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReducedString {

    public static String superReducedString(String s) {
        var r = s;
        var wasReduced = true;
        while (wasReduced) {
            var tokens = breakInRepeatedTokens(r);
            var reducedStr = "";
            for (String token: tokens) {
                if (isOdd(token.length()))
                    reducedStr += String.valueOf(token.charAt(0));
            }
            wasReduced = !reducedStr.equals(r);
            r = reducedStr;
        }
        return r == "" ? "Empty String" : r;
    }

    private static List<String> breakInRepeatedTokens(String value)  {
        var tokens = new ArrayList<String>();
        if (value.isEmpty()) return tokens;
        var token = "";
        var arr = value.toCharArray();
        var currCh = Character.valueOf(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            var ch = arr[i];
            if (ch == currCh.charValue()) {
                token += ch;
                continue;
            }
            tokens.add(token);
            token = "" + Character.valueOf(ch);
            currCh = ch;
        }
        tokens.add(token);
        return tokens;
    }

    private static boolean isOdd(Integer value) {
        return value % 2 != 0;
    }


    @Test
    @DisplayName("Test samples")
    void test0() {
        var input = List.of("aaabccddd", "aa", "baab");
        var expected = List.of("abd", "Empty String", "Empty String");
        for (int i = 0; i < expected.size(); i++) {
            var s = input.get(i);
            var result = superReducedString(s);
            assertEquals(expected.get(i), result);
        }
    }


}
