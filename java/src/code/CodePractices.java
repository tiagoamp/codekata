package code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodePractices {

	/* Given two positive different numbers: 
     * The number whose digits sum to a larger number is better than the other. 
     * If the sum of digits is equal for both numbers, then the smaller number is better. */
	public static int bestDivisor(int input) {     
		int[] divisors = IntStream.rangeClosed(1, input).filter(i -> input % i == 0).toArray();
        
		int[] sums = Arrays.stream(divisors).map(num -> {
				int sum = 0;
				while (num > 0) {
		            sum = sum + num % 10;
		            num = num / 10;
		        }
	            return sum;            
			}).toArray();

		int maxSummedNr = Arrays.stream(sums).max().getAsInt();
		
		int indexOfMaxSummedNr = 0;		
		while (sums[indexOfMaxSummedNr] != maxSummedNr) {
			indexOfMaxSummedNr++;
		}
		
		int bestNumber = divisors[indexOfMaxSummedNr];
		return bestNumber;
	}    
	
	
	/* Superdigit = sum of digits until its result has only 1 digit */
	public static int superdigit(String n, int k) {
		if (n.length() <= 1) return Integer.parseInt(n);
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			Integer digit = Character.getNumericValue(n.charAt(i));
			sum += digit;
		}		
		if (k > 1) sum *= k;
		return superdigit(String.valueOf(sum), 1);
	}
	
	
	public static int[] countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		int appleCount = 0;
		for (int i = 0; i < apples.length; i++) {
			int distance = apples[i] + a;
			if ( distance >= s && distance <= t ) appleCount++;
		}
		int orangeCount = 0;
		for (int i = 0; i < oranges.length; i++) {
			int distance = oranges[i] + b;
			if ( distance >= s && distance <= t ) orangeCount++;
		}
		return new int[] {appleCount, orangeCount};
    }
	
	
	// MinMaxSum function
    public static long[] minMaxSum(int[] arr) {
    	Arrays.sort(arr);
    	long min = 0, max = 0;
    	final int len = 5;    	
    	for (int i = 0; i < arr.length; i++) {
			if (i < len-1) {
				min += arr[i];
			}
			if (i > 0) {
				max += arr[i];
			}
		}
    	return new long[] {min,max};
    }
    
    /* Fibonacci starting at 0. Fibonacci series should be as follows: 0, 1, 1, 2, 3, 5, 8, 13, etc... */	
	public static int fibonacci(Integer n) {
		if (n == 0) return 0;
		else if (n == 1 || n == 2) return 1;
		else return fibonacci(n-2) + fibonacci(n-1);
	}
	
	public static Character[][] staircase(int n) {
		if (n == 0) return null;
		Character[][] stairMatrix = new Character[n][n];		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				stairMatrix[row][col] = col >= ( (n-row) - 1 ) ? '#' : ' ';
			}
		}		
		return stairMatrix;
	}
	
	public static int birthdayCakeCandles(int[] arr) {
		Arrays.sort(arr);
		int lastIndex = arr.length -1;
		int tallest = arr[lastIndex];
		int count = 0;		
		for (int i = lastIndex; i >= 0; i--) {
			if (arr[i] == tallest) count++;
			else break;			
		}		
		return count;
    }
	
	// kangaroo problem
    public static String kangaroo(int x1, int v1, int x2, int v2) {
    	if (x2 > x1 && v2 >= v1) return "NO";  // second kangaroo is and and is faster than the 1th one 
    	// x1 + n * v1 = x2 + n * v2 , then n = (x2-x1)%(v1-v2) must be == 0 to make them meet
    	String result = Math.abs((x2-x1)) % Math.abs((v1-v2)) == 0 ? "YES" : "NO";
    	return result;
    }
    
    public static int[] breakingRecords(int[] scores) {
    	int countMin = 0, countMax = 0;
    	int min = scores[0], max = scores[0];
    	
    	for (int i = 0; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				countMin++;
			} else if (scores[i] > max) {
				max = scores[i];
				countMax++;
			}
		}

    	return new int[]{countMax, countMin};
    }
    
    public static int sockMerchant(int n, int[] arr) {
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
    
    public static int minPrice(List<List<Integer>> cost) {
        if (cost == null || cost.isEmpty()) return 0;
        if (cost.size() == 1) return Collections.min(cost.get(0));
        
        int prevMin=0;
        int prevSec=0;
        int prevIndex=-1; 
     
        for(List<Integer> list : cost){ // for each blocks list
        	int currMin=Integer.MAX_VALUE, currSec = Integer.MAX_VALUE, currIndex = 0;
     
            for(int i = 0; i < list.size(); i++) { // for each color value
            	int val = list.get(i);
            	
                if(prevIndex == i){
                    val += prevSec;
                }else{
                    val += prevMin;
                }
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
    
    public static int birthdayChoc(List<Integer> s, int d, int m) {
    	int result = 0, index  = 0;
    	if (s == null || s.isEmpty()) return result;
    	boolean isOver = m > s.size();
    	while (!isOver) {    		
    		List<Integer> inner = s.subList(index, m);
    		Integer sum = inner.stream().reduce(0, (x,y) -> x+y);
    		if (sum.intValue() == d) result++;
    		index++;
    		m++;
    		isOver = m > s.size();
    	}    	
    	return result;
    }
    
    public static String[] bigSorting(String[] unsorted) {    	
    	Comparator<String> comparator = new Comparator<String>() {
    		public int compare(String a, String b) {
    			// different sizes
                if (a.length() != b.length()) 
                    return a.length() - b.length();
                // same sizes, compare per digits
                for (int i = 0; i < a.length(); i++) {
                	Integer digitFromA = Character.getNumericValue(a.charAt(i));
                	Integer digitFromB = Character.getNumericValue(b.charAt(i));
                    if (digitFromA != digitFromB) 
                    	return digitFromA - digitFromB;
                }
                // numbers are the same.
                return 0;
             }
		};    	
    	String[] result = Arrays.stream(unsorted).sorted(comparator).toArray(String[]::new);    	
        return result;
    }
    
    public static String catAndMouse(int x, int y, int z) {
    	int distanceCatAFromMouse = Math.abs(z - x);
    	int distanceCatBFromMouse = Math.abs(z - y);
    	if (distanceCatAFromMouse == distanceCatBFromMouse) return "Mouse C";
    	return distanceCatAFromMouse < distanceCatBFromMouse ? "Cat A" : "Cat B";
    }
    
    public static List<Integer> gradingStudents(List<Integer> grades) {
    	if (grades == null || grades.isEmpty()) return grades;
    	List<Integer> roundedGrades = grades.stream().map(n -> {
    		if (n < 38) {
    			return n;
    		} else {
    			int nextMultipleOfFive = (int) (5*Math.ceil(Double.valueOf(n)/5));
    			return (nextMultipleOfFive - n) < 3 ? nextMultipleOfFive : n;
    		}
    	}).collect(Collectors.toList());
    	return roundedGrades;
    }
    
    public static int hurdleRace(int k, int[] height) {
    	Arrays.sort(height);
    	int max = height[height.length-1];
    	return k >= max ? 0 : (max-k);
    }
    
    public static int utopianTree(int n) {
    	int result = 1;
    	if (n == 0) return result;
    	for(int i=1; i <=n; i++) {
    		boolean shouldDoubleSize = i%2 != 0; // odd numbers double size
    		result = shouldDoubleSize ? result * 2 : result + 1; 
    	}
    	return result;
    }

    public static int formingMagicSquare(int[][] s) {
    	int costs[] = {0,0,0,0,0,0,0,0};
        int magicSquares[][] = 
        { {2,7,6,9,5,1,4,3,8}, {6,7,2,1,5,9,8,3,4}, {8,3,4,1,5,9,6,7,2}, {4,3,8,9,5,1,2,7,6},
          {6,1,8,7,5,3,2,9,4}, {2,9,4,7,5,3,6,1,8}, {4,9,2,3,5,7,8,1,6}, {8,1,6,3,5,7,4,9,2}
        };
        for(int i=0;i<magicSquares.length;i++) {        
        	costs[i] = Math.abs(magicSquares[i][0]-s[0][0]) + Math.abs(magicSquares[i][1]-s[0][1]) + Math.abs(magicSquares[i][2]-s[0][2]);
        	costs[i] = costs[i] + Math.abs(magicSquares[i][3]-s[1][0]) + Math.abs(magicSquares[i][4]-s[1][1]) + Math.abs(magicSquares[i][5]-s[1][2]);
        	costs[i] = costs[i] + Math.abs(magicSquares[i][6]-s[2][0]) + Math.abs(magicSquares[i][7]-s[2][1]) + Math.abs(magicSquares[i][8]-s[2][2]);
        }   
        int minCost = Arrays.stream(costs).min().getAsInt();
        return minCost;
    }
    
    public static int pickingNumbers(List<Integer> a) {
        Map<Integer, Integer> map = new TreeMap<>();
        a.forEach(i -> {
        	Integer qtt = map.getOrDefault(i, 0);
        	map.put(i, qtt+1);
        });
        int maxRange = map.keySet().stream()
        		.map(k -> map.get(k) + map.getOrDefault(k+1, 0)).max(Integer::compare).get();
        return maxRange;
    }
    
    public static int[] climbingLeaderboard(int[] scores, int[] alice) {
    	int[] uniqueScores = Arrays.stream(scores).distinct().toArray();
    	int[] result = new int[alice.length];
    	int i = uniqueScores.length-1;
        for(int j=0; j<alice.length; j++) {
        	int  a = alice[j];
            while(i>=0) {
                if(a>=uniqueScores[i]) 
                	i--;
                else {
                	result[j] = i+2; 
                	break;
                }
            }
            if(i<0) result[j] = 1;;
        }
        return result;
    }
        
}
