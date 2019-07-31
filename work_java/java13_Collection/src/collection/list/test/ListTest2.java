package collection.list.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<String>();
		list.add("이효리");
		list.add("옥주현");
		list.add("이진");
		list.add("성유리");
		list.add("이진");

		for(String s : list)
		{
			System.out.println(s);
		}
		System.out.println("=====================================================");
		
		Iterator<String> it = list.iterator();
		if(it.hasNext())
		{
			System.out.println(it.next()+" "+it.next()+" "+it.next());
		}
		while(it.hasNext())
			System.out.println(it.next());
		
		
		
		
		
	}

}
