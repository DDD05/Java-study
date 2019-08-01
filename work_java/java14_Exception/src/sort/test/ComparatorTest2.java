package sort.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Comparator를 사용해서 정렬하는 방법
 * 내림차순 정렬...
 */
public class ComparatorTest2 {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("이정재",44));
		list.add(new Person("하정우",44));
		list.add(new Person("조인성",38));
	
		Collections.sort(list,new Comparator<Person>(){
			@Override
			public int compare(Person p1, Person p2)
			{
				return -(p1.getAge() - p2.getAge());
			}
		});
		for(Person p : list)
			System.out.println(p);
	
	
	
	}

}
