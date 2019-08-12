package server.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * 여러명의 클라이언트와 연결된 서버측 채팅 로직
 * Process | Thread
 * ::
 * 클라이언트가 보낸 메시지를 받아서
 * 메세지를 보낸 클라이언트를 포함한 연결된 모든 클라이언트에게 동일한 메세지를 보낸다.
 */
public class ServerProcess {
	public static final int MIDDLE_PORT = 60000;
	ServerSocket server;
	Socket socket;
	ArrayList<ServerThread> list ;
	public static void main(String[] args) {
		ServerProcess sp = new ServerProcess();
		sp.go();
	}
	ServerProcess()
	{
		list = new ArrayList<ServerThread>();
	}
	public void broadcast(String str)
	{
		for(ServerThread sp : list)
		{
			sp.send(str);
		}
	}
	public void go()
	{
		try
		{
			server = new ServerSocket(MIDDLE_PORT);
			while(true)
			{
				socket = server.accept();
				ServerThread st = new ServerThread(socket,this);
				System.out.println("서버 쓰레드 생성~");
				list.add(st);
				st.start();
			}
		}catch(Exception e)
		{
			
		}
	}
}

class ServerThread extends Thread
{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	ServerProcess sp;
	InetAddress addr;
	String nickName;
	boolean broadcast;
	ArrayList<ServerThread> list;
	
	ServerThread(Socket s ,ServerProcess sp)
	{
		this.s = s;
		this.sp = sp;
		addr = s.getInetAddress();	// 받아온 소켓에서 해당 접속자의 ip주소를 받아옴
		System.out.println(addr+"님이 서버에 접속하셨습니다...");
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(),true);
		}catch(IOException e)
		{
			
		}
	}
	public void send(String str)
	{
		pw.println(str);
	}
	@Override
	public void run() {
		try
		{
			nickName = br.readLine();
			sp.broadcast("["+nickName+"]");
			String str = null;
			while((str=br.readLine())!= null)
			{
				sp.broadcast(str);
			}

		}catch(Exception e)
		{
			sp.list.remove(this);
			sp.broadcast("["+nickName+"] 님이 나가셨습니다.");
			sp.broadcast(addr+"연결이 끊어졌습니다.");
		}
	}
}