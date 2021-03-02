package Interfacez;

import java.util.List;

import Products.Product;
/**
 * Interfaz de los productos del proyecto
 * @author JF
 *
 */
public interface IProduct {
	List<Product> getBundlePack();
	String getName();
	double getPrice();
	boolean getItsForCeliac();
	
}
