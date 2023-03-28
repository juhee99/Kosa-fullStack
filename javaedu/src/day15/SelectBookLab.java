package day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectBookLab {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";

		int option;
		String sql = "";
		String check = "Y";

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("*******************메뉴**********************");
			System.out.println("1. 모두 출력하기\n" + "2. 가격이 높은 순으로 출력하기\n" + "3. 20000 이상의 도서들만 출력하기 \n"
					+ "4. 웹 프로그래밍 도서들만 출력하기\n" + "5. 데이터베이스와 인프라 도서들만 출력하기\n" + "6. 도서명에 '자바'를 포함하는 도서들만 출력하기\n"
					+ "7. 분류별 도서 가격의 평균 출력하기\n");
			System.out.println("***********************************************");
			System.out.print("\n원하는 메뉴의 번호를 선택 : ");
			option = Integer.parseInt(sc.nextLine());

			if (option < 1 || option > 5) {
				System.out.println("다시 입력하세요.");
				continue;
			} else {
				sql = inputQuery(option);
			}
			System.out.println();

			// sql 메서드 호출

			try (Connection conn = DriverManager.getConnection(url, user, passwd);
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);) {

				if (rs.next()) {
					do {
						printBook(option, rs); // 출력 메서드 호출
					} while (rs.next());
				} else {
					System.out.println("데이터가 없습니다.");
				}

			} catch (SQLException e) {
				System.out.println("SQL오류 : " + e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.print("\n\n계속 입력하겠습니까? (y/n) : ");
			check = sc.nextLine();

			System.out.println();
		} while (check.equalsIgnoreCase("Y"));
		System.out.println("종료하겠습니다.");
		sc.close();
	}

	static String inputQuery(int num) {
		String sql = "";
		switch (num) {
		case 1:
			sql = "select id, title, price, kind  from book";
			break;
		case 2:
			sql = "select  id, title, price, kind from book order by price desc";
			break;
		case 3:
			sql = "select title, price from book where price >= 20000";
			break;
		case 4:
			sql = "select title, price from book where kind = 'b02' ";
			break;
		case 5:
			sql = "select title , price from book where kind = 'b04' or kind = 'b05'";
			break;
		case 6:
			sql = "select title , price from book where title like '%자바%'";
			break;
		case 7:
			sql = "select  kind , format(avg(price),0) avg from book group by kind ";
			break;
		}

		return sql;
	}

	static void printBook(int option, ResultSet rs) throws Exception {
		String[] kindbook = { "프로그래밍 언어", "웹 프로그래밍", "빅데이터", "데이터 베이스", "인프라" };

		switch (option) {
		case 1:
		case 2:
			System.out.printf("id :  %-3s\ttitle : %-15s\t price : %,d\t  kind : %s \n", rs.getInt("id"),
					rs.getString("title"), rs.getInt("price"), rs.getString("kind"));
			break;
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.printf("title : %-10s\tprice : %,d\n", rs.getString("title"), rs.getInt("price"));
			break;
		case 7:
			int index = Integer.parseInt(rs.getString("kind").substring(2)) - 1;
			System.out.printf("%s 도서들의 가격 평균은 %s원 입니다.\n", kindbook[index], rs.getString("avg"));
			break;
		}
	}

}
