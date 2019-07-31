package collection.list.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>();
		list.add("서울");
		list.add("상해");
		list.add("동경");
		list.add("뉴욕");
		list.add("부산");
		
		list.add(1,"LA");
		System.out.println(list);
		
		list.remove("동경");
		System.out.println(list.contains("LA")); //LA la
		System.out.println(list);
		
		Object[] obj = list.toArray();	// 리스트 객체를 일반 배열로 변환
		System.out.println(Arrays.toString(obj));
		
		String[] cities = new String[0];
		cities = list.toArray(cities);
		System.out.println(Arrays.toString(cities));
		
		list.clear();
		System.out.println(list.isEmpty());
		
		//비어있는 리스트에 다시 데이터를 추가
		list.add("파리");
		list.add("싱가폴");
		list.add("부다페스트");
		System.out.println(list);
		
		//Arrays 클래스는 데이터 처리에 다양한 기능을 제공하는 클래스...
		//asList() 메소드는 인자로 전달된 데이터를 가지는 List 객체를 생성해서 반환
		List<String> list2 = Arrays.asList("전주","경주","진주");
		System.out.println(list);
		
		list.addAll(list2);
		System.out.println(list);
		
		System.out.println(list.containsAll(list2)); //list에 list2의 내용이 있는지의 여부를 판단.
		
		System.out.println(list.retainAll(list2));	// list에서 list2만 남기고 다 버림.
		
		list.removeAll(list);
		System.out.println(list);
	}

}
