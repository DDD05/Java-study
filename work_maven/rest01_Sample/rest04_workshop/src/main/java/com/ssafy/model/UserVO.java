package  com.ssafy.model;

public class UserVO {
	public String userID;
	public String userPwd;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Override
	public String toString() {
		return "UserVO [userID=" + userID + ", userPwd=" + userPwd + "]";
	}
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVO(String userID, String userPwd) {
		super();
		this.userID = userID;
		this.userPwd = userPwd;
	}
}
