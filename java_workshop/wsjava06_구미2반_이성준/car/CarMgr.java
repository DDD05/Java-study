package car;

public class CarMgr {
	private static CarMgr cm = new CarMgr();
	private static final int MAX_SIZE = 10;
	private Car[] cars;
	private int index;
	private CarMgr() {
		this.cars = new Car[MAX_SIZE];
		this.index = 0;
	}
	public static CarMgr getInstance()
	{
		return cm;
	}
	
	
	public void add(Car c)
	{
		if(index <= MAX_SIZE)
			cars[index++] = c;
		else
			return;
	}
	public Car[] search()
	{
		Car[] cList = new Car[MAX_SIZE];
		int i = 0;
		for(Car c : cars)
		{
			if(c != null)
				cList[i++] = c;
		}
		return cList;
	}
	public Car search(String num)
	{
		Car outputCar = null;
		
		for(Car c : cars)
		{
			if(c != null && c.getNum().equals(num))
				outputCar = c;
		}
		
		return outputCar;
	}
	public Car[] search(int price)
	{
		Car[] cList = new Car[MAX_SIZE];
		int i = 0;
		for(Car c : cars)
		{
			if(c != null && c.getPrice() <= price)
				cList[i++] = c;
		}
		return cList;
	}
	public void update(String num, int price)
	{
		for(Car c : cars)
		{
			if(c != null && c.getNum().equals(num))
			{
				c.setPrice(price);
			}
		}
	}
	public void delete(String num)
	{
		for(int i = 0 ; i < MAX_SIZE ; i++)
		{
			if(cars[i] != null && cars[i].getNum().equals(num))
			{
				for(int j = i+1; j < MAX_SIZE; j++)
				{
					cars[j-1] = cars[j];
				}
			}
		}
		cars[--index] = null;
	}
	public int size()
	{
		return this.index;
	}
	public int totalPrice()
	{
		int sumPrice = 0;
		for(Car c : cars)
		{
			if(c != null)
				sumPrice += c.getPrice();
		}
		return sumPrice;
	}
}
