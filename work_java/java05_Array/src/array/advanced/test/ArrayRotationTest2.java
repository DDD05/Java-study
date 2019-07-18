package array.advanced.test;

import java.util.Arrays;

/*
 * ~ Test1 의 예제에서 만약에
 * 1. 배열의 길이가 10000개이상이고
 * 2. 회전의 횟수도 100000번 이상이면
 * 
 * 이전처럼 로직을 작성한다면 timeout이 발생할 여지가 있다.
 * 어떤 방법을 사용할까?
 */
public class ArrayRotationTest2 {

	public static void main(String[] args) {
		
//		int[] arr = {20,30,50,70,90};
//		int arrIndex = 2;	//회전횟수
//		int[] index = {2,0,1};
		// 시계방향으로 1번 회전 ... 90, 20 ,30 ,50 ,70
		// 시계방향으로 2번 회전 ... 70, 90, 20 ,30 ,50
		
		int[] arr = new int[90000];
		for(int i = 0 ; i < arr.length; i++)
		{
			arr[i] = i+1;	// 초기화
		}
		int arrIndex = 100000;	//회전회수
		int[] index = {2,0,1};
		
		int[] rotationArr = new int[arr.length];
		
		for(int i = 0 ; i < arr.length; i++)
		{
			arrIndex %= arr.length;
			rotationArr[arrIndex++] = arr[i];
		}
		System.out.println(Arrays.toString(rotationArr));
	
		for(int i : index)
		{
			System.out.print(rotationArr[i] + " ");
		}
	}

}
