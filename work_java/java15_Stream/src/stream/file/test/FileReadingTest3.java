package stream.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/*
 * ���쇱�� �ㅼ�댁���� �곗�댄�곕�� �쎌�댁��
 * 肄���濡� 異��ν���� 濡�吏��� ����
 * result.txt ���쇰� �대�� �곗�댄�곕�� 異��ν���� 濡�吏��� ����
 * ::
 * 1. FileRader 湲곕낯 | BufferedReader
 * 	  FileWriter   | BufferedWriter
 * 2. �쎌�댁�� .. while
 * 3. 肄���濡� 異���
 */
public class FileReadingTest3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("src/poem2.txt");
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new FileReader(file));
			pw = new PrintWriter(new FileWriter("result.txt",true),true);
			
			String tmp = "";
			while((tmp = br.readLine()) != null)
			{
//				pw.write(tmp + "\n");
				pw.println(tmp);
				System.out.println(tmp);
//				pw.newLine();
			}
			pw.flush();
			
		}finally
		{
			if(br != null)
				br.close();
			if(pw != null)
				pw.close();
		}
		
		
	}

}
