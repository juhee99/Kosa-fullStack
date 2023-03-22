package day12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountLab {

	public static void main(String[] args) {
		String readFilenm = "c:/iotest/yesterday.txt";
		int cnt =0;
		
		try (FileReader reader = new FileReader(readFilenm);
				BufferedReader br = new BufferedReader(reader)) {
			
			String data;
			while (true) {
				data = br.readLine();
				if (data == null)
					break;
				if(data.contains("yesterday")) cnt++;
			}
			
			System.out.printf("yesterday 라는 단어는 %d개 있습니다.",cnt);

		} catch (FileNotFoundException fe) {
			System.out.println("yesterday 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력을 처리하는 동안 오류가 발생했습니다.");
		}
	}

}
