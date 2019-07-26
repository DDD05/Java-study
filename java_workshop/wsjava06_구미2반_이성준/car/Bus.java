package car;

public class Bus extends Car{
	private int seat;

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(String num, String model, int price) {
		super(num, model, price);
		// TODO Auto-generated constructor stub
	}
	public Bus(String num, String model, int price, int seat) {
		super(num, model, price);
		this.seat = seat;
		// TODO Auto-generated constructor stub
	}

	public Bus(int seat) {
		super();
		this.seat = seat;
	}

	@Override
	public String toString() {
		return super.toString() + " Bus [seat=" + seat + "]";
	}
	
}
