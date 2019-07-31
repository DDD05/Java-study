package collection.map.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new HashMap<>();
		
		map.put("강호동", 90);
		map.put("강호동", 80);
		map.put("서장훈", 70);
		map.put("이상민", 60);
		System.out.println(map);
		
		//1. map에서 키값만 받아옴
		Set<String> set = map.keySet();
		System.out.println(set);
		
		//2. set에 담긴 키들을 하나씩 뽑아서.. 키에 매핑된 value값을 받아온다.
		for(String s : set)
			System.out.println("key : " + s + ", value : " +map.get(s));
		System.out.println();
		
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String key = it.next();
			int value = map.get(key);
			System.out.println("key : "+ key +", value : "+ value);
		}
		
		//3. 총점 | 평균
		Collection<Integer> col = map.values();
		int sum = 0;
		for(int i : col)
			sum += i;
		System.out.println("sum : " + sum);
		System.out.println("avg : " + sum/col.size());
		
		Iterator<Integer> iter = col.iterator();
		int total = 0;
		while(iter.hasNext())
		{
			total += iter.next();
		}
		System.out.println("sum : " + total);
		System.out.println("avg : " + total/map.size());
		System.out.println("max : " + Collections.max(col));
		System.out.println("min : " + Collections.min(col));	
		
	}// main

}
