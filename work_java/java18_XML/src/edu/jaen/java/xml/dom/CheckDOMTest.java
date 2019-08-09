package edu.jaen.java.xml.dom;

import java.util.List;


public class CheckDOMTest {
	public static void main(String[] args)
	{
		List<Check> list = 
				new CheckDOMParser().getContent("http://localhost:8888/result.xml");
		
		for(Check c : list)
			System.out.println(c);
	}
}
