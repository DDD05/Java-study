package file.test;

import java.io.File;
import java.io.IOException;

public class FileExamTest2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String dirName = "c:" + File.separator + "Temp2" + File.separator + "mydir";
		File f1 = new File(dirName);
		
		f1.mkdirs();
		
		File f2 = new File(dirName, "filetest.dat");
		if(f2.createNewFile())
		{
			System.out.println("file 생성!!!");
		}
		System.out.println(f2.getName());
		System.out.println(f2.getPath());
		System.out.println(f2.getParent());
		f2.deleteOnExit();//종료될때 디렉토리 안에있는 파일 삭제
	}

}
