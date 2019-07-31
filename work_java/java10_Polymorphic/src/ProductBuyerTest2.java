
public class ProductBuyerTest2 {
	public static void main(String[] args) {	
/*	
		TV tv = new TV();
		Computer com = new Computer();
		ProductBuyer buyer = new ProductBuyer();*/
		
		Product tv = new TV();
		Product com = new Computer();
		Product audio1 = new Audio();
		Product audio2 = new Audio();
		
		tv.setpNumber(111);
		com.setpNumber(222);
		audio1.setpNumber(333);
		audio2.setpNumber(444);
		
		ProductBuyer buy = new ProductBuyer();
		
		//상품을 4개 구입하는 로직을 호출...
		buy.buyProduct(tv);
		buy.buyProduct(com);
		buy.buyProduct(audio1);
		buy.buyProduct(audio2);
		
		buy.summary();
	
		System.out.println(" 현재 남은 금액은 :: "+buy.money+" 만원 입니다" );
		System.out.println(" 현재 남은 Bonus Point는 :: "+buy.bonusPoint+" 점 입니다" );
		
		buy.refund(audio2);
		System.out.println(" 현재 남은 금액은 :: "+buy.money+" 만원 입니다" );
		System.out.println(" 현재 남은 Bonus Point는 :: "+buy.bonusPoint+" 점 입니다" );
		
	}
}

//super class...
class Product{
	int price; 
	int bonusPoint;
	int pNumber; //상품을 구별하는 유니크한 값
	
	
	//상품이 만들어질떄 가격이 정해짐, 이떄 보너스도 함꼐 정해짐(상품가의 10%)
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price*0.1); 
	}

	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}		
}
//Sub Class
class TV extends Product{
	
	TV(){
		super(150);
	}
	
	public String toString(){
		return "TV";
	}
}

class Computer extends Product{
	Computer(){
		super(100);
	}
	
	public String toString(){
		return "Computer";
	}
}

class Audio extends Product{
	Audio(){
		super(100);
	}
	
	public String toString(){
		return "Audio";
	}
}
//Service Class...
class ProductBuyer {
	Product[] items = new Product[10];	// 구입한 상품들을 관리하는 저장소
	int index = 0;
	int money = 1000; 		// 단위는 만원
	int bounsPoint = 0;		// 현재 포인트... 상품구매 이전
	
	public void buyProduct(Product p)
	{
		/*
		 * 가진돈보다 물건의 가격이 비싸면 살수없도록 ... return 
		 * 상품의 각겨만큼 보유금액은 줄어들고 /	포인트는 상품의 10%증가하고
		 * 배열에 구입한 상품을 저장
		 * 최종적으로 구입한 상품의 정보를 출력
		 */
		if(money < p.price)
		{
			System.out.println("상품이 너무 비싸다");
			return ;
		}
		money -= p.price;
		bounsPoint += p.bonusPoint;
		items[index++] = p;
		System.out.println(p + "구매했다.");
	}
	
	public void summary()
	{
		/*
		 * for문을 사용해서 구입한 물건의 총합과 물건의 리스트를 출력...
		 * 필요한 변수는 로컬로 선언해서 로직을 작성
		 */
		
		System.out.println("지금까지 구매하신 물건 입니다.");
		for(Product p : items)
		{
			if(p==null) continue;
			System.out.println(p.toString());
		}
		System.out.println("============================================");
	}
	
	public void refund(Product p)
	{
		for(int i = 0 ; i < items.length; i++)
		{
			if(p.pNumber == items[i].getpNumber())
			{
				for(int j = i ; j < items.length -1 ; j++)
				{
					items[j] = items[j+1];
				}
				break;
			}//if
		}//for
		
		this.money += p.price;
		this.bounsPoint -= p.bonusPoint;
	}
}





























