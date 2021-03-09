package Controller;

import Clients.RepositoryC;
import Interfacez.IOrderMenuController;
import Orders.Order;
import Orders.RepositoryO;
import Products.Repository;
import Utils.GUI;
import Vista.Syso;

public  class NewCarrito implements IOrderMenuController{
	private Order newOrder;
	private Repository carta=new Repository();
	private RepositoryO o=RepositoryO.getInstance();
	private RepositoryC c=RepositoryC.getInstance();
	private static NewCarrito repositoryCar;
	
	
	public void NewCarritoO() {
		try {
			this.newOrder=new Order(c.searchClient(GUI.getDni()), o.getAllOrders().get(o.getAllOrders().size()-1).getId()+1, carta.searchProduct(GUI.getString("Intrduce el nombre del producto: ")).getId(), GUI.getString("Introduce la dirreccion") );
		} catch (Exception e) {
			Syso.print("Error al crear la orden.");
		}
	}
	private NewCarrito() {
		this.newOrder=null;
	}
	
	public static NewCarrito getInstanced() {
		if(repositoryCar == null) {
			repositoryCar = new NewCarrito();
		}
		return repositoryCar;
	}


	@Override
	public void addProduct() {
		Syso.printCarta();
		newOrder.addProduct(GUI.getint("Introduce el id del producto:"));
	}
	@Override
	public void editLine() {
		int id=GUI.getint("Introduce el id del producto:");
		for (int i = 0; i < GUI.getint("Cantidad a comprar:"); i++) {
			newOrder.addProduct(id);
		}
	}
	@Override
	public void removeLine() {
		int id=GUI.getint("Introduce el id del producto:");
		for (int i = 0; i < GUI.getint("Cantidad a comprar:"); i++) {
			newOrder.deleteProduct(id);
		}
	}
	@Override
	public void setAddress(String a) {
		newOrder.setAddress(a);;		
	}
	@Override
	public void savePaid() {
		newOrder.setPayed(true);
		o.addOrder(newOrder);
		GUI.exportarO(o);
		GUI.exportarC(c);
	}
	@Override
	public void saveNoPaid() {
		newOrder.setPayed(false);
		o.addOrder(newOrder);
		GUI.exportarO(o);
		GUI.exportarC(c);		
	}
}
	
	
	