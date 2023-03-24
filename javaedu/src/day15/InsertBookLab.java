package day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertBookLab {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		String sql = "insert into book (title, price, kind) values(?,?,?)";

		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				Scanner sc = new Scanner(System.in);) {

			String title;
			int price, num, cnt = 0;
			char check;

			while (true) {
				System.out.print("도서명을 입력하세요 : ");
				title = sc.nextLine();
				System.out.print("가격을 입력하세요 : ");
				price = Integer.parseInt(sc.nextLine());
				System.out.println("도서분류에 대한 넘버를 입력하세요.\n"
						+ "1.프로그래밍 언어\n"
						+ "2. 웹 프로그래밍\n"
						+ "3. 빅데이터\n"
						+ "4. 데이터베이스\n"
						+ "5. 인프라");
				System.out.print("선택(1~5) : \n");
				num = Integer.parseInt(sc.nextLine());

				pstmt.setString(1, title);
				pstmt.setInt(2, price);

				String kind = "";
				switch (num) {
				case 1:
					kind = "b01";
					break;
				case 2:
					kind = "b02";
					break;
				case 3:
					kind = "b03";
					break;
				case 4:
					kind = "b04";
					break;
				case 5:
					kind = "b05";
					break;
				}
				pstmt.setString(3, kind);
				pstmt.executeUpdate();
				
				cnt++;

				System.out.println("정보가 입력되었습니다.");
				System.out.print("계속 입력하겠습니까? (y/n) : \n");
				check = sc.nextLine().charAt(0);

				if (check == 'n') {
					System.out.println(cnt + "개의 데이터 입력 완료!");
					break;
				}
			}

		} catch (Exception e) {
				System.out.println("오류 발생"+e.getMessage());
		}

	}
}
