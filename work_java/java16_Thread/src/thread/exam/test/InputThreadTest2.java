package thread.exam.test;

import javax.swing.JOptionPane;

public class InputThreadTest2 {

	public static void main(String[] args)  {
		
		CountingThread ct = new CountingThread(100);
		new Thread(ct).start();
		
		String input = JOptionPane.showInputDialog("숫자를 입력하세요");
		System.out.println("input : " + input);
	
	}//main
	

}

class CountingThread implements Runnable
{
	private int input;
	public CountingThread()
	{
		input = 10;
	}
	public CountingThread(int input) {
		this.input = input;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < input ; i++)
		{
			//일종의 카운팅 작업
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
