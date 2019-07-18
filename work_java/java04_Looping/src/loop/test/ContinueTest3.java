package loop.test;

/*
 * 1~1000 까지의 정수중에서 3의 배수의 합을 구해서 최종적으로 출력
 * for
 * sum 로컬변수 선언, 초기화
 * %
 * if
 * @@ 3의 배수가 아니라면 합산로직을 건너뛰도록 해주세요 @@
 */
public class ContinueTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		int k = 3;
		
		for(int i = k ; i <= 1000 ; i += k)
			sum += i;
		
		System.out.println(sum);
		
	}
	

}
