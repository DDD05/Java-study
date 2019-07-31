package collection.set.test;

import java.util.HashSet;
import java.util.Set;

public class SetTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<>();
		
		set.add("강호동");
		set.add("이수근");
		set.add("서장훈");
		set.add("강호동");
		
		System.out.println(set);
		System.out.println(set.size());
		boolean find = set.contains("이수근");
		System.out.println(find);
		
		set.remove("서장훈");
		
		set.clear();
		System.out.println("빔?"+set.isEmpty());
	}

}
