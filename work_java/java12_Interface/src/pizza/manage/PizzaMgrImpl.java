package pizza.manage;

import java.util.ArrayList;

import pizza.parent.Pizza;

public class PizzaMgrImpl implements PizzaMgr{
	
	private static PizzaMgrImpl mgr = new PizzaMgrImpl();
	
	private PizzaMgrImpl() {}
	public static PizzaMgrImpl getInstance()
	{
		return mgr;
	}
	
	
	@Override
	public void allMakePizza(ArrayList<Pizza> list) {
		// TODO Auto-generated method stub
		for(Pizza p : list)
		{
			p.orderMaking();
			System.out.println("################################################");
		}
	}
	
}
