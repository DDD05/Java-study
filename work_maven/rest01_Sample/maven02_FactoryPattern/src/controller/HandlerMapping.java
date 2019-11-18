package controller;
//Component를 여러개 만들기위해서 여러개의 공장이 필요한건 아니다.
public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {	}
	public static HandlerMapping getInstance()
	{
		return factory;
	}
	
	//컴포넌트를 생성하는 기능...
	public Controller createController(String command)
	{
		Controller controller = null;
		if(command.equalsIgnoreCase("find"))
			controller = new FindController();
		return controller;
	}
}
