package codekata

import ( "testing" )


func TestCountApplesAndOranges(t *testing.T) {
    type testpair struct {
        values []int
        appleArr []int
        orangeArr []int
        resultCount []int
    }
    
    var tests = []testpair{
        { []int{7,11,5,15}, []int {-2, 2, 1}, []int {5, -6}, []int{1,1} },  // sample test case
        { []int{2,3,1,5}, []int {2}, []int {-2}, []int{1,1} },  // test case 2
    }

    for _, pair := range tests {
        v1, v2 := CountApplesAndOranges(pair.values[0], pair.values[1], pair.values[2], pair.values[3], pair.appleArr, pair.orangeArr)
        if v1 != pair.resultCount[0] || v2 != pair.resultCount[1] {
            t.Error(
            "For", pair.values, "expected", pair.resultCount, "got", v1, ",", v2 )
        }
    }

}

func TestStaircase(t *testing.T) {
    n := 6
    result := Staircase(n)

    for i := 0; i < n; i++ {
        value := result[0][i]
        if (i >= 5 && value != "#") {
            t.Error( "For [0][", i, "] expected", "#", "got", value )
        } else if (i < 5 && value != " ") {
            t.Error( "For [0][", i, "] expected", " ", "got", value )
        }
    }
    
    for i := 0; i < n; i++ {
        value := result[1][i]
        if (i >= 4 && value != "#") {
            t.Error( "For [1][", i, "] expected", "#", "got", value )
        } else if (i < 4 && value != " ") {
            t.Error( "For [1][", i, "] expected", " ", "got", value )
        }
    }

    for i := 0; i < n; i++ {
        value := result[5][i]
        if (i >= 0 && value != "#") {
            t.Error( "For [5][", i, "] expected", "#", "got", value )
        } else if (i < 0 && value != " ") {
            t.Error( "For [5][", i, "] expected", " ", "got", value )
        }
    }
}

func TestMinMaxSum(t *testing.T) {
    type testpair struct {
        values []int
        result []int64
    }
    
    var tests = []testpair{
        { []int{1, 2, 3, 4, 5}, []int64{10, 14} },
    }

    for _, pair := range tests {
        v1, v2 := MinMaxSum(pair.values)
        if v1 != pair.result[0] || v2 != pair.result[1] {
            t.Error( "For", pair.values, "expected", pair.result, "got", v1, ",", v2 )
        }
    }
}
