package com.ssafy.test;

import com.ssafy.domain.NoteBook;
import com.ssafy.domain.SSAFYStudent;
import com.ssafy.util.MyDate;

public class SSAFYStudentTest1 {

		//	실행 메소드
	public static void main(String[] args)
	{
		/*
		 * 1. NoteBook, SSAFYStudent 객체를 생성 ... 메모리에 올린다.
		 * 2. NoteBook의 값을 주입
		 * 3. SSAFYStudent 값을 주입... 김민정
		 * 4. 김민정 학생이 노트북을 가지도록 로직을 작성
		 * 5. 민정이가 가진 노트북의 정보를 콘솔로 출력하는 로직을 작성
		 */
		
		NoteBook noteBook = new NoteBook();	// 1)종료 	2) 호출(calling)
		SSAFYStudent student = new SSAFYStudent();
		noteBook.setNoteBookInfo("samsung", "note 1", 1000000);	// 호출.. 인자값(순서, 갯수, 타입)
		MyDate studentBirthday = new MyDate();
		studentBirthday.setDate(1994, 8, 10);
		student.setSSAFYStudentInfo("김민정", studentBirthday, 
				100, 100, 302);
		student.buyNoteBook(noteBook);
		
		NoteBook nb = student.getNoteBook();
		System.out.println(nb.getNoteBookInfo());
		
	}
}
