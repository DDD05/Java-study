package com.ssafy.java;

import java.util.Scanner;

/**
 * @author 이성준
 * @Date   2019. 7. 18.
 */
public class GameTest {
	private int randomNum;
	Scanner input = new Scanner(System.in);
	private int playGameCnt;
	private int winCnt;
	private int loseCnt;
	
	public void IOHandler()
	{

		System.out.println(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요. ");
		int selectMenuNum = input.nextInt();
		if(selectMenuNum == 1)
			this.playGameCnt = 5;
		else if(selectMenuNum == 2)
			this.playGameCnt = 3;
		else if(selectMenuNum == 3)
			this.playGameCnt = 1;
		playGame();
	}
	
	public void playGame()
	{
		for(int i = 0 ; i < this.playGameCnt ; i++)
		{
			System.out.print("가위바위보 중 하나 입력:");
			int user = input.nextInt();
			int computer = (int)(Math.random()*3) + 1;
			if(user > computer || computer-user == 2)
			{
				System.out.println("이겼습니다!!!");
				this.winCnt++;
			}
			else if(user == computer)
			{
				System.out.println("비겼습니다.");
			}
			else
			{
				System.out.println("졌습니다.");
				this.loseCnt++;
			}
			if(this.winCnt == (this.playGameCnt/2) +1 )
			{
				System.out.println("### 플레이어 승리!!!");
			}
			else if(this.loseCnt == (this.playGameCnt/2) +1)
			{
				System.out.println("### 컴퓨터 승!!!");
			}
		} 
	}

}
