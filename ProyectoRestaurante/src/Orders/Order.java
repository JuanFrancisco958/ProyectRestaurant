package Orders;
import Products.Product;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
	
	private Client client;
	private int orderNumber;
	private List<Product> putProducts;
	private DateLocal date;
	private String address;
	private boolean delivered=false; 
	private boolean payed=false;
	
	
	
	protected Order(Client client, int orderNumber, List<Product> putProducts, DateLocal date, String address,
			boolean delivered, boolean payed) {
		super();
		this.client = client;
		this.orderNumber = orderNumber;
		this.putProducts = putProducts;
		this.date = date;
		this.address = address;
		this.delivered = delivered;
		this.payed = payed;
	}

	public Order (Client client, int orderNumber, List<Product> putProducts) {
		this.client=client;
		this.putProducts=putProducts;
		this.orderNumber=orderNumber;
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
		this.orderNumber = orderNumber;
	}

	public List<Product> getPutProducts() {
		return putProducts;
	}

	public void setPutProducts(List<Product> putProducts) {
		this.putProducts = putProducts;
	}

	public DateLocal getDate() {
		return date;
	}

	public void setDate(DateLocal date) {
		this.date = date;
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
		return "Order [orderNumber=" + orderNumber + ", putProducts=" + putProducts + ", address=" + address
				+ ", delivered=" + delivered + ", payed=" + payed + "]";
	}
	
}
