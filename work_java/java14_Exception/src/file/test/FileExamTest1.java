package file.test;

import java.io.File;

/*
 * 파일이란?
 * = 디렉토리 + 파일명 
 */
public class FileExamTest1 {
	public static void main(String[] args) {
		File dir = new File("c:\\filetest\\step1\\code");
		File dir2 = new File("c:\\filetest1");
		File dir3 = new File("c:\\filetest1\\exam\\data.dat");
		
		System.out.println("파일이 생성되었는지 확인.....	");
		
		dir2.mkdir();
		dir.mkdirs();	// 하위~	
//		dir3.mkdirs();	
		
		dir3.getParentFile().mkdirs();
	}
}
