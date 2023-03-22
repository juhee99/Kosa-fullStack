package day11;

import java.util.LinkedList;

class Person {
	private String name;
	
	Person(String name){
		this.name = name;
	}
	public String getInfo() {
		return name;
	}
}

class Friend extends Person {
	private String phoneNum;
	private String email;
	
	Friend(String name, String phoneNum, String email){
		super(name);
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	public String getInfo() {
		return "이름 : " + super.getInfo() + " 핸드폰 번호 : " + phoneNum 
				+ " 이메일 주소 : " + email;
	}
}

public class LinkedListLab1 {
	public static void main(String[] args)  {
	LinkedList<Friend> friends = new LinkedList<Friend>();
	friends.add(new Friend("짱구", "01010001000", "jjan12@kosa.net"));
	friends.add(new Friend("흰둥이", "01020001000", "white@kosa.net"));
	friends.add(new Friend("철수", "01030001000", "su100@kosa.net"));
	friends.add(new Friend("유리", "01040001000", "Yuree23@kosa.net"));
	friends.add(new Friend("맹구", "01050001000", "stone52@kosa.net"));
	
	for(Friend data :  friends) {
		System.out.println(data.getInfo());
	}
	
	}
}
