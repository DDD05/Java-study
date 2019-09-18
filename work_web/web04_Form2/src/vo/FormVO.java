package vo;

public class FormVO {
	private String id;
	private String password;
	private String gender;
	private String command;
	private String tel;
	private String intro;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "FormVO [id=" + id + ", password=" + password + ", gender=" + gender + ", command=" + command + ", tel="
				+ tel + ", intro=" + intro + "]";
	}
	public FormVO(String id, String password, String gender, String command, String tel, String intro) {
		super();
		this.id = id;
		this.password = password;
		this.gender = gender;
		this.command = command;
		this.tel = tel;
		this.intro = intro;
	}
	public FormVO() {
		super();
	}
	
}
