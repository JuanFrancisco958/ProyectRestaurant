package Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase Drink extendida de producto.
 * @author JF
 *
 */
@XmlRootElement (name = "Drink")
@XmlAccessorType (XmlAccessType.FIELD)
public class Drink extends Product implements Serializable{
	//Atributos
	private boolean alcoholic;
	private Drink() {}
	
	/**
	 * Contructor full.
	 * @param id Numero identificador del producto.
	 * @param name Nombre del producto.
	 * @param price Precio del producto.
	 * @param forCeliac Si es o no para celiacos.
	 * @param bundle Lista de enteros identificadores de productos para descuentos.
	 * @param alcoholic Si contiene o no alcohol.
	 */
	public Drink(int id, String name, double price,Integer bundle, boolean forCeliac,boolean alcoholic) {
		super(id, name, price, forCeliac,bundle);
		this.alcoholic=alcoholic;
	}
	
	/**
	 * Constructor que no añade bundle.
	 * @param id Numero identificador del producto.
	 * @param name Nombre del producto.
	 * @param price Precio del producto.
	 * @param forCeliac Si es o no para celiacos.
	 * @param alcoholic Si contiene o no alcohol.
	 */
	public Drink(int id, String name, double price, boolean forCeliac, boolean alcoholic) {
		super(id, name, price, forCeliac);
		this.alcoholic = alcoholic;
	}



	//Métodos Getters and Setters de los atributos.
	public List<Product> getBundlePack() {
		List<Product> result=new ArrayList<>();
		return result;
	}
	public boolean isAlcoholic() {
		return alcoholic;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public double getPrice() {
		return this.price;
	}
	
	public boolean getItsForCeliac() {
		return isForCeliac();
	}
	
	
	//Método para imprimir una bebida.
	@Override
	public String toString() {
		return super.toString()+"  alcoholic= " + alcoholic + "]";
	}
	
	
}
