package Controller;

import Clients.Client;
import Clients.RepositoryC;
import Interfacez.IOrderMenuController;
import Orders.Order;
import Orders.RepositoryO;
import Products.Repository;
import Utils.GUI;
import Utils.RepositoryUtil;
import Vista.Syso;

public  class NewCarrito implements IOrderMenuController{
	private static Order newOrder;
	private static Repository carta=new Repository();
	private static RepositoryO o=RepositoryO.getInstance();
	private static RepositoryC c=RepositoryC.getInstance();
	
	private static NewCarrito repositoryCar;
	
	
	public void NewCarritoO() {
		Client p=c.searchClient(GUI.getDni());
		if (!o.getAllOrders().isEmpty()) {
			
			
			try {
				Syso.printCarta();
				
				if (p!=null) {
					newOrder=new Order(p, o.getAllOrders().get(o.getAllOrders().size()-1).getId()+1, carta.searchProduct(GUI.getString("Intrduce el nombre del producto: ")).getId(), GUI.getAddress() );
				}
			} catch (Exception e) {
				Syso.print("Error al crear la orden.");
			}
		}else{
			try {
				Syso.printCarta();
				if (p!=null) {
				    newOrder=new Order( p, 1, carta.searchProduct(GUI.getString("Intrduce el nombre del producto: ")).getId(), GUI.getAddress() );
				}
			} catch (Exception e) {
				Syso.print("Error al crear la orden.");
			}
		}
	}
	private NewCarrito() {
		newOrder=null;
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
		try {
			newOrder.addProduct(GUI.getint("Introduce el id del producto:"));
		} catch (Exception e) {
			Syso.print("Error al agregar un producto");
		}
	}
	@Override
	public void editLine() {
		Syso.printCarta();

		int id=GUI.getint("Introduce el id del producto:");
		try {
			int n= GUI.getint("Cantidad a comprar:");
			for (int i = 0; i <n; i++) {
				newOrder.addProduct(id);
			}

		} catch (Exception e) {
			Syso.print("Error al editar productos. ");
		}
		
	}
	@Override
	public void removeLine() {
		Syso.printCarta();

		int id=GUI.getint("Introduce el id del producto:");
		try {
			int n= GUI.getint("Cantidad a comprar:");
			for (int i = 0; i <n; i++) {
				newOrder.deleteProduct(id);
			}

		} catch (Exception e) {
			Syso.print("Error al editar productos. ");
		}
		
	}
	@Override
	public void setAddress(String a) {
		try {
			newOrder.setAddress(a);	
		} catch (Exception e) {
			Syso.print("Error al añadir direccion.");
		}
			
	}
	@Override
	public void savePaid() {
		try {
			newOrder.setPayed(true);
			o.addOrder(newOrder);
			RepositoryUtil.exportarO(o);
			RepositoryUtil.exportarC(c);
		} catch (Exception e) {
			Syso.print("Error al guardar ");
		}
	}
	@Override
	public void saveNoPaid() {
		try {
			newOrder.setPayed(false);
			o.addOrder(newOrder);
			RepositoryUtil.exportarO(o);
			RepositoryUtil.exportarC(c);
		} catch (Exception e) {
			Syso.print("Error al guardar ");
		}
				
	}
	public void setDelivered() {
		newOrder.setDelivered(true);	
	}
	public static void sobreEscribir() {
		try {
			for (Order item : o.getAllOrders()) {
				if (item.getId()==newOrder.getId()) {
					item.setPayed(newOrder.isPayed());
					item.setDelivered(newOrder.isDelivered());
					item.setProducts(newOrder.getProducts());
					item.setTotal(newOrder.getTotal());
					RepositoryUtil.exportarO(o);
					RepositoryUtil.exportarC(c);		
					Syso.print(""+newOrder);

				}
			}
		} catch (Exception e) {
			
		}
		
	}
	public static void selectOrder(Client c) {
		try {
			Syso.printOrders();
			int n=GUI.getint("Introduce el id de la Orden");
			for (Order item : o.getAllOrders()) {
				if (item.getClient().equals(c)&& item.getId()==n) {
					newOrder=item;
				}
			}
		} catch (Exception e) {
			Syso.print("Error al buscar la orden ");
		}
	}
}
	
	
	