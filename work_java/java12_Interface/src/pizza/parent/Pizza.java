package pizza.parent;

/*
 * 추상클래스의 용도
 * 1. 여러 종류의 피자를 만들때 피자가 가지는 공통적인 성질은 그대로 물려준다.
 * 2. 여러 종류의 피자를 만들때 서로 다른 피자가 만들어지는 결정적인 부분은 구멍(추상메소드)으로 물려준다.
 */
public abstract class Pizza {
	protected int price;
	protected String storeName;

	public Pizza(int price, String storeName)
	{
		this.price = price;
		this.storeName = storeName;
	}
	public Pizza() {}
	
	public void cut()
	{
		System.out.println("만들어진 피자를 8등분으로 자른다.");
	}
	public void baking()
	{
		System.out.println("180도에서 화덕에 구워낸다.");
	}
	public void box()
	{
		System.out.println("상자에 담는다.");
	}
	public void dough() {
		System.out.println("dough...를 만든다.");
	}
	public void orderMaking()
	{
		dough();
		topping();
		baking();
		cut();
		box();
	}
	public abstract void topping();	//
	
	

}
