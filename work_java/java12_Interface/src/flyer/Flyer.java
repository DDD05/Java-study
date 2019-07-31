package flyer;

/*
 * 기능의 Template만을 모아놓은 틀
 * interface의 구성요소
 * 1) 구현부가 없는 (;) 추상메소드
 * 2) 
 */
public interface Flyer {
	int speed = 140;	//public static final
	void fly();	//public abstract
	public abstract void land();
	void take_off();
}

class Eagle extends Bird
{

	@Override
	public void take_off() {
		// TODO Auto-generated method stub
		System.out.println("Bird...land...");
		
	}
	@Override
	public String layEggs(){
		return "더 까기";
	}
	
}

abstract class Bird implements Flyer
{

	@Override
	public void fly() {
		System.out.println("Bird...fly..."+speed);
	}

	@Override
	public void land() {
		System.out.println("Bird...land...");
	}

	public String layEggs()
	{
		return "알까기";
	}
}