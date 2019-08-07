import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class BookClient extends Thread{
	ArrayList<Book> list;
	Socket s;
	ObjectOutputStream oos;
	
	public BookClient(ArrayList<Book> list){
		this.list = list;
	}
	public void run() {
		try {
			protocol();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void protocol() throws Exception
	{
		s = new Socket("localhost",60000);
		System.out.println("\t connecting!!");
		
		oos = new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(list);
		oos.close();
	}
}






