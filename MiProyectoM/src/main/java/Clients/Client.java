package Clients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import Utils.RepositoryUtil;

@SuppressWarnings("serial")
@XmlAccessorType (XmlAccessType.FIELD)
public class Client extends Person implements Serializable{
	private List<String> address=new ArrayList<>();
	private List<Integer> orders=new ArrayList<>();
	private int points=0;
	RepositoryUtil u= new RepositoryUtil();


	@SuppressWarnings("unused")
	private Client() {
		super();
	}


	public Client(String dni, String name, int age,String addres) {
		super(dni, name, age);
		address.add(addres);
		this.points=0;
	}

	
	//Metodos Getters y Setters de los atributos
	public List<String> getAddress() {
		return address;
	}
	public List<Integer> getOrders() {
		return orders;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	//Metodos para las lista
	public boolean addOrder(Integer o) {
		boolean result=false;
		if (o!=null) {
			orders.add(o);
		}
		return result;
	}
	public boolean deleteOrder(Integer o) {
		boolean result=false;
		if (o!=null) {
			orders.remove(o);
		}
		return result;
	}
	public boolean addAddress(String address) {
		boolean result=false;
		if (address!=null && !this.address.contains(address)) {
			this.address.add(address);
		}
		return result;
	}
	public boolean deleteAddress(String address) {
		boolean result=false;
		if (address!=null) {
			this.address.remove(address);
		}
		return result;
	}
	

	@Override
	public String toString() {
		return super.toString()+" address=" + address.size() + ", orders=" + orders.size() + ", points=" + points + "]";
	}
	

}
