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
		String sql = "insert into book (title, price, kind) values (?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				Scanner sc = new Scanner(System.in);) {

			String title;
			int price, num, cnt = 0;
			String check;

			while (true) {
				System.out.print("도서명을 입력하세요 : ");
				title = sc.nextLine();
				System.out.print("가격을 입력하세요 : ");
				price = Integer.parseInt(sc.nextLine());
				System.out.println("도서분류에 대한 넘버를 입력하세요.\n" + "1.프로그래밍 언어\n" + "2. 웹 프로그래밍\n" + "3. 빅데이터\n"
						+ "4. 데이터베이스\n" + "5. 인프라");
				System.out.print("선택(1~5) : ");
				num = Integer.parseInt(sc.nextLine());
				
				if(num>5 || num<1) {
					System.out.println("잘못된 입력입니다. 다시 입력해 주세요");
					continue;
				}
				
				pstmt.setString(1, title);
				pstmt.setInt(2, price);
				pstmt.setString(3, "b0"+num);
				
				pstmt.executeUpdate();

				cnt++;
				System.out.println("정보가 입력되었습니다.");
				
				System.out.print("계속 입력하겠습니까? (y/n) : ");
				check = sc.nextLine();

				if (check.equalsIgnoreCase("N") ) {
					System.out.println("\n"+cnt + "개의 데이터 입력 완료!");
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("\n오류 발생" );
			 e.printStackTrace();
		}

	}
}
