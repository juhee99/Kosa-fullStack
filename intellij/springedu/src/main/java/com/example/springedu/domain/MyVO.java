package com.example.springedu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor //모든 멤버들을 받는 생성자 자동 생성
@ToString
public class MyVO {
	private int myNumber;
	private String myColor;	
}
