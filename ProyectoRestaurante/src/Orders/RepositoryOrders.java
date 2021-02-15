package Orders;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RepositoryOrders {
	
	private List<Order> orders = new ArrayList<>();
	
	public void RepositoryOrder(List<Order> orders) {
		this.setOrders(orders);
	}
	
	public void getAllOrders() {
		orders.forEach(p->System.out.println());
	}
	
	public List<Order> getOrdersByClient(String dni){
		return null;
	}
	
	public List<Order> getOrdersByDate(LocalDate ini, LocalDate end){
		return null;
	}
	
	public List<Order> getOrdersNoDelivered(){
		return null;
	}
	
	public List<Order> getOrdersNoPayed(){
		return null;
	}
	
	public List<Order> getAllInput() {
		return null;
	}
	
	public List<Order> getInputByDate (LocalDate ini, LocalDate end) {
		return null;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
