public class Main {

	public static void main(String[] args) {
		printMatrix(getMatrix(4));
	}

	public static int[][] getMatrix(int n) {
		int[][] arr = new int[n][n];
		int num = 0;
		int barrier = 0;
		int circle = 0;
		int direction = 0;
		int barrierChecker = 2;
		int circleChecker = 4;
		for (int i = 0; i < 2 * n - 1; i++, ++direction, direction %= 4) {
			if (i != 0 && i % barrierChecker != 0)
				++barrier;
			if (i != 0 && i % circleChecker == 0)
				++circle;
			for (int j = 0; j <= n - 1 - barrier; j++) {
				switch (direction) {
				case 0:
					arr[j + barrier - circle][n - 1 - circle] = num++;
					break;
				case 1:
					arr[n - 1 - circle][n - 1 - j - barrier + circle] = num++;
					break;
				case 2:
					arr[n - 1 - j - barrier + circle][circle] = num++;
					break;
				case 3:
					arr[circle][j + barrier - circle - 1] = num++;
					break;
				}
				printMatrix(arr);
			}
		}
		return arr;
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
}
