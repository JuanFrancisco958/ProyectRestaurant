package Orders;
import Products.*;
import Clases.*;

import java.util.Date;
import java.util.List;

public class Order {
	
	private Client client;
	private static int orderNumber;
	private List<Product> Products;
	private Date LocalDateTime;
	private double total;
	private String address;
	private boolean delivered=false; 
	private boolean payed=false;
	
	
	
	@SuppressWarnings("static-access")
	protected Order(Client client, int orderNumber,List<Product>Products,Date LocalDateTime, String address,
			boolean delivered, boolean payed) {
		super();
		this.client = client;
		this.orderNumber = orderNumber;
		this.Products = Products;
		this.LocalDateTime = LocalDateTime;
		this.address = address;
		this.delivered = delivered;
		this.payed = payed;
	}

	public Order (Client client, int orderNumber, List<Product> Products) {
		this.client=client;
		this.Products=Products;
		Order.orderNumber=orderNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		Order.orderNumber = orderNumber;
	}

	public List<Product> getProducts() {
		return Products;
	}

	public void setPutProducts(List<Product> Products) {
		this.Products = Products;
	}

	public Date getLocalDateTime() {
		return LocalDateTime;
	}

	public void setLocalDateTime(Date localDateTime) {
		LocalDateTime = localDateTime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setProducts(List<Product> products) {
		Products = products;
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

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", putProducts=" + Products + ", address=" + address
				+ ", delivered=" + delivered + ", payed=" + payed + "]";
	}
	
}
