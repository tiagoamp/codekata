package codekata

import ( "testing" )


func TestCountApplesAndOranges(t *testing.T) {
    // sample case
    s1 := 7; t1 := 11;  // house 
    a1 := 5; b1 := 15;  // tree
    apples := []int {-2, 2, 1}   // fruits array
    oranges := []int {5, -6}     // fruits array
    appleCount, orangeCount := CountApplesAndOranges(s1, t1, a1, b1, apples, oranges)    
    if appleCount != 1 {
        t.Errorf("Result of apple count is incorrect, got: %d, want: %d.", appleCount, 1)
    }
    if orangeCount != 1 {
        t.Errorf("Result of orange count is incorrect, got: %d, want: %d.", orangeCount, 1)
    }
    // test case 2
    s2 := 2; t2 := 3;
    a2 := 1; b2 := 5;
    apples = []int {2};
    oranges = []int {-2};
    appleCount, orangeCount = CountApplesAndOranges(s2, t2, a2, b2, apples, oranges);
    if appleCount != 1 {
        t.Errorf("Result of apple count is incorrect, got: %d, want: %d.", appleCount, 1)
    }
    if orangeCount != 1 {
        t.Errorf("Result of orange count is incorrect, got: %d, want: %d.", orangeCount, 1)
    }    
}

