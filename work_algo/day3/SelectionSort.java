package day3;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,7,6,5,4,1};
		doSelection(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void doSelection(int[] arr)
	{
		int size = arr.length;
		for(int i = 0 ; i < size; i++)
		{
			int mindex = i;
			for(int j = i+1; j< size; j++)
			{
				if(arr[mindex] > arr[j])
				{
					mindex = j;
				}		
			}
			if(mindex != i)
			{
				int tmp = arr[mindex];
				arr[mindex] = arr[i];
				arr[i] = tmp;
			}
		}
	}
}
