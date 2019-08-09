package edu.jaen.java.xml.sax;

import java.util.List;

public class CheckSAXTest {
	public static void main(String[] args)
	{
		List<Check> list = 
				new CheckSAXParser().getcontent("http://localhost:8888/result.xml");
		
		for(Check c : list)
			System.out.println(c);
	}
}
