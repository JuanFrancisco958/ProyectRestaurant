package Orders;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Vista.Syso;

@SuppressWarnings("serial")
@XmlRootElement(name = "RepositoryO")
@XmlAccessorType (XmlAccessType.FIELD)
public class RepositoryO implements Serializable{
	private static RepositoryO _instance;
	
	@XmlElement(name = "order")
	private List<Order> comandas=new ArrayList<>();	
	
	
	private RepositoryO() {
	}
	public static RepositoryO getInstance(){
        if(_instance==null){
            _instance = new RepositoryO();
        }
        return _instance;
    }
	public void setcomandas(List<Order> c) {
		comandas=c;
	}
	public List<Order> getAllOrders() {
		return comandas;
	}
	
	public List<Order> getOrdersByClient(String dni){
		List<Order> result=new ArrayList<>();
		if (dni!=null) {
			for (Order com : comandas) {
				if (com.getClient().getDni().equals(dni)) {
					result.add(com);
				}
			}
		}
		return result;
	}
	
	public List<Order> getOrdersByDate(LocalDate ini, LocalDate end){
		LocalDateTime inicio = ini.atStartOfDay();
		LocalDateTime fin= end.atStartOfDay();

		List<Order> result=new ArrayList<>();
		if (ini!=null && end!=null) {
			for (Order com : comandas) {
				if (com.getLocalDateTime().isAfter(inicio) && com.getLocalDateTime().isBefore(fin) ) {
					result.add(com);
				}
			}
			
		}
		return result;
	}
	
	public List<Order> getOrdersNoDelivered(){
		List<Order> result=new ArrayList<>();
		for (Order com : comandas) {
			if (com.isDelivered()==false) {
				result.add(com);
			}
		}
		return result;
		
	}
	
	public List<Order> getOrdersNoPayed(){
		List<Order> result=new ArrayList<>();;
		for (Order com : comandas) {
			if (com.isPayed()==false) {
				result.add(com);
			}
		}
		return result;		
	}
	
	public double getAllInput(){
		double result=0;
			for (Order com : comandas) {
				result+=com.getTotal();
			}
		return result;
		
	}
	
	public double getInputByDate(LocalDate ini, LocalDate end){
		List<Order> comand=getOrdersByDate(ini, end);
		double result=0;
			for (Order com : comand) {
				result+=com.getTotal();
			}
		return result;
		
	}
	public boolean addOrder(Order o) {
		boolean result=false;
		if (o!=null && !comandas.contains(o)) {
			try {
				comandas.add(o);
				o.getClient().addOrder(o.getId());
			} catch (Exception e) {
				Syso.print("Error al añadir la comnada");
			}
			
		}
		return result;
	}
	public boolean deleteOrder(Order o) {
		boolean result=false;
		if (o!=null) {
			comandas.remove(o);
			o.getClient().deleteOrder(o.getId());
		}
		return result;
	}
	
	
}
