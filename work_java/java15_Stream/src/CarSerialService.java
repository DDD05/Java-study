import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CarSerialService {
	public void outputCar(String path, ArrayList<Car> list) throws FileNotFoundException, IOException // 직렬화....
	{
		File f= new File(path);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		
		oos.writeObject(list);
		oos.close();
	}
	
	public ArrayList<Car> inputCar(String path) throws Exception
	{
		ArrayList<Car> list = null;
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		
		list = (ArrayList<Car>)ois.readObject();
		ois.close();
		return list;
	}
}
