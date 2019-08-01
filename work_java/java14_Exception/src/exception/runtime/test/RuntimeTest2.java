package exception.runtime.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RuntimeTest2 {
	
	public static void main(String[] args) throws FileNotFoundException,IOException{
		String fileName = "src/poem.txt";
		FileReader fr = null;
		try {
			System.out.println("1. fileReader creating ...");
			fr = new FileReader(fileName);
			System.out.println("2. file Reading ...");
			fr.read();
		}
		finally {
			fr.close();
		}
		
		




	}// main

}
