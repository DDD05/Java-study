package car;

public class Truck extends Car{
	private int ton;

	public Truck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Truck(String num, String model, int price) {
		super(num, model, price);
		// TODO Auto-generated constructor stub
	}
	public Truck(String num, String model, int price, int ton) {
		super(num, model, price);
		this.ton = ton;
		// TODO Auto-generated constructor stub
	}
	public Truck(int seat) {
		super();
		this.ton = seat;
	}

	@Override
	public String toString() {
		return super.toString() + " Bus [seat=" + ton + "]";
	}
	
}
