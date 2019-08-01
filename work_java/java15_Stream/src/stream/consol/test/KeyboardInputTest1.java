package stream.consol.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 스트림 객체 생성( 자원을 열어서 사용할 준비를 함) 
 * ::
 * 키보드로 읽어들인 데이타를
 * 콘솔창으로 출력하는 로직을 생성
 * ::
 * 입력(2개)
 * 출력 X --> System.out.println();
 */
public class KeyboardInputTest1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//1.
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		//2.
		String line = br.readLine();
		while((line = br.readLine()) != null)
		{
			if(line.equals("고마해라")) 
				break;
		
		//3.
		System.out.println("Reading Data : " + line);
		}
	}

}
