package com.ssafy.domain;

import com.ssafy.util.MyDate;

public class SSAFYStudent {
	// 맴버변수, 필드
//	char color;	//'\u0000'
	String name;
	MyDate birthday;	//null
	int javaScore;	//0
	int algoScore;
	int classRoom;
	
//	Has a Relation..학생이 노트북을 소지하도록 로직을 작성
	/*
	 * 1. 가지고자 하는 클래스를 필드에 선언
	 * 2. setXXXX(o) 기능을 통해서 필드에 주입한다.
	 */
	NoteBook noteBook;
	public SSAFYStudent()	// 해당 클래스에서 내가만든 생성자가 없다면... 컴파일러가 기본생성자는 제공한다.
	{
		
	}
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	
	public NoteBook getNoteBook()
	{
		return this.noteBook;
	}

	public void	 setSSAFYStudentInfo(String name , MyDate birthday,
			int javaScore, int algoScore,int classRoom)
	{
		this.name = name;	// this는 해당 객체의 주소값을 가진다.
		this.birthday = birthday;
		this.javaScore = javaScore;
		this.algoScore = algoScore;
		this.classRoom = classRoom;
	}
	
	public String getSSAFYStudentInfo()
	{
		return name+","+birthday+","+javaScore+","+algoScore+","+classRoom;
	}
	
	

}
