public class Main {

	public static void main(String[] args) {
		printMatrix(getMatrix(3));
	}

	public static int[][] getMatrix(int n) {
		int[][] arr = new int[n][n];
		int num = 0;
		int barrier = 0;
		int circle = 0;
		int direction = 1;
		for (int i = 0; i < n * n; i++) {
			if (i != 0 && i % 3 == 0) {
				++barrier;
			}
			if (i != 0 && i % 4 == 0) {
				++circle;
			}
			for (int j = 0; j <= n - barrier - 1; j++) {
				if (direction == 1)
					arr[circle][j + barrier - circle] = num++;
				if (direction == 2) {
					arr[j + barrier][n - i] = num++;
				}
				if (direction == 3) {
					arr[n - 1 - circle][n - i - j] = num++;
				}
				if (direction == 4) {
					arr[n - j - barrier][circle] = num++;
				}
			}
			printMatrix(arr);
			direction = (direction == 4) ? direction = 1 : ++direction;
		}
		return arr;
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
}
