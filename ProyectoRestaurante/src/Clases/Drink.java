package Clases;


public class Drink extends Product{
	private boolean alcoholic;
	
	
	public Drink(int id, String name, double price, boolean forCeliac,boolean alcoholic) {
		super(id, name, price, forCeliac);
		this.alcoholic=alcoholic;
	}

	@Override
	public double getBundlePack(int id) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}

	@Override
	public String getName(int id) {
		String result="null";
		result=this.name;
		return result;
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
	
	public boolean isAlcoholicUU(int id) {
		boolean result=false;
		return result;
	}

	@Override
	public String toString() {
		return "Drink ["+super.toString()+"alcoholic=" + alcoholic + "]";
	}
	
	
}
