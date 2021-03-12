package Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import Interfacez.IProduct;
/**
 * Superclase Producto.
 * @author JF
 *
 */
@SuppressWarnings("serial")
@XmlRootElement(name = "Products")
@XmlAccessorType (XmlAccessType.FIELD)
abstract public class Product implements IProduct, Serializable {
	//Atributos
	protected int id;
	protected String name;
	protected double price;
	protected boolean forCeliac;
	protected List<Integer> bundle;
	protected Product() {}
	
	/**
	 * Constructor Full
	 * @param id Numero identificador del producto.
	 * @param name Nombre del producto.
	 * @param price Precio del producto.
	 * @param forCeliac Si es o no para celiacos.
	 * @param bundle Lista de enteros identificadores de productos para descuentos.
	 */
	public Product(int id, String name, double price, boolean forCeliac, List<Integer> bundle) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.forCeliac = forCeliac;
		this.bundle = bundle;
	}

	/**
	 * Constructor full(solo con un entero en la lista bundle).
	 * @param id Numero identificador del producto.
	 * @param name Nombre del producto.
	 * @param price Precio del producto.
	 * @param forCeliac Si es o no para celiacos.
	 * @param bundle Lista de enteros identificadores de productos para descuentos.
	 */
	public Product(int id, String name, double price, boolean forCeliac, Integer bundle) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.forCeliac = forCeliac;
		this.bundle.add(bundle);
	}
	
	/**
	 * Constructor que no añade bundle.
	 * @param id Numero identificador del producto.
	 * @param name Nombre del producto.
	 * @param price Precio del producto.
	 * @param forCeliac Si es o no para celiacos.
	 */
	public Product(int id, String name, double price, boolean forCeliac) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.forCeliac = forCeliac;
		this.bundle=new ArrayList<Integer>();
	}
	
	//Métedos Getters and Setters de los atributos.
	public int getId() {
		return id;
	}
	
	public List<Integer> getBundle() {
		return bundle;
	}

	public void setBundle(List<Integer> bundle) {
		this.bundle = bundle;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isForCeliac() {
		return forCeliac;
	}
	public void setForCeliac(boolean forCeliac) {
		this.forCeliac = forCeliac;
	}
	
	//Metodo de comparación entre dos productos.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	//Método para imprimir un producto
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", forCeliac=" + forCeliac + ", bundle="
				+ bundle + "]";
	}

	
	

}
