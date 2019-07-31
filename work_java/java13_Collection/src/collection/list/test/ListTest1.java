package collection.list.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<String>();
		list.add("이효리");
		list.add("옥주현");
		list.add("이진");
		list.add("성유리");
		list.add("이진");
		System.out.println(list);	// collection은 toString() 오버라이딩
		
		String rName = list.remove(2);
		System.out.println(rName+"님이 삭제");
		
		if(list.remove("성유리"))
			System.out.println("Delete는 삭제");
		System.out.println(list);	// collection은 toString() 오버라이딩

		System.out.println(list.get(0));
		
		list.set(list.size()-1, "IU");
		System.out.println(list);
		
	}

}
