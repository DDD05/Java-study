package pizza.test;

import java.util.ArrayList;

import pizza.child.PotatoPizza;
import pizza.manage.PizzaMgrImpl;
import pizza.parent.Pizza;

public class PiazzMgrImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PizzaMgrImpl mgr = PizzaMgrImpl.getInstance();
		
		ArrayList<Pizza> list = new ArrayList<>();
		
		list.add(new PotatoPizza(12000,"Mr Pizza"));
		list.add(new PotatoPizza(18000,"Pizza Hut"));
		list.add(new PotatoPizza(22000,"Domino Pizza"));
		
		mgr.allMakePizza(list);
		
	}

}
