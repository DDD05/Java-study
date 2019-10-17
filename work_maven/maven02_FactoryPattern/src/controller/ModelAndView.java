package controller;

/*
 * 결과 페이지에 대한 이름과
 * 이동결로에 대한 정보를 가지고 있는 클래스
 * 
 */
public class ModelAndView {
	private String path;
	private boolean isRedirect;	//false ---> forward
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView() {
		super();
	}
	public ModelAndView(String path) {
		super();
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
