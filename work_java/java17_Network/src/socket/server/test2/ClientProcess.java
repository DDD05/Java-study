package socket.server.test2;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientProcess {
	public static final int MIDDLE_PORT = 60000;
	Socket s;
	ObjectOutputStream oos;
	
	public void protocol() throws Exception{
		s = new Socket("192.168.32.32",MIDDLE_PORT);
		System.out.println("Client's Socket Creating...");
		
		oos = new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(new Student("","뉴욕",24));
		oos.close();
	}
	public static void main(String[] args) throws Exception {
		
		new ClientProcess().protocol();
		
	}

}
