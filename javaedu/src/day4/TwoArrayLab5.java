package day4;

public class TwoArrayLab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][3];
		int size = arr.length;
		int num = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("------------------------");

		for (int i = 0; i < arr[0].length; i++) { // 열
			for (int j = i; j < size; j++) { // 행
				arr[j][i] = ++num;
			}
			size--;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");

			}
			System.out.println();
		}

	}

}
