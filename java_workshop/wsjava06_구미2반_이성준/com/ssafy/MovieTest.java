package com.ssafy;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MovieMgr cm = MovieMgr.getInstance();
		
		Movie[] movieList = new Movie[7];
		movieList[0] = new Movie("라이온킹", "존파브로", 0, "드라마", "새로운 세상, 너의 시대가 올 것이다!");
		movieList[1] = new Movie("나랏말싸미", "조철현", 0, "역사", "역사에 기록되지 못한 그들의 이야기가 시작된다");
		movieList[2] = new Movie("극한직업", "이병헌", 15, "코미디", "불철주야 달리고 구르지만 실적은 바닥, 급기야 해체 위기를 맞는..");
		movieList[3] = new Movie("명량", "김한민", 15, "액션, 드라마", "1597년 임진왜란 6년, 오랜 전쟁으로 인해 혼란이 극에 달한 조");
		movieList[4] = new Movie("국제시장", "윤제균", 12, "드라마", "1950년대 한국전쟁 이후로부터 현재에 이르기까지 격변의 시대를 ");
		movieList[5] = new Movie("도둑들", "최동훈", 15, "액션, 드라마", "한 팀으로 활동 중인 한국의 도둑 뽀빠이와 예니콜, 씹던껌, 잠파");
		movieList[6] = new Movie("퍼시잭슨과 번개도둑", "크리스 콜럼버스", 12, "판타지, 모험", "상상 이상의 판타지 거대한 신들의 전쟁이 시작된다! | 신들에 대적하는 새로운 영웅이 온다!");

		Movie[] crr;
		
		for(int i = 0 ; i < 7 ; i++)
			cm.add(movieList[i]);

		while(true) {

			System.out.println();System.out.println();
			System.out.println("#########################################################################################");
			System.out.println("#################################\t\t\t#################################");
			System.out.println("#################################\t영화 정보 검색\t#################################");
			System.out.println("#################################\t\t\t#################################");
			System.out.println("#########################################################################################");
			System.out.println("#################################\t1. 영화 정보 전체 출력\t#################################");
			System.out.println("#################################\t2. 영화 정보 전체 출력\t#################################");
			System.out.println("#################################\t3. 영화명 검색\t#################################");
			System.out.println("#################################\t4. 영화 정보 입력\t#################################");
			System.out.println("#################################\t5. 영화 정보 삭제\t#################################");
			System.out.println("#################################\t6. 영화 정보 입력\t#################################");
			System.out.println("#################################\t0. 종료\t\t#################################");
			System.out.println("#########################################################################################");
			System.out.print("\t\t\t\t입력 : ");
			int input = sc.nextInt();
		
			
			if(input == 0) break;
			switch(input) {
			case 1:
				System.out.print("제목을 입력하세요 ->");
				String title = sc.nextLine();
				System.out.print("감독명을 입력하세요 ->");
				String director = sc.nextLine();
				System.out.print("제한연력 입력하세요 ->");
				int grade = sc.nextInt();
				System.out.print("장르 입력하세요 ->");
				String genre = sc.nextLine();
				System.out.print("요약정보를 입력하세요 ->");
				String summary = sc.nextLine();
				Movie m = new Movie(title, director,grade,genre, summary);
				cm.add(m);

				System.out.println("**등록되었습니다**");
				break;
			case 2:
				System.out.println();System.out.println();
				System.out.println("#########################################################################################");
				System.out.println("#################################\t\t\t#################################");
				System.out.println("#################################\t전체 검색\t\t#################################");
				System.out.println("#################################\t\t\t#################################");
				System.out.println("#########################################################################################");
				crr = cm.search();
				for(Movie mov : crr) {
					if(mov != null)
						System.out.println(mov);
				}
				break;
			case 3:
				System.out.println("==========제목으로 검색==========");
				System.out.print("제목을 입력하세요 ->");
				String str = sc.nextLine();
				crr = cm.search(str);
				for(Movie mov : crr) {
					if(mov != null)
						System.out.println(mov);
				}
				break;
			case 4:
				System.out.println("==========장르로 검색==========");
				System.out.print("장르를 입력하세요 ->");
				String str1 = sc.nextLine();
				crr = cm.searchGenre(str1);
				for(Movie mov : crr) {
					if(mov != null)
						System.out.println(mov);
				}
				break;

			case 5:
				System.out.println("==========삭제==========");
				System.out.print("제목을 입력하세요 ->");
				String str2 = sc.nextLine();

				System.out.println("**삭제되었습니다**");
				cm.delete(str2);
				
				System.out.println("==========전체 검색==========");
				crr = cm.search();
				for(Movie mov : crr) {
					if(mov != null)
						System.out.println(mov);
				}
				break;
			}
			System.out.println();
		}
	}
}
