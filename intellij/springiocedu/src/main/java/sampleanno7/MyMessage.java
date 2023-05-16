package sampleanno7;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")        // 요청시 마다 객체를 생성하여 처리
public class MyMessage {
	String message;
	
	public MyMessage(){
		System.out.println("Create object");
		message="Good day!!";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
}
