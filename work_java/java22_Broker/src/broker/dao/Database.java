package broker.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.transaction.InvalidTransactionException;

import broker.domain.CustomerRec;
import broker.domain.SharesRec;
import broker.domain.StockRec;
import broker.exception.DuplicateSSNException;
import broker.exception.RecordNotFoundException;

public interface Database {
	void addCustomer(CustomerRec cust)throws SQLException, DuplicateSSNException;
	void deleteCustomer(String ssn)throws SQLException,RecordNotFoundException;
	void updateCustomer(CustomerRec cust)throws SQLException, RecordNotFoundException;
	ArrayList<SharesRec> getPortfolio(String ssn)throws SQLException;
	CustomerRec getCustomer(String ssn)throws SQLException;
	ArrayList<CustomerRec> getAllCustomers()throws SQLException;
	ArrayList<StockRec> getAllStocks()throws SQLException;
	void buyShares(String ssn, String symbol, int quantity)throws SQLException;
	void sellShares(String ssn, String symbol, int quantity)
			 throws SQLException,RecordNotFoundException,InvalidTransactionException;
}
