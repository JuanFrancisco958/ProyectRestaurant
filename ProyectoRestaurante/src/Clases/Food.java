package Clases;

import java.util.UUID;

public class Food extends Product {
	private boolean forVegans;

	public Food(String name, double price, boolean forCeliac,boolean forVegans) {
		super(name, price, forCeliac);
		this.forVegans=forVegans;
	}

	@Override
	public double getBundlePack(UUID id) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}

	@Override
	public String getName(UUID id ) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}

	@Override
	public double getPrice(UUID id) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}

	@Override
	public boolean getItsForCeliac(UUID id) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return false;
	}
	public boolean isForVegans() {
		boolean result=false;
		return result;
	}

}
