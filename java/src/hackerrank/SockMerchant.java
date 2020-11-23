package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


//https://www.hackerrank.com/challenges/sock-merchant/problem
public class SockMerchant {
	
	@Test
	@DisplayName("Test sample 1")
	void testSockMerchant1() {
		int n = 9;
		int[] arr = {10, 20, 20, 10, 10, 30, 50, 10, 20};
		int result1 = sockMerchant_Solution1(n, arr);
		int result2 = sockMerchant_Solution2(n, arr);
		assertEquals(3, result1);
		assertEquals(3, result2);		
	}
	
	@Test
	@DisplayName("Test sample 2")
	void testSockMerchant2() {
		int n = 10;
		int[] arr = {1, 1, 3, 1, 2, 1, 3, 3, 3, 3};
		int result1 = sockMerchant_Solution1(n, arr);
		int result2 = sockMerchant_Solution1(n, arr);
		assertEquals(4, result1);
		assertEquals(4, result2);
	}
	
	
	public static int sockMerchant_Solution1(int n, int[] arr) {
    	Set<Integer> colors = new HashSet<>();
        int pairs = 0;
        for (int i = 0; i < n; i++) {
            if (!colors.contains(arr[i])) {
                colors.add(arr[i]);
            } else {
                pairs++;
                colors.remove(arr[i]);
            }
        }
        return pairs;
    }
	
	public static int sockMerchant_Solution2(int n, int[] arr) {
    	Set<Integer> colors = new HashSet<>();
        int pairs = 0;
        for (int i = 0; i < n; i++) {        	
        	boolean didNotAlreadyContainEl = colors.add(arr[i]);
        	if (!didNotAlreadyContainEl) {
        		pairs++;
                colors.remove(arr[i]);
        	}
        }
        return pairs;
	}

}
