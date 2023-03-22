package day12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CopyLab {
	public static void main(String[] args) {
	
		String writeFileName = "c:/iotest/sample_"
				+LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd"))
				+".txt";
		
		try(FileReader reader = new FileReader("c:/iotest/sample.txt");
				BufferedReader br = new BufferedReader(reader);
				FileWriter writer = new FileWriter(writeFileName,true)){
			
			String data;
			while (true) {
				data = br.readLine();
				if (data == null)
					break;
				writer.write(data+"\n");
			}
			System.out.println( "저장 완료되었습니다.");
			
		}catch(FileNotFoundException fe) {
			System.out.println("sample.txt 파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			System.out.println("입출력을 처리하는 동안 오류가 발생했습니다.");
		}
	}
}
