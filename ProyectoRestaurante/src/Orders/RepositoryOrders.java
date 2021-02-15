package Orders;
import java.time.LocalDate;
import java.util.List;
import Interfacez.
/**
 * 
 * @author nicor
 *
 */
public class RepositoryOrders {
	
	private List<IOrder> orders;
	
	public RepositoryOrder(List<IOrder> orders) {
		super();
		this.orders = orders;
	}
	
	@Override
	public List<IOrder> getAllOrders() {
		return null;
	}
	
	@Override
	public List<IOrder> getOrdersByClient(String dni){
		return null;
	}
	
	public List<IOrder> getOrdersByDate(LocalDate ini, LocalDate end){
		return null;
	}
	
	public List<IOrder> getOrdersNoDelivered(){
		return null;
	}
	
	public List<IOrder> getOrdersNoPayed(){
		return null;
	}
	
	public List<IOrder> getAllInput() {
		return null;
	}
	
	public List<IOrder> getInputByDate (LocalDate ini, LocalDate end) {
		return null;
	}
}
