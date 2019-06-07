package codekata

import "sort"

func CountApplesAndOranges(s int, t int, a int, b int, apples []int, oranges []int) (int, int) {
	appleCount := 0
	for _, apple := range apples {
		distance := apple + a
		if distance >= s && distance <= t {
			appleCount++
		}
	}
	orangeCount := 0
	for _, orange := range oranges {
		distance := orange + b
		if distance >= s && distance <= t {
			orangeCount++
		}
	}
	return appleCount, orangeCount
}

func Staircase(n int) [][]string {
	if n == 0 {
		return nil
	}
	matrix := make([][]string, n)

	for row := 0; row < n; row++ {
		matrix[row] = make([]string, n)

		for col := 0; col < n; col++ {
			var value string
			if col >= ((n - row) - 1) {
				value = "#"
			} else {
				value = " "
			}
			matrix[row][col] = value
		}

	}
	return matrix
}

func MinMaxSum(arr []int) (int64, int64) {
	sort.Ints(arr)
	var min, max int64 = 0, 0
	const len int = 5
	for i, val := range arr {
		if i < len-1 {
			min += int64(val)
		}
		if i > 0 {
			max += int64(val)
		}
	}
	return min, max
}

func Fibonacci(n int) int {
	if n == 0 {
		return 0
	} else if n == 1 || n == 2 {
		return 1
	} else {
		return Fibonacci(n-2) + Fibonacci(n-1)
	}
}

func BreakingRecords(scores []int) (int, int) {
	countMin, countMax := 0, 0
	min, max := scores[0], scores[0]

	for _, val := range scores {
		if val < min {
			min = val
			countMin++
		} else if val > max {
			max = val
			countMax++
		}
	}

	return countMax, countMin
}

func birthdayChoc(s []int, d int, m int) int {
	result, index := 0, 0
	var isOver bool = m > len(s)
	for !isOver {
		var inner = s[index:m]
		var sum = 0
		for _, v := range inner {
			sum += v
		}
		if sum == d {
			result++
		}
		index++
		m++
		isOver = m > len(s)
	}
	return result
}

func bigSorting(unsorted []string) []int {
	var arr = make([]int, len(unsorted))
	for i, val := range unsorted {
		var v, _ = strconv.Atoi(val)
		arr[i] = v
	}
	sort.Ints(arr)
	return arr
}

func catAndMouse(x int, y int, z int) string {
	distanceCatAFromMouse := z - x
	distanceCatBFromMouse := z - y
	if distanceCatAFromMouse < 0 {
		distanceCatAFromMouse = -1 * distanceCatAFromMouse
	}
	if distanceCatBFromMouse < 0 {
		distanceCatBFromMouse = -1 * distanceCatBFromMouse
	}
	if distanceCatAFromMouse == distanceCatBFromMouse {
		return "Mouse C"
	}
	if distanceCatAFromMouse < distanceCatBFromMouse {
		return "Cat A"
	} else {
		return "Cat B"
	}
}

