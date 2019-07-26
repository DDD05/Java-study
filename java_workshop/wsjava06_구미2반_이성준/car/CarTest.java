package car;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarMgr cm = CarMgr.getInstance();
		
		System.out.println("차들 추가");
		cm.add(new Bus("s1","samsung",1000,1));
		cm.add(new Truck("s2","samsung",2000,99));
		cm.add(new Car("s3","lg",3000));
		
		System.out.println("모두 출력");
		Car[] carList = cm.search();
		for(Car c : carList)
		{
			if(c != null)
				System.out.println(c);
		}
		
		System.out.println("차량 정보로 출력");
		Car car = cm.search("s3");
		System.out.println(car);
		
		System.out.println("차량 가격으로 출력");
		carList = cm.search(2000);
		for(Car c : carList)
		{
			if(c != null)
				System.out.println(c);
		}
		System.out.println("차량 삭제 후 출력");
		cm.delete("s3");
		carList = cm.search();
		for(Car c : carList)
		{
			if(c != null)
				System.out.println(c);
		}
		
		System.out.println("차량 수 출력");
		int numCars = cm.size();
		System.out.println(numCars);
		
		System.out.println("차량 토탈 가격 출력");
		int allPirce = cm.totalPrice();
		System.out.println(allPirce);
		
		System.out.println("가격 수정 후 출력");
		cm.update("s1", 2000);
		carList = cm.search();
		for(Car c : carList)
		{
			if(c != null)
				System.out.println(c);
		}
	}

}
