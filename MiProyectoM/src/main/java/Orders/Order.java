package Orders;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import Clients.Client;
import Products.Product;
import Utils.LocalDateAdapter;

/**
 * Clase Order. 
 * @author JF
 *
 */
@XmlRootElement(name = "order")
@XmlAccessorType (XmlAccessType.FIELD)
public class Order implements Serializable{
	//Atributos.
	private Client client;
	private Integer id;
	private List<Integer> Products=new ArrayList<>();
	private double total;
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	LocalDateTime localDateTime = LocalDateTime.now();
	private String address;
	private boolean delivered;
	private boolean payed;
	private  Order() {}
	
	/**
	 * Constructor full.
	 * @param client Cliente asociado a la orden.
	 * @param id úmero identificador de cada orden.
	 * @param products Lista de productos.
	 * @param total Precio de todos los productos sumados.
	 * @param localDateTime Fecha de la creacion de la orden.
	 * @param address Dirección del cliente.
	 * @param delivered Si está o no entregada.
	 * @param payed Si está o no pagado.
	 */
	public Order(Client client, Integer id, List<Integer> products, double total, LocalDateTime localDateTime,
			String address, boolean delivered, boolean payed) {
		super();
		this.client = client;
		this.id = id;
		Products = products;
		this.total = total;
		this.localDateTime = localDateTime;
		this.address = address;
		this.delivered = delivered;
		this.payed = payed;
	}

	/**
	 * Constructor seguro.
	 * @param client Cliente asociado a la orden.
	 * @param id úmero identificador de cada orden.
	 * @param products Lista de productos.
	 * @param address Dirección del cliente.
	 * @param delivered Si está o no entregada.
	 * @param payed Si está o no pagado.
	 */
	public Order( Client client,Integer id, Integer product,String address, boolean delivered, boolean payed) {
		this.id=id;
		this.client = client;
		Products.add(product);
		this.address = address;
		/*this.total=getAllInput();*/
		this.delivered = delivered;
		this.payed = payed;
	}

	//Métodos Getters y Setters de los atributos.
	protected Integer getId() {
		return id;
	}
	protected void setId(Integer id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client c) {
		this.client = c;
	}
	public List<Integer> getProducts() {
		return Products;
	}
	public void setProducts(List<Integer> products){
		this.Products=products;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	public boolean isPayed() {
		return payed;
	}
	public void setPayed(boolean payed) {
		this.payed = payed;
	}
	
	//Metodos de introducción y eliminacion para los productos.
	public void addNewProducts(List<Integer> products) {
		Products.addAll(products);
	}
	public void clearAllProducts() {
		Products.clear();
	}
	public void addProduct(Integer p) {
		Products.add(p);
	}
	public void deleteProduct(Integer p) {
		Products.remove(p);
	}
	/*public Product getAllInput() {
		Product result;
		 if (Products!=null) {
			for (Product item : Products) {
				result+=item;
			}
		}
		return result;
	}*/

	
	//Método para comparar dos ordenes.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//Método para imprimir una orden.
	@Override
	public String toString() {
		return "Order [client=" + client.getDni() + ", id=" + id + ", Products=" + Products.size() + ", total=" + total
				+ ", localDateTime=" + localDateTime + ", address=" + address + ", delivered=" + delivered + ", payed="
				+ payed + "]";
	}

	

	
	
	
	
}
