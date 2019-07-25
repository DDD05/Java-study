package com.ssafy.test;

import com.ssafy.domain.NoteBook;
import com.ssafy.domain.SSAFYStudent;
import com.ssafy.util.MyDate;

public class SSAFYStudentTest2 {

		//	실행 메소드
	public static void main(String[] args)
	{
		NoteBook nb = new NoteBook("lg","gram",1000000);
		SSAFYStudent st = new SSAFYStudent("민정",new MyDate(1994,8,10), 100,100,302 );
		st.buyNoteBook(nb);

		NoteBook nb2 = new NoteBook("삼성","삼성-센스",1000000);
		SSAFYStudent st2 = new SSAFYStudent("혜진",new MyDate(1995,8,10), 100,100,302 );
		st2.buyNoteBook(nb2);
		
//		민정이가 구매한 노트북의 정보를 출력하세여
		System.out.println("========민정이가 구입한 노트북 정보입니다.===========");
		System.out.println(st.getNoteBook().getNoteBookInfo());
		
	}
}
