package thread.exam3.test;

/*
 * 두개 이상의 쓰레드들이 동작
 * +
 * 프로세스의 자원의 공유하는 상황
 * --> 이때 동기화 처리를 안하게되면 어떤 문제점이 발생하는지를 보여주는 로직을 작성
 * --> 동기화처리를 하고 나서 안정적으로 작업이 진행되는지를 확인
 */
class MegaBoxCustom implements Runnable{

	@Override
	public void run() {
		// 좌석을 예매하는 기능을 작성...
		try {
			reservation();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void reservation() throws InterruptedException
	{
		String customName = Thread.currentThread().getName();
		System.out.println(customName + ", 좌석 예매 시작합니다...");
		
		
		if(MegaBoxProcess.seat == false)
		{
			Thread.sleep(1000);
			System.out.println(customName + ", 좌석 예매 success!!!");
			MegaBoxProcess.seat = true;
		}else
		{
			System.out.println(customName + ", 이미 예매된 좌석입니다...");
		}
	}
}
public class MegaBoxProcess {
	static boolean seat;
	
	public static void main(String[] args) {
		MegaBoxCustom custom = new MegaBoxCustom();
		Thread t1 = new Thread(custom,"효리");
		Thread t2 = new Thread(custom,"상순");
		
		t1.start();	//효리가 먼저 예매를 하러 출발
		t2.start();
	}

}
