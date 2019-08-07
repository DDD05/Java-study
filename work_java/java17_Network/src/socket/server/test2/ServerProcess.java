package socket.server.test2;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ServerThread extends Thread
{
	Socket s;
	ObjectInputStream ois;
	ServerProcess sp;
	
	ServerThread(Socket s, ServerProcess sp)
	{
		this.s = s;
		this.sp = sp;
	}
	public void run()
	{
		try
		{
			ois = new ObjectInputStream(s.getInputStream());
			while(true)
			{
				Student st = (Student)ois.readObject();
				System.out.println(st);
			}
		}catch(Exception e)
		{
			sp.removeThread(this);
		}
	}
}

public class ServerProcess {
	public static final int MIDDLE_PROT = 60000;
	ServerSocket server;
	Socket s;
	ArrayList<ServerThread> list;
	
	ServerProcess()
	{
		list = new ArrayList<ServerThread>();
	}
	public void addThread(ServerThread st)
	{
		list.add(st);
	}
	public void removeThread(ServerThread st)
	{
		list.remove(st);
	}
	public void protocol() throws Exception
	{
		server = new ServerSocket(MIDDLE_PROT);
		System.out.println("Server Ready.....");
		
		while(true)
		{
			s = server.accept();
			ServerThread st = new ServerThread(s,this);
			System.out.println(s.getInetAddress() + " 님이 접속하셨습니다.");
			
			addThread(st);
			st.start();
		}//while
		
	}
	public static void main(String[] args) throws Exception {

		new ServerProcess().protocol();
		
	}

}
