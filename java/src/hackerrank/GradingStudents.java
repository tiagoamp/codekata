package hackerrank;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/grading/problem
public class GradingStudents {
	
	@Test
	@DisplayName("Test given samples")
	public void testGradingStudents() {
		List<Integer> input = Arrays.asList(73, 67, 38, 33);
		List<Integer> expected = Arrays.asList(75, 67, 40, 33);
		List<Integer> result = gradingStudents(input);
		for (int i = 0; i < result.size(); i++) 
			assertEquals(expected.get(i), result.get(i));
	}

	public static List<Integer> gradingStudents(List<Integer> grades) {
    	if (grades == null || grades.isEmpty()) return grades;
    	List<Integer> roundedGrades = grades.stream().map(n -> {
    		if (n < 38) 
    			return n;
    		int nextMultipleOfFive = (int) (5*Math.ceil(Double.valueOf(n)/5));
    		return (nextMultipleOfFive - n) < 3 ? nextMultipleOfFive : n;    		
    	}).collect(toList());
    	return roundedGrades;
    }
	
}
