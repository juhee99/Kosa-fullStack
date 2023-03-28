package day16.mvclab.controller;

import java.util.ArrayList;
import java.util.List;

import day16.mvclab.model.StudentDAO;
import day16.mvclab.model.StudentDTO;

public class StudentController {
	StudentDAO st = new StudentDAO();
	
	public void printAll() {
		 List<StudentDTO> studentList =  st.getAllStudent();
		 
		 for(StudentDTO st : studentList) {
			 System.out.println(st);
		 }
	}
	
	public void printScore(String name) {
		StudentDTO dto = new StudentDTO();
		dto.setName(name);
		int score = st.getScore(dto);
		
		if(score < 0 ) {
			System.out.println(name+"학생은 존재하지 않습니다.");
		}else {
			System.out.println(name+"학생의 점수는"+score+"입니다.");
		}
	}
	
	public void insert(String name, int score) {
		StudentDTO dto = new StudentDTO();
		dto.setName(name);
		dto.setScore(score);
		
		if(st.insertStudent(dto)) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		
	}
	
	public void update(String name, int score) {
		StudentDTO dto = new StudentDTO();
		dto.setName(name);
		dto.setScore(score);
		
		if(st.updateStudent(dto)) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	}
	
	public void delete(String name) {
		StudentDTO dto = new StudentDTO();
		dto.setName(name);

		if(st.deleteStudent(dto)) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}
}
