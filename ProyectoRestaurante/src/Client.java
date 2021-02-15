package Clases;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
	
	
	private ArrayList<String> address=new ArrayList<>();
	private int[] order;
	private int points;
	
	public Client(String dni, String name, int age) {
		super(dni, name, age);
	}
		
	public ArrayList<String> getAddress() {
		return address;
	}
	public void setAddress(ArrayList<String> address) {
		this.address = address;
	}
	public int[] getOrder() {
		return order;
	}
	public void setOrder(int[] order) {
		this.order = order;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	

}
