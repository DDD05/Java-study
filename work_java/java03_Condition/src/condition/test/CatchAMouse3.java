package condition.test;

import java.util.Scanner;

/*
 * 고양이 A 	고양이 B	쥐새끼
 * 가까운놈이 잡는다. 같은 거리에 있다면 쥐를 놓친다.
 */
public class CatchAMouse3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cat = new int[2];
		int mouse;
		String result = "";
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < cat.length; i++)
		{
			cat[i] = sc.nextInt();
		}
		mouse = sc.nextInt();
		
		if(mouse - cat[0] == cat[1] - mouse)
			result = "Mouse Escapes!!";
		else 
			result = mouse-cat[0] > cat[1]-mouse ? "CatB Catch!" : "CatA Catch!";
		
		System.out.println(result);
	}

}
