package codekata

import (
	"testing"
)

func TestCountApplesAndOranges(t *testing.T) {
	type testpair struct {
		values      []int
		appleArr    []int
		orangeArr   []int
		resultCount []int
	}

	var tests = []testpair{
		{[]int{7, 11, 5, 15}, []int{-2, 2, 1}, []int{5, -6}, []int{1, 1}}, // sample test case
		{[]int{2, 3, 1, 5}, []int{2}, []int{-2}, []int{1, 1}},             // test case 2
	}

	for _, pair := range tests {
		v1, v2 := CountApplesAndOranges(pair.values[0], pair.values[1], pair.values[2], pair.values[3], pair.appleArr, pair.orangeArr)
		if v1 != pair.resultCount[0] || v2 != pair.resultCount[1] {
			t.Error("For", pair.values, "expected", pair.resultCount, "got", v1, ",", v2)
		}
	}

}
func TestStaircase(t *testing.T) {
	n := 6
	result := Staircase(n)

	for i := 0; i < n; i++ {
		value := result[0][i]
		if i >= 5 && value != "#" {
			t.Error("For [0][", i, "] expected", "#", "got", value)
		} else if i < 5 && value != " " {
			t.Error("For [0][", i, "] expected", " ", "got", value)
		}
	}

	for i := 0; i < n; i++ {
		value := result[1][i]
		if i >= 4 && value != "#" {
			t.Error("For [1][", i, "] expected", "#", "got", value)
		} else if i < 4 && value != " " {
			t.Error("For [1][", i, "] expected", " ", "got", value)
		}
	}

	for i := 0; i < n; i++ {
		value := result[5][i]
		if i >= 0 && value != "#" {
			t.Error("For [5][", i, "] expected", "#", "got", value)
		} else if i < 0 && value != " " {
			t.Error("For [5][", i, "] expected", " ", "got", value)
		}
	}

}
func TestMinMaxSum(t *testing.T) {
	type testpair struct {
		values []int
		result []int64
	}

	var tests = []testpair{
		{[]int{1, 2, 3, 4, 5}, []int64{10, 14}},
	}

	for _, pair := range tests {
		v1, v2 := MinMaxSum(pair.values)
		if v1 != pair.result[0] || v2 != pair.result[1] {
			t.Error("For", pair.values, "expected", pair.result, "got", v1, ",", v2)
		}
	}
}
func TestFibonacci(t *testing.T) {
	const value, expectedVal = 10, 55
	result := Fibonacci(value)
	if result != expectedVal {
		t.Error("For", value, "expected", expectedVal, "got", result)
	}
}

func TestBreakingRecords(t *testing.T) {
	type testpair struct {
		values    []int
		resultMax int
		resultMin int
	}

	var tests = []testpair{
		{[]int{10, 5, 20, 20, 4, 5, 2, 25, 1}, 2, 4},
		{[]int{3, 4, 21, 36, 10, 28, 35, 5, 24, 42}, 4, 0},
	}

	for _, pair := range tests {
		v1, v2 := BreakingRecords(pair.values)
		if v1 != pair.resultMax || v2 != pair.resultMin {
			t.Error("For", pair.values, "expected", pair.resultMax, pair.resultMin, "got", v1, ",", v2)
		}
	}
}

func TestBirthdayChoc(t *testing.T) {
	type testpair struct {
		inputArr []int
		d        int
		m        int
		result   int
	}

	var tests = []testpair{
		{[]int{1, 2, 1, 3, 2}, 3, 2, 2},
		{[]int{1, 1, 1, 1, 1, 1}, 3, 2, 0},
		{[]int{2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1}, 18, 7, 3},
	}

	for _, pair := range tests {
		v := birthdayChoc(pair.inputArr, pair.d, pair.m)
		if v != pair.result {
			t.Error("For", pair.inputArr, "expected", pair.result, "got", v)
		}
	}
}

func TestBigSorting(t *testing.T) {
	input := []string{"2", "100", "1"}
	result := bigSorting(input)
	if result[0] != 1 {
		t.Error("For index 0 expected 1 got", result[0])
	}
	if result[1] != 2 {
		t.Error("For index 1 expected 2 got", result[0])
	}
	if result[2] != 100 {
		t.Error("For index 2 expected 100 got", result[0])
	}
}

func TestCatAndMouse(t *testing.T) {
	type testpair struct {
		x      int
		y      int
		z      int
		result string
	}

	var tests = []testpair{
		{1, 2, 3, "Cat B"},
		{1, 3, 2, "Mouse C"},
	}

	for _, pair := range tests {
		v := catAndMouse(pair.x, pair.y, pair.z)
		if v != pair.result {
			t.Error("For", pair, "expected", pair.result, "got", v)
		}
	}
}

func TestGradingStudents(t *testing.T) {
	input := []int{73, 67, 38, 33}
	expected := []int{75, 67, 40, 33}
	result := gradingStudents(input)
	for i, val := range result {
		if result[i] != expected[i] {
			t.Error("For index", i, "expected", expected[i], " got", val)
		}
	}
}

