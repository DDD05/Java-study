package stream.os.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersonObjectOutputStream1 {
	public static void main(String[] args) throws Exception
	{
		String fileName = "person.obj";
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Person p = new Person("김연아",27);
		oos.writeObject(p);
		oos.close();
		System.out.println("완료");
	}
	
}


class Person implements Serializable
{
	private String name;
	private int age;
	public Person(String name , int age)
	{
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
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
}