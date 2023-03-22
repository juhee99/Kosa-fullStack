package day12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class FileOutLab {
	public static void main(String[] args) {
		File dir = new File("c:/Temp");
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		try(FileWriter writer = new FileWriter("c:/Temp/event.txt");
			PrintWriter out = new PrintWriter(writer);) {
		
			LocalDate ld1 = LocalDate.of(2023, 5, 5);
			String date1 = ld1.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
			DayOfWeek day1 = ld1.getDayOfWeek();
			String korday1 = day1.getDisplayName(TextStyle.FULL, Locale.KOREAN);
			out.printf("%s은 %s입니다.\n", date1 ,korday1);
			
			
			LocalDate ld2 = LocalDate.of(2023, 6, 6);
			String date2 = ld2.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
			DayOfWeek day2 = ld2.getDayOfWeek();
			String korday2 = day2.getDisplayName(TextStyle.FULL, Locale.KOREAN);
			out.printf("%s은 %s입니다.\n", date2 ,korday2);
			
			System.out.println("저장이 완료되었습니다.");
			
		}catch(IOException ioe) {
			System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		}
	}
}
