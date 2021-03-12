package Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase Food extendida de Producto
 * @author JF
 *
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "Food")
@XmlAccessorType (XmlAccessType.FIELD)
public class Food extends Product implements Serializable{
	//Atributos
	private boolean forVegans;
	@SuppressWarnings("unused")
	private Food() {}

	/**
	 * Contructor full.
	 * @param id Numero identificador del producto.
	 * @param name Nombre del producto.
	 * @param price Precio del producto.
	 * @param forCeliac Si es o no para celiacos.
	 * @param bundle Lista de enteros identificadores de productos para descuentos.
	 * @param forVegans Si es o no para veganos.
	 */
	public Food(int id, String name, double price, Integer bundle, boolean forCeliac,boolean forVegans) {
		super(id, name, price, forCeliac,bundle);
		this.forVegans=forVegans;
	}
	
	/**
	 * Contructor que no añade bundle.
	 * @param id Numero identificador del producto.
	 * @param name Nombre del producto.
	 * @param price Precio del producto.
	 * @param forCeliac Si es o no para celiacos.
	 * @param forVegans Si es o no para veganos.
	 */
	public Food(int id, String name, double price, boolean forCeliac, boolean forVegans) {
		super(id, name, price, forCeliac);
		this.forVegans = forVegans;
	}


	//Métodos Getters and Setters de los atributos.
	
	public List<Integer> getBundlePack() {
		List<Integer> result=new ArrayList<>();
		result=this.bundle;
		return result;
	}

	@Override
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	@Override
	public double getPrice() {
		return this.price;
	}
	@Override
	public boolean getItsForCeliac() {
		return this.forCeliac;
	}
	public boolean isForVegans() {
		return isForCeliac();
	}
	
	//Método para imprimir una comida.
	@Override
	public String toString() {
		return super.toString()+"  forVegans= " + forVegans + "]";
	}
	
}
