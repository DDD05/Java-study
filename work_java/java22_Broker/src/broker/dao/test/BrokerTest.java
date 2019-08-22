package broker.dao.test;

import java.sql.SQLException;

import broker.dao.impl.DatabaseImpl;
import broker.domain.CustomerRec;
import broker.exception.DuplicateSSNException;
import broker.exception.RecordNotFoundException;

public class BrokerTest {

	public static void main(String[] args) throws SQLException, DuplicateSSNException, RecordNotFoundException {
		DatabaseImpl db = DatabaseImpl.getInstance();
		//메소드 단위테스트...
		db.buyShares("777-777", "JDKK", 1);
	}

}
