package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MinPrice {
	
	@Test
	@DisplayName("Test sample 0")
	void testMinPrice0() {
		List<List<Integer>> cost = new ArrayList<>();
		cost.add( Arrays.asList(1,2,2) );
		cost.add( Arrays.asList(2,2,1) );
		cost.add( Arrays.asList(2,1,2) );
		int result = minPrice(cost);
		assertEquals(3, result);
	}
	
	@Test
	@DisplayName("Test sample 1")
	void testMinPrice1() {
		List<List<Integer>> cost = new ArrayList<>();
		// sample 1
		cost.clear();
		cost.add( Arrays.asList(1,2,2) );
		cost.add( Arrays.asList(2,3,3) );
		cost.add( Arrays.asList(3,3,1) );
		int result = minPrice(cost);
		assertEquals(5, result);
	}

	@Test
	@DisplayName("Test sample 2")
	void testMinPrice2() {
		List<List<Integer>> cost = new ArrayList<>();
		cost.add( Arrays.asList(1,10,20) );
		cost.add( Arrays.asList(2,100,100) );
		int result = minPrice(cost);
		assertEquals(12, result);
	}
	
	
	public static int minPrice(List<List<Integer>> cost) {
        if (cost == null || cost.isEmpty()) return 0;
        if (cost.size() == 1) return Collections.min(cost.get(0));
        
        int prevMin=0 , prevSec=0, prevIndex=-1; 
     
        for(List<Integer> list : cost){ // for each blocks list
        	int currMin=Integer.MAX_VALUE, currSec = Integer.MAX_VALUE, currIndex = 0;
     
            for(int i = 0; i < list.size(); i++) { // for each color value
            	int val = list.get(i);
            	
                if(prevIndex == i) val += prevSec;
                else val += prevMin;
                list.set(i, val);
     
                if(currMin > val){
                    currSec = currMin;
                    currMin = val;
                    currIndex = i;
                } else if(currSec > val ){
                    currSec = val;
                }
            }
     
            prevMin = currMin;
            prevSec = currSec;
            prevIndex = currIndex;
        }
     
        int result = Collections.min( cost.get(cost.size()-1) );
        return result;        
    }
	
}
