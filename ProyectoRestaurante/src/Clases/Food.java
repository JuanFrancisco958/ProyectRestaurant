package Clases;

public class Food extends Product {
	private boolean forVegans;

	public Food(int id, String name, double price, boolean forCeliac,boolean forVegans) {
		super(id, name, price, forCeliac);
		this.forVegans=forVegans;
	}

	@Override
	public double getBundlePack(int id) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}

	@Override
	public String getName(int id ) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}

	@Override
	public double getPrice(int id) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}

	@Override
	public boolean getItsForCeliac(int id) {
		boolean result=false;
		return result;
	}
	public boolean isForVegans(int id) {
		boolean result=false;
		return result;
	}

	@Override
	public String toString() {
		return "Food ["+super.toString()+"forVegans=" + forVegans + "]";
	}
	
}
