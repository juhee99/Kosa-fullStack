package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckEmpLab {

	public static void main(String[] args)  {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		String sql =  "SELECT ENAME,DATE_FORMAT(HIREDATE, '%Y년 %m월') HIREDATE, DEPTNO FROM EMP";
		
		
		
		try(Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				ResultSet rs = stmt.executeQuery(sql)){
			
			char check;
			
			while(true) {
				System.out.print("직원 이름 검색 : ");
				String name = br.readLine();
				
				if(rs.next() && rs.getString("ENAME").equals(name)) {
					System.out.println(name + "직원은 근무중입니다.");
					System.out.printf("%s에 입사했고 현재 %d 번부서에서 근무하고 있습니다.\n", rs.getString("HIREDATE"), rs.getInt("DEPTNO"));	
				}else {
					System.out.println(name + " 직원은 근무하지 않습니다.");
				}
	
				System.out.print("\n계속 진행하시겠습니까?(y/n) :  ");
				check =br.readLine().charAt(0);
				
				if(check == 'n') break;
			}	
			System.out.println("종료하였습니다.");
		}catch(Exception e) {
			System.err.println("오류 발생 : " + e);
		}
	}
}
