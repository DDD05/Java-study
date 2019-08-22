package broker.dao.impl;
/*
 * Exception :: 
 * DuplicateSSNException,
 * RecordNotFoundException,
 * InvalidTransactionException
 * : 팔려는 주식의 숫자가 가지고 있는것 보다 더 많을
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.transaction.InvalidTransactionException;

import broker.dao.Database;
import broker.domain.CustomerRec;
import broker.domain.SharesRec;
import broker.domain.StockRec;
import broker.exception.DuplicateSSNException;
import broker.exception.RecordNotFoundException;
import config.ServerInfo;

public class DatabaseImpl implements Database {
	private static DatabaseImpl db = new DatabaseImpl("127.0.0.1");
	private DatabaseImpl(String server){
		 System.out.println("드라이버 로딩 성공...");
	 }
	public static DatabaseImpl getInstance()
	{	
		return db;	
	}
	 
	 //////// 공통적인 로직 /////////////////////
	 public Connection getConnect() throws SQLException{
		Connection conn = null;
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		 return conn;
	 }
	 
	 public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
		 if(ps != null) ps.close();
		 if(conn != null) conn.close();
	 }
	 public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException{
		 if(rs != null) rs.close();
			closeAll(ps, conn);
	 }
	 
	 //////////////// 비지니스 로직 ////////////////////////////////////
	 private boolean isExist(String ssn,Connection conn) throws SQLException{
		PreparedStatement ps = null;
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	 }
	 
	 public void addCustomer(CustomerRec cust)throws SQLException, DuplicateSSNException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConnect();
			if(isExist(cust.getSsn(),conn)) throw new DuplicateSSNException(cust.getName() + "님은 이미 회원이십니다.");
			String query = "INSERT INTO customer(ssn,cust_name,address) VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, cust.getSsn());
			ps.setString(2, cust.getName());
			ps.setString(3, cust.getAddress());
			System.out.println(ps.executeUpdate() + " row insert ok !!" );
		}finally{
			closeAll(ps, conn);
		}				 
	 }
	 public void deleteCustomer(String ssn)throws SQLException,RecordNotFoundException{
		 Connection conn = null;
		 PreparedStatement ps = null;		 
		 try{
			conn = getConnect();
			if(!isExist(ssn,conn)) throw new RecordNotFoundException(ssn + "은 회원가입이되어 있지않습니다.");
			String query = "DELETE FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			System.out.println(ps.executeUpdate() + " row delete ok !!" );
		 }finally{
			 closeAll(ps, conn);			 
		 }
	 }
	 public void updateCustomer(CustomerRec cust)throws SQLException, RecordNotFoundException{
		 Connection conn = null;
		 PreparedStatement ps = null;		
		 try{
			conn = getConnect();
			if(!isExist(cust.getSsn(),conn)) throw new RecordNotFoundException(cust.getSsn() + "은 회원가입이되어 있지않습니다.");
			String query = "UPDATE customer SET cust_name=?, address=? WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, cust.getName());
			ps.setString(2, cust.getAddress());
			ps.setString(3, cust.getSsn());
			System.out.println(ps.executeUpdate() + " row update ok !!" );
		 }finally{
			 closeAll(ps, conn);
		 }
	 }

	 public ArrayList<SharesRec> getPortfolio(String ssn)throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 ArrayList<SharesRec> v = new ArrayList<SharesRec>();
		 try{
				 conn = getConnect();
				 if(isExist(ssn, conn))
				 {
					 String query = "SELECT * FROM shares WHERE ssn=?";
					 ps = conn.prepareStatement(query);
					 ps.setString(1, ssn);
					 rs = ps.executeQuery();
					 while(rs.next())
					 {
						 v.add(new SharesRec(rs.getString("ssn"),rs.getString("symbol"),rs.getInt("quantity")));
					 }
				 }
		 }finally{
			 closeAll(rs, ps, conn);
		 }
		 return v; 
	 }
	
	 public CustomerRec getCustomer(String ssn)throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 CustomerRec cust = null;
		 try{
			conn = getConnect();
			String query = "SELECT * FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			if(rs.next())
			{
				cust = new CustomerRec(ssn, 
						rs.getString("cust_name"), 
						rs.getString("address"));
				cust.setPortfolio(getPortfolio(ssn));
			}
		 }finally{
			 closeAll(rs, ps, conn);
		 }
		 return cust;
	 }
	 public ArrayList<CustomerRec> getAllCustomers()throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 ArrayList<CustomerRec> list = new ArrayList<CustomerRec>();
		 try{
			 	conn = getConnect();
			 	String query = "SELECT * FROM customer";
			 	ps = conn.prepareStatement(query);
			 	rs = ps.executeQuery();
			 	while(rs.next())
			 	{
			 		list.add(new CustomerRec(rs.getString("ssn"), 
							rs.getString("cust_name"), 
							rs.getString("address"),
							getPortfolio(rs.getString("ssn"))));
			 	}
		 }finally{
			 closeAll(rs, ps, conn);
		 }
		 return list;
	 }
	 
	 public ArrayList<StockRec> getAllStocks()throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 ArrayList<StockRec> list = new ArrayList<StockRec>();
		 try{
			conn = getConnect();
			String query = "SELECT * FROM stock";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new StockRec(rs.getString("symbol"),rs.getDouble("price")));
			}
		 }finally{
			 closeAll(rs, ps, conn);
		 }
		 return list;
	 }

	 public void buyShares(String ssn, String symbol, int quantity)
	 				throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 try{
			 conn = getConnect();
			 String query = "SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
			 ps = conn.prepareStatement(query);
			 ps.setString(1, ssn);
			 ps.setString(2, symbol);
			 rs = ps.executeQuery();
			 if(rs.next()){ //기존의 주식을 얼마정도 갖고 있따.
				 int q = rs.getInt(1); //가지고 있는 주식의 수량
				 int newQuantity = q+quantity; //update문
				 String query1 = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
				 ps = conn.prepareStatement(query1);
				 ps.setInt(1, newQuantity);
				 ps.setString(2, ssn);
				 ps.setString(3, symbol);
				 System.out.println(ps.executeUpdate()+" row buyShares()....ok");
			 }else{ //주식이 없다
				 String query2 = "INSERT INTO shares VALUES(?,?,?)";
				 ps = conn.prepareStatement(query2);
				 ps.setString(1, ssn);
				 ps.setString(2, symbol);
				 ps.setInt(3, quantity);
				 System.out.println(ps.executeUpdate()+" row buyShares()...insert ok");
			 } 
		 }finally{
			 closeAll(rs, ps, conn);
		 }
				 
	 }

	 public void sellShares(String ssn, String symbol, int quantity)
			 throws SQLException,RecordNotFoundException,InvalidTransactionException{
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 try{
			 conn=  getConnect();
			 if(!isExist(ssn,conn)){
				 throw new RecordNotFoundException("주식을 팔려는 사람이 없어여..");
			 }else{
				 String query = "SELECT quantity FROM shares WHERE ssn=? AND symbol=?";
				 ps = conn.prepareStatement(query);
				 ps.setString(1, ssn);
				 ps.setString(2, symbol);
				 rs = ps.executeQuery();
				 rs.next(); //quantity 부분을 일단 가리키게 한다.
				 int q = rs.getInt(1); //100개 가지고 있다.
				 int newQuantity=q - quantity;//팔고 남은 주식의 수량..update
				 if(q==quantity){
					 //delete
					 String query1 = "DELETE FROM shares WHERE ssn=? AND symbol=?";
					 ps = conn.prepareStatement(query1);
					 ps.setString(1, ssn);
					 ps.setString(2, symbol);
					 System.out.println(ps.executeUpdate()+" row shares DELETE...1.");
				 }else if(q>quantity){
					 //update
					 String query2 = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
					 ps = conn.prepareStatement(query2);
					 ps.setInt(1, newQuantity);
					 ps.setString(2, ssn);
					 ps.setString(3, symbol);
					 System.out.println(ps.executeUpdate()+" row shares UPDATE..2");
				 }else{ //q<quantity인 경우..
					 //예외
					 throw new InvalidTransactionException("팔려는 주식의 수량이 넘 많아여..");
				 }
			 }
		 }finally{
			 closeAll(ps, conn);			 
		 }
	 }
	 
}//class


















