package sort.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
 * String , Wrapper, Date, File... 클래스들을 기본저긍로 Comparable 인터페이스에 의해
 * 상속받은채로 정의되어진 클래스들이다.
 * comparable에 의해서 구현된 클래스들은 같은 타입의 객체값은 서로 비교해서 정렬할 수 있다.
 * 기본적으로 오름차순으로 정렬된다.
 * 
 * Arrays.sort(Xxx[]) 는 Comparable에 의해서 정렬된 것이다.
 * ArrayList는 Arrays.sort()로 정렬이 안된다.
 * ArrayList는 Collections.sort()로 정렬한다.
 * ==============================================
 */

class Person implements Comparable<Person>
{
	private String name;
	int age;
	
	public Person(String name, int age) {
		super();
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person p) {
		
		return -(this.getAge()-p.getAge());
	}
//	@Override
//	public int compareTo(Person p) {
//		
//		return name.compareTo(p.getName());
//	}
	
}
public class ComparableTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("이정재",44));
		list.add(new Person("하정우",43));
		list.add(new Person("조인성",38));
		
		Collections.sort(list);
		System.out.println(list);
	}

}
