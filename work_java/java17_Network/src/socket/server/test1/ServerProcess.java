package socket.server.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
	1. ServerSocket을 생성
		ServerSocket server = new Server Socket(port); //1~65535(1~1024)
	2. accep()을 통해서 클라이언트와 접속이 이루어지면 Socket을 하나 리턴한다.
		Socket s = server.accept();
	3. 소켓으로부터 입력스트림을 만들어낸다.
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
 */
public class ServerProcess {
	ServerSocket server;
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	
	//통신을 위한 잡다한 로직
	public void protocol() throws IOException
	{
		try
		{
			server = new ServerSocket(60000);
			System.out.println("Server Ready ....");
			
			s = server.accept();
			System.out.println(s.getInetAddress()+" 님이 접속하셨습니다...");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(),true);
			
			while(true)
			{
				String str = br.readLine();
				pw.println(str);
				System.out.println("받은 메시지 : " + str);
			}
		}finally {
			try {
				if(br != null)
					br.close();
				if(pw != null)
					pw.close();
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public static void main(String[] args) throws IOException
	{
		ServerProcess sp = new ServerProcess();
		sp.protocol();
	}
}
