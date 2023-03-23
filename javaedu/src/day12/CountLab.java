package day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CountLab {
	public static void main(String[] args) {
		String readFilenm = "c:/iotest/yesterday.txt";
		int cnt = 0;
		File f = new File(readFilenm);

		try (Scanner scan = new Scanner(f)) {
			String data;
			while (scan.hasNext()) {
				data = scan.next();
				if (data.contains("yesterday"))
					cnt++;
			}

			System.out.printf("yesterday 라는 단어는 %d개 있습니다.", cnt);

		} catch (FileNotFoundException fe) {
			System.out.println("yesterday 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력을 처리하는 동안 오류가 발생했습니다.");
		}
	}

}
