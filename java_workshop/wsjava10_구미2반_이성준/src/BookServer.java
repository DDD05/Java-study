import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ServerThread extends Thread{
	Socket s;
	BookServer bs;
	ObjectInputStream ois;
	ServerThread(Socket s ,BookServer bs)
	{
		this.s = s;
		this.bs = bs;
	}

	public void run(){
		try
		{
			ois = new ObjectInputStream(s.getInputStream());
			while(true)
			{
				ArrayList<Book> bList = (ArrayList<Book>)ois.readObject();
				for(Book b : bList)
					System.out.println(b);
			}
		}catch(Exception e)
		{
			bs.removeThread(this);
		}
	}
}

public class BookServer{
	ServerSocket ss;
	Socket s;
	ArrayList<ServerThread> list;


	BookServer()
	{
		list = new ArrayList<>();
	}
	public void go() throws IOException {

		ss = new ServerSocket(60000);
		System.out.println("Server Ready.....");



		while(true) {//
			s = ss.accept();
			ServerThread st = new ServerThread(s,this);
			System.out.println(Thread.currentThread().getName()+ ", good connecting!!");

			addThread(st);
			st.start();
		}
	}	

	public void addThread(ServerThread st)
	{
		list.add(st);
	}
	public void removeThread(ServerThread st)
	{
		list.remove(st);
	}
	public static void main(String[] args) throws Exception {
		BookServer bs = new BookServer();
		bs.go();
	}
}


