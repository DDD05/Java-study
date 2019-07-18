package array.basic.test;

public class ArrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[9];
		for(int i = 0 ; i < nums.length ; i++)
		{
			nums[i] = 3 * (i+1);	// 3,6,9,12,15,18,21,27
			System.out.println(nums[i]+" ");
		}
		
		int sum = 0;
		for(int i = 0 ; i < nums.length ; i++ )
		{
			if( i % 2 == 0)	// i가 0부터 시작 ... i 는 값이 아니라 인덱스이기 때문에 결과적으로 홀수의 종합이 나온다.
			{
				sum += nums[i];
			}
		}
		
		// 인덱스가 아니라 실제 값이 짝수인 합을 구하기 위해서는 ... 향상된 for
		for(int num : nums)
		{
			if( num % 2 == 0 )
			{
				sum += num;
			}
		}
		System.out.println(sum);
		System.out.printf("홀수번째 요소들의 합은 :: %d\n",sum);
	}

}
