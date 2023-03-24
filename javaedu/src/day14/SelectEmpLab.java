package day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public class SelectEmpLab {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";				
		Random random = new Random();

		String sql = "SELECT ENAME, SAL, DATE_FORMAT(HIREDATE, '%Y년 %m월 %d일') HIREDATE FROM EMP ORDER BY HIREDATE ";
		
		try(Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			if(rs.next()) {
				do {  
					if(random.nextBoolean())System.out.printf("%s 직원의 월급은 %,d달러 입니다.\n",rs.getString("ENAME"), rs.getInt("SAL")) ;
					else System.out.printf("%s 직원은 %s에 입사하였습니다.\n", rs.getString("ENAME"), rs.getString("HIREDATE")); 
				} while (rs.next());
				
			}else {
				System.out.println("데이터가 없습니다.");
			}
			
		}catch(Exception e) {
			System.err.println("오류 발생 : " + e);
		}

	}
}
