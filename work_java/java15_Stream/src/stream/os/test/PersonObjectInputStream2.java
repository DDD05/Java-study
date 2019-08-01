package stream.os.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PersonObjectInputStream2 {
	
	public static void main(String[] args) throws Exception
	{
		String fileName = "person.obj";
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();
	}
}

