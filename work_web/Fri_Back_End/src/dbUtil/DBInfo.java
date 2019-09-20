package dbUtil;

public interface DBInfo {
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String ip = "119.56.158.53";
	String URL = "jdbc:mysql://"+ip+":3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String USER = "dltjdwns";
	String PASSWORD = "1234";
}
