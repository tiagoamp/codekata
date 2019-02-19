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
