package codekata

func CountApplesAndOranges(s int, t int, a int, b int, apples []int, oranges []int) (int, int) {
	appleCount := 0;
	for _, apple := range apples {
		distance := apple + a;
		if  distance >= s && distance <= t {
			appleCount++;
		}
	}
	orangeCount := 0;
	for _, orange := range oranges {
		distance := orange + b;
		if  distance >= s && distance <= t {
			orangeCount++;
		}
	}
	return appleCount, orangeCount;
}

func Staircase(n int) [][]string {
	if (n == 0) {
		return nil
	}
	matrix := make([][]string, n)

	for row := 0; row < n; row++ {
		matrix[row] = make([]string, n)
		
		for col := 0; col < n; col++ {
			var value string
			if col >= ((n-row) - 1) {
				value = "#"
			} else {
				value = " "
			}
			matrix[row][col] = value;
		}

	}
	return matrix
}
