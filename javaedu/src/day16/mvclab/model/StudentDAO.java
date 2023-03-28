package day16.mvclab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day16.mvc.MySQLConnect;

public class StudentDAO {

	public boolean insertStudent(StudentDTO dto) {
		boolean result = false;
		Connection conn = MySQLConnect.connect();
		try(PreparedStatement pstmt = conn.prepareStatement("insert into student (name, score) values (?, ?)")){
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getScore());
			pstmt.executeUpdate();
			result = true;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnect.close(conn);
		return result;
	}
	
	public List<StudentDTO> getAllStudent() {
		Connection conn = MySQLConnect.connect();
		List<StudentDTO> list = null;
		try(Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("select name, score from student");
			list = new ArrayList<StudentDTO>();
			while(rs.next()) {
				StudentDTO so = new StudentDTO();
				so.setName(rs.getString("name"));
				so.setScore(rs.getInt("score"));
				list.add(so);
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnect.close(conn);
		return list;
	}
	

	public int getScore(StudentDTO dto) {
		int result = 0;
		Connection conn = MySQLConnect.connect();
		try(PreparedStatement pstmt = conn.prepareStatement("select name, score from student where name = ?")){
			pstmt.setString(1, dto.getName());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("score");
			}else {
				 result = -1;
			}
	}catch(SQLException se) {
		System.out.println(se.getMessage());
	}
		MySQLConnect.close(conn);
		return result;
	}
	
	public boolean updateStudent(StudentDTO dto) {
		boolean result = false;
		Connection conn = MySQLConnect.connect();
		try(PreparedStatement pstmt = conn.prepareStatement("update student set name = ? , score = ? where name = ? ")){
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getScore());
			pstmt.setString(3, dto.getName());
			int check =  pstmt.executeUpdate();
			if(check > 0 ) result = true;
	}catch(SQLException se) {
		System.out.println(se.getMessage());
	}
	MySQLConnect.close(conn);
	return result;
	}
	
	public boolean deleteStudent(StudentDTO dto) {
		boolean result = false;
		Connection conn = MySQLConnect.connect();
		try(PreparedStatement pstmt = conn.prepareStatement("delete from student where name = ? ")){
			pstmt.setString(1, dto.getName());
			pstmt.executeUpdate();
			result = true;
	}catch(SQLException se) {
		System.out.println(se.getMessage());
	}
	MySQLConnect.close(conn);
	return result;
	}
}
