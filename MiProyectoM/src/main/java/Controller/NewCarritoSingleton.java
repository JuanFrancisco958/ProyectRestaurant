package Controller;
import java.util.ArrayList;

import java.util.List;

import Clients.Client;
import Products.Drink;
import Products.Product;

public class NewCarritoSingleton {
	private List<Product> CarOnline;
	private static NewCarritoSingleton repositoryCar;
	
	private NewCarritoSingleton() {
		this.CarOnline=new ArrayList<>();
	}
	
	public static NewCarritoSingleton getNewCarritoSingleton() {
		if(repositoryCar == null) {
			repositoryCar = new NewCarritoSingleton();
		}
		return repositoryCar;
	}
	
	public List<Product> getNewCarrito(){
		return this.CarOnline;
	}
		
	public boolean addToNewCarrito(Product e) {
		boolean addToNewCarrito = false;
		if (e!=null&&!this.CarOnline.contains(e)) {
			this.CarOnline.add(e);
			addToNewCarrito = true;
		}
		return addToNewCarrito;	
	}
	
	public boolean deleteFromNewCarrito(Product e) {
		boolean deleteFromNewCarrito = false;
		if (e!=null&&this.CarOnline.size()>0) {
			if (CarOnline.contains(e)) {
				this.CarOnline.remove(this.CarOnline.indexOf(e));
			}
		}
		return deleteFromNewCarrito;
	}
	
	public boolean deleteFromNewCarrito(String nombre) {
		boolean deleteFromNewCarrito = false;
		if (nombre!=null&&this.CarOnline.size()>0) {
			if (CarOnline.contains(nombre)) {
				this.CarOnline.remove(this.CarOnline.indexOf(nombre));
			}
		}
		return deleteFromNewCarrito;
	}
	
	public boolean deleteFromNewCarrito(int id) {
		boolean deleteFromNewCarrito = false;
		if (id!=0&&this.CarOnline.size()>0) {
			if (CarOnline.contains(id)) {
				this.CarOnline.remove(this.CarOnline.indexOf(id));
			}
		}
		return deleteFromNewCarrito;
	}
	
	public double calculatePriceNewCar() {
		 double result = 0;
		if (CarOnline != null) {
		for (Product precios: CarOnline) {
			result+= (double) repositoryCar.calculatePriceNewCar();

			}
		}
		return result;		
	}
	
	public boolean SetCarClient (Client c) {
		boolean SetCarClient = false;
		if (c!=null) {
			
			SetCarClient = true;
			
		}
		
		return SetCarClient;
		
	}
	
	  public boolean paraRepartir() {
		  boolean paraRepartir = false;
		  
		return paraRepartir;
	}
	  public boolean pagadoEnMano() {
		boolean pagadoEnMano = false;
		return pagadoEnMano;
	}
}
