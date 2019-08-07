package thread.exam2.test;

import javax.crypto.CipherOutputStream;
import javax.swing.JOptionPane;

/*
 * 카운팅 작업 CountingThread
 * 숫자를 입력 작업 InputThread
 * 
 * 카운팅이 끝났는데도 숫자입력이 안되면 종료
 * 숫자입력이 되면 카운팅을 더이상 하지 않도록
 */
public class InputThreadTest3 {
	public  boolean come = false;
	public static void main(String[] args)
	{
		new InputThreadTest3().init();
	}
	public void init()
	{
		InputThreadTest3 it = this;
		
		new Thread(new InputThread(it)).start();
		new Thread(new CountingThread(it)).start();
	}
}
class CountingThread implements Runnable
{
	private InputThreadTest3 test3;
	public CountingThread(InputThreadTest3 it) {
		super();
		test3 = it;
	}
	@Override
	public void run() {
		try
		{
			for(int i = 0 ; i <= 10; i++)
			{
				Thread.sleep(1000);
				System.out.println(i);
				if(test3.come)
					return;
			}
			System.exit(1);
		
		}catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
	}
	
}
class InputThread implements Runnable
{
	private InputThreadTest3 test3;
	public InputThread(InputThreadTest3 it) {
		super();
		test3 = it;
	}
	@Override
	public void run() {
		String input = JOptionPane.showInputDialog("숫자를 입력하세요");
		if(input != null || input != "")
			test3.come = true;
	}
	
}