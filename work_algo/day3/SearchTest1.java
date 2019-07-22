package day3;

public class SearchTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,3,5,8,2,9,6};
		int key = 10;	//찾고 싶은 값
		boolean flag = searchKey(key,arr);
		System.out.println(flag);
	}
	public static boolean searchKey(int key , int[] arr)	
	{
		boolean flag = false;
		for(int i = 0 ; i < arr.length; i++)
		{
			if(arr[i] == key)
			{
				flag = true;
			}
		}
		return flag;
	}

}
