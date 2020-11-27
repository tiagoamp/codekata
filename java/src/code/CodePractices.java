package code;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CodePractices {

	static int findDigits(int n) {
		int curr = n, counter = 0;
		while (curr > 0) {
		    if ( (curr % 10 != 0) && (n % (curr % 10) == 0) )
		    	counter++;
		    curr = curr / 10;
		}
		return counter;
    }
	
	static int lowestTriangle(int base, int area){
		return (int) Math.ceil( (area * 2.0) / (float)base ) ;
    }
	
	public static int maximumDraws(int n) {
        return ( (n * 2) / 2 ) + 1;
    }
	
	public static List<String> fizzbuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
            if (i >= (3*5) && i % 3 == 0 && n % 5 == 0) 
                result.add("FizzBuzz");
            else if (i >= 3 && i % 3 == 0)
            	result.add("Fizz");
            else if (i >= 5 && i % 5 == 0)
            	result.add("Buzz");
            else 
            	result.add(String.valueOf(i));
        }
		return result;
	}
	
	public static String bonAppetit(List<Integer> bill, int k, int b) {
		Integer total = bill.stream().reduce(0, (acc, e) -> acc + e);
		Integer actualCharge = (total - bill.get(k)) / 2; 
		return (b == actualCharge) ? "Bon Appetit" : String.valueOf(b - actualCharge);
    }
	
	public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		List<Integer> results = new ArrayList<>();
		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				int sum = keyboards[i] + drives[j];
				if (b >= sum) results.add(sum);
			}
		}
		return results.isEmpty() ? -1 : Collections.max(results);
	}
	
	public static String[] plusMinus(int[] arr) {
		int positives = 0, negatives = 0, zeros = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) zeros++;
			else if (arr[i] > 0) positives++;
			else negatives++;
		}
		int length = arr.length;
		String[] results = new String[3];
		results[0] = String.format(Locale.US, "%.06f", ((double) positives) / ((double) length));
		results[1] = String.format(Locale.US, "%.06f", ((double) negatives) / ((double) length));
		results[2] = String.format(Locale.US, "%.06f", ((double) zeros) / ((double) length));
		return results;
    }
	
	public static int countingValleys(int n, String s) {
		int countOfValleys = 0, path = 0, seaLevel = 0;
		boolean enteredValley = false;		
		for (int i = 0; i < n; i++) {
			Character letter = s.charAt(i);
			if (letter.equals('U')) path += 1;
			else if (letter.equals('D')) path -= 1;
			if (path == seaLevel && enteredValley)
				countOfValleys++;
			enteredValley = path < 0;
		}
		return countOfValleys;
    }
	
	public static String getSmallestAndLargest(String s, int k) {
        List<String> substrings = new ArrayList<>();
        for(int i=0; i<=s.length()-k; i++) 
        	substrings.add(s.substring(i, i+k));
        String smallest = substrings.stream().sorted().min(String::compareTo).get();
        String largest = substrings.stream().sorted().max(String::compareTo).get();
        return smallest + "\n" + largest;
    }
	
	public static boolean isAnagram(String a, String b) {
    	if (a.length() != b.length()) return false;
    	int len = a.length();
    	Map<Character, Integer> resultFrequency = new HashMap<>();
    	for(int i=0; i<len; i++) 
    		resultFrequency.compute(a.toLowerCase().charAt(i), (k,v) -> (v == null) ? 1 : v+1);
    	for(int i=0; i<len; i++) 
    		resultFrequency.computeIfPresent(b.toLowerCase().charAt(i), (k,v) -> v-1);
    	Integer absSum = resultFrequency.values().stream().reduce(0, (x,y) -> Math.abs(x)+Math.abs(y));
    	return absSum == 0;
    }
	
	public static String pangrams(String s) {
    	final String letters = "abcdefghijklmnopqrstuvxywz";
    	char[] charArr = letters.toCharArray();
    	int[] qt = new int[charArr.length];    	
    	if (s == null || s.length() < charArr.length)
    		return "not pangram";    	
    	for (int i=0; i<s.length(); i++) {
    		char currChar = s.toLowerCase().charAt(i);
    		for(int j=0; j<charArr.length; j++) {
    			if (currChar == charArr[j]) {
    				qt[j]++;
    				break;
    			}
    		}
    	}    	
    	boolean result = true;
    	for(int j=0; j<charArr.length; j++) 
    		result = result && (qt[j] > 0);
    	return result ? "pangram" : "not pangram";	
    }
	
	public static int minimumNumber(int n, String password) {
    	final int MIN_PASS_LEN = 6;
    	int minCharstoAdd = 0;
    	if (!Pattern.compile("[0-9]").matcher(password).find()) minCharstoAdd++;
    	if (!Pattern.compile("[a-z]").matcher(password).find()) minCharstoAdd++;
    	if (!Pattern.compile("[A-Z]").matcher(password).find()) minCharstoAdd++;
    	if (!Pattern.compile("[!@#\\$%^&*()\\-\\+]").matcher(password).find()) minCharstoAdd++;
    	if ( (password.length() + minCharstoAdd) < MIN_PASS_LEN )
    		minCharstoAdd += MIN_PASS_LEN - (password.length() + minCharstoAdd);
    	return minCharstoAdd;
    }
	
	public static String timeConversion(String s) {
    	if (s.endsWith("AM")) {
        	if (s.startsWith("12:")) {
        		String[] timeFields = s.split(":");
                timeFields[0] = "00";
                s = String.join(":", timeFields);
        	}
        	return s.replace("AM", "");
        }
        // pm
        if (s.startsWith("12:")) return s.replace("PM", "");
        s = s.replace("PM", "");
        String[] timeFields = s.split(":");
        timeFields[0] = String.valueOf(Integer.valueOf(timeFields[0]) + 12);
        return String.join(":", timeFields);
    }
	
	public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
    	// if board size just fit the queen spot, return 0 
    	if (n == 0 || n == 1) return 0;
    	
    	// if there are no obstacles, return all queen's cells to be attacked
    	if (k == 0) {
    		int qRowsCount = (n-1) + (n-1);
    		int qDiagCount = Integer.min( n - r_q , c_q - 1 ) + Integer.min( r_q - 1 , c_q - 1 ) + 
    						 Integer.min( n - r_q , n - c_q ) + Integer.min( r_q - 1, n - c_q );
    		return qRowsCount + qDiagCount;
    	}
    	
    	// Identify the closest obstacle in each 8 directions
    	int min_distance_ob_left = c_q-1, min_distance_ob_right = n-c_q, min_distance_ob_up = n-r_q, min_distance_ob_down = r_q-1, 
    		min_distance_ob_left_up = Integer.min(n - r_q , c_q - 1), min_distance_ob_left_down = Integer.min(r_q - 1 , c_q - 1), 
    		min_distance_ob_right_up = Integer.min(n - r_q , n - c_q), min_distance_ob_right_down = Integer.min(r_q - 1, n - c_q);
    	
    	for (int i=0; i<k; i++) {
    		int r_o = obstacles[i][0], c_o = obstacles[i][1];
    		
    		// case same row
    		if (r_o == r_q) {   
    			if ( (c_o < c_q) && ((c_q - c_o - 1) < min_distance_ob_left) ) {       
    				min_distance_ob_left = c_q - c_o - 1;
    			} else if ( (c_o > c_q) && ((c_o - c_q - 1) < min_distance_ob_right) ) {  
    				min_distance_ob_right = c_o - c_q - 1;
    			}
    		}    		
    		// case same column
    		if (c_o == c_q) {   
    			if ( (r_o > r_q) && ((r_o - r_q - 1) < min_distance_ob_up) ) {            
    				min_distance_ob_up = r_o - r_q - 1;
    			} else if ( (r_o < r_q) && ((r_q - r_o - 1) < min_distance_ob_down) ) {  
    				min_distance_ob_down = r_q - r_o - 1;
    			}
    		}    		
    		// case same diagonals
    		if (Math.abs(r_q - r_o) == Math.abs(c_q - c_o)) {
    			int distance = (Math.abs(r_q - r_o) - 1);
    			if ( ((r_o > r_q) && (c_o < c_q)) && (distance < min_distance_ob_left_up) ) 
    				min_distance_ob_left_up = distance;
    			else if ( ((r_o < r_q) && (c_o < c_q)) && (distance < min_distance_ob_left_down) ) 
    				min_distance_ob_left_down = distance;
    			else if ( ((r_o > r_q) && (c_o > c_q)) && (distance < min_distance_ob_right_up) ) 
    				min_distance_ob_right_up = distance;
    			else if ( ((r_o < r_q) && (c_o > c_q)) && (distance < min_distance_ob_right_down) ) 
    				min_distance_ob_right_down = distance;    			
    		}
    	}
    	
    	int sum = min_distance_ob_left + min_distance_ob_right + min_distance_ob_up + min_distance_ob_down +   
        		  min_distance_ob_left_up + min_distance_ob_left_down + min_distance_ob_right_up + min_distance_ob_right_down;
    	return sum;
    }
	
	public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    	if (y1 > y2) return 10_000;
    	LocalDate returnedDate = LocalDate.of(y1, m1, d1);
    	LocalDate dueDate = LocalDate.of(y2, m2, d2);
    	if (returnedDate.isBefore(dueDate) || returnedDate.isEqual(dueDate))
    		return 0;
    	if (returnedDate.getMonth() == dueDate.getMonth()) {
    		int daysLate = Period.between(dueDate, returnedDate).getDays();
    		return 15 * daysLate;
    	}
    	int monthsLate = m1-m2;
    	return 500 * monthsLate;
    }
	
	public static long repeatedString(String s, long n) {
    	if (s.length() == 1) return s.equals("a") ? n : 0L;
    	if (!s.contains("a")) return 0L;
    	long count = 0;
    	for (char ch : s.toCharArray()) 
			if (ch == 'a') count++;
        long d = n / s.length();
        long r =  n % s.length();
        count *=  d;
        for(int i=0;i<r;i++)
            if(s.charAt(i) == 'a') count++;
        return count;
    }
	
	public static String appendAndDelete(String s, String t, int k) {
    	if (s.equals(t)) {
    		if (k > s.length()) return k > 2 ? "Yes" : "No";
    		else return k%2 == 0 ? "Yes" : "No"; 
    	}    		
    	int commonChars = -1;  // find out index until 't' equals 's' 
    	for (int i = 0; i < s.length(); i++) {
    		if ( (i > (t.length()-1)) || s.charAt(i) != t.charAt(i) )
    			break;
			commonChars++;  // increment if same char in both strings
		}
    	String diffOfS = s.substring(commonChars+1);
    	String diffOfT = t.substring(commonChars+1);
    	if (diffOfS.length() == 0) {
    		return k >= diffOfT.length() && (k - diffOfT.length())%2 == 0 ? "Yes": "No";
    	} else if (diffOfT.length() == 0) {
    		return k >= diffOfS.length() && (k > s.length() || (k - diffOfS.length())%2 == 0) ? "Yes": "No";
    	} 
    	if (k > diffOfS.length()+diffOfT.length()) return k > 2 ? "Yes" : "No";
    	return (k >= diffOfS.length()+diffOfT.length()) && (k - diffOfS.length()+diffOfT.length())%2==0 ? "Yes" : "No";
    }
	
	public static int saveThePrisoner(int n, int m, int s) {
    	int r = s + (m-1);
    	if (r <= n) return r;
    	return (r%n == 0) ? n : r%n;
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
            if(i<0) result[j] = 1;
        }
        return result;
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
	
	public static int utopianTree(int n) {
    	int result = 1;
    	if (n == 0) return result;
    	for(int i=1; i <=n; i++) {
    		boolean shouldDoubleSize = i%2 != 0; // odd numbers double size
    		result = shouldDoubleSize ? result * 2 : result + 1; 
    	}
    	return result;
    }
	
	public static int hurdleRace(int k, int[] height) {
    	Arrays.sort(height);
    	int max = height[height.length-1];
    	return k >= max ? 0 : (max-k);
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
		
}
