package Interfacez;

import java.util.List;

/**
 * Interfaz de los productos del proyecto
 * @author JF
 *
 */
public interface IProduct {
	List<Integer> getBundlePack();
	String getName();
	double getPrice();
	boolean getItsForCeliac();
	
}
