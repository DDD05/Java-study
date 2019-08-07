package socket.client.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 키보드로 입력받은 데이타를 읽어서
 * 서버로 보낸다...
 * -----------------------------------
 * 서버가 다시 보낸 메시지를 읽어서
 * 자신의 콘솔창에 메세지를 출력하는 로직을 작성
 * ::
 * 1. Socket 생성
 * 		Socket s = new Socket("serverIP",60000);
 * 2. 스트림 로직...
 */
public class ClientProcess {
	Socket s;
	BufferedReader br1,br2;
	PrintWriter pw;
	public void protocol() throws IOException
	{
		try {
			s = new Socket("192.168.32.32",60000);
			System.out.println("Socket Creating...");
			br1 = new BufferedReader(new InputStreamReader(System.in));
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));	//br2 server
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
//			pw = new PrintWriter(s.getOutputStream(),true);
			while(true)
			{
				String str = br1.readLine();
				pw.println(str);
				//////////// blocking /////////////////
				String response = br2.readLine();
				System.out.println("Server msg : " + response);
//				pw.flush();
			}
		}finally {
			try {
				if(br1 != null)
					br1.close();
				if(pw != null)
					pw.close();
				if(br2 != null)
					br2.close();
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		ClientProcess cp = new ClientProcess();
			cp.protocol();
	}

}
