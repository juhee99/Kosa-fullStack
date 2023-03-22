package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = null;
		int firstNum, secondNum;
		String result = "";

		while (true) {
			input = br.readLine().split(" ");
			firstNum = Integer.parseInt(input[0]);
			secondNum = Integer.parseInt(input[1]);

			if (firstNum == secondNum)
				break;

			if (secondNum % firstNum == 0) {
				result += "factor\n";
			} else if (firstNum % secondNum == 0) {
				result += "multiple\n";
			} else {
				result += "neither\n";
			}
		}

		System.out.println(result);
	}
}
