package day6;

class Student4 {
	//멤버 변수
	String name; 
	int age ;
	String subject;
	
	Student4(){
		this("듀크",28,"스프링") ; // this() 사용
	}
	
	Student4(String name, int age, String subject){
		this.name = name;
		this.age = age;
		this.subject = subject;
	}
	
	void printStudentInfo() {
		System.out.printf("%s학생의 나이는 %d입니다.\n",name,age);
	}
	
	void study() {
		System.out.printf("%s학생은 %s과목을 학습합니다.\n",name,subject);
	}
	
	void setSubject(String subject) { 
		this.subject = subject; //지역변수와 멤버변수를 구분하기 위해 this사용
	}
}




public class StudentTest4 {
	public static void main(String[] args) {
		
		Student4 [] stArr = new Student4[4];
		
		stArr[0] = new Student4("둘리",10,"HTML5");
		stArr[1] = new Student4("또치",10,"CSS3");
		stArr[2] = new Student4("도우너",10,"JavaScript");
		stArr[3] = new Student4();
		
		
		for(Student4 obj : stArr) {
			System.out.printf("stArr이 참조하는 객체 정보: %s\n" ,obj);
			obj.printStudentInfo();
			obj.study();
		}
		
		stArr[3].setSubject("JPA");
		stArr[3].study();
	}
}
