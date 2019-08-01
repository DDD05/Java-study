package stream.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * 파일에 들어있는 데이터를 읽어서
 * 콘솔로 출력하는 로직을 작성
 * result.txt 파일로 해당 데이터를 출력하는 로직을 작성
 * ::
 * 1. FileRader 기본 | BufferedReader
 * 	  FileWriter   | BufferedWriter
 * 2. 읽어서 .. while
 * 3. 콘솔로 출력
 */
public class FileReadingTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("src/poem.txt");
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(file));
			bw = new BufferedWriter(new FileWriter( "output.txt"));
			
			String tmp = "";
			while((tmp = br.readLine()) != null)
			{
				bw.write(tmp);
				bw.newLine();
			}
			bw.flush();
			
		}finally
		{
			if(br != null)
				br.close();
			if(bw != null)
				bw.close();
		}
		
		
	}

}
