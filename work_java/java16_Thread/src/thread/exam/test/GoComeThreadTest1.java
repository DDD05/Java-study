package thread.exam.test;

class GoThread implements Runnable
{
	//스레드가 해야할 일
	public void run()
	{
		for(int i = 0 ; i < 10 ; i++)
		{
			try {
				Thread.sleep(1000);	
			} catch (InterruptedException e) {	
				//InterruptedException은 throw로 예외를 던질 수 없다. 
				// Runtime에서 발생하는 오류이고, run은 우리가 직접 호출하므로..
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : "+i);
		}
	}
}
class ComeThread extends Thread
{
	ComeThread()
	{
		super("ComeThread");
	}
	//스레드가 해야할 일
	public void run()
	{
		for(int i = 0 ; i < 10 ; i++)
		{
			try {
				Thread.sleep(1000);	
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ " : "+i);
		}
	}
}
public class GoComeThreadTest1 {

	public static void main(String[] args) {
		GoThread go = new GoThread();
		ComeThread come = new ComeThread();

		new Thread(go,"GoThread").start();
		come.start();
		System.out.println("hello world");
	}

}
