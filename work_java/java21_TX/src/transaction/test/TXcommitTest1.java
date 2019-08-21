package transaction.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

/*
 * Transaction에	대한 로직을 살펴보는 간단판 코드
 * 2개의 쿼리문을 하나의 처리단위(Transaction)로 묶을 것이다.
 * 이때 2개의 쿼리가 모두 다 성공하지 않으면..rollback
 * 2개의 쿼리가 모두 다 성공한다면 ... commit
 * 이 모든 작업이 다 이루어진 다음에 다시 자동커밋 해제를 돌려놓겠다.
 * ::
 * Connection
 * setAutoCommit(false)
 * rollback()
 * setAutoCommit(true)
 */
public class TXcommitTest1 {
	public static void main(String[] args) throws Exception
	{
		new TXcommitTest1();
	}
	public TXcommitTest1() throws Exception
	{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("driver ...loading..");
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("db connection...");
		
		String query1 = "INSERT INTO ssafy VALUES(11,'이성준')";	// ok
		String query2 = "SELECT name FROM ssafy WHERE no=10";	//error
		
		//트랜잭션 시작
		conn.setAutoCommit(false);
		PreparedStatement ps1 = conn.prepareStatement(query1);
		ps1.executeUpdate();	//1번째 쿼리문이 실행... 디비에 데이터가 들어감....
		
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ResultSet rs = ps2.executeQuery();
		if(!rs.next())  //레코드가 존재하지 않는다면 .. rollback
		{ 
			System.out.println("찾는 번호가 존재하지 않습니다... 다시 입력바랍니다..");
			conn.rollback();
		}
		else	//레코드가 존재한다면... commit
		{
			System.out.println("원하는 번호에 레코드를 발견했습니다....");
			conn.commit();
		}
		
		
		
		//트랜잭션을 끝냄
		conn.setAutoCommit(true);
		
	}
}
