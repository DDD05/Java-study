package multiple;

public interface Movable {
	void moving();
	void moveX();
	void moveY();
}

interface Attackable extends Movable	// 기능 강화
{
	void attck();
	void depense();
}

class Fighter implements Attackable
{
	@Override
	public void attck() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void depense() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moving() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveX() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveY() {
		// TODO Auto-generated method stub
		
	}
}