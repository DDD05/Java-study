package config;

public interface ServerInfo {
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String USER = "root";
	String PASSWORD = "1234";
}
