package Controller;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import Clients.Client;
import Clients.RepositoryC;
import Interfacez.IMainMenuController;
import Orders.Order;
import Orders.RepositoryO;
import Products.Repository;
import Utils.GUI;
import Vista.Syso;

public class MainMenu implements IMainMenuController{

	public static void main(String[] args) throws ClassNotFoundException  {
		//Repository carta=new Repository();
		//RepositoryC clientes=RepositoryC.getInstance();
		//RepositoryO comandas=RepositoryO.getInstance();
		//GUI.importarC(clientes);
		//GUI.importarO(comandas);
	
		//comandas.getAllOrders().forEach(item->System.out.println(item));
		//clientes.getAllClients().forEach(item->System.out.println(item));
		
		//GUI.exportarC(clientes);
		//GUI.exportarO(comandas);
		run();
	}
	public static void run() {
		Syso.menuP();
		Syso.menuDeBienvenida();
		RepositoryC c=RepositoryC.getInstance();
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarC(c);
		GUI.importarO(o);
		menuPrincipal();
	}
	public static void menuPrincipal() {
		MainMenu u=new MainMenu();	
		Syso.menuPrincipal();
		int n=GUI.getint("");
		while (n<=0||n>=7){
			Syso.print("Fuera de rango");
			n=GUI.getint("");
		}
		
		switch (n) {
		case 1:
			menuCartaOferta();
			break;
		case 2:
			menuPedidos();
			break;
		case 3:
			menuClientes();
			break;
		case 4:
			menuFinanzas();
			break;
		case 5:
			menuCarrito();;
			break;
		case 6:
			u.saveAllAndClose();
			break;
		case 7:
			Syso.menuDeDespedida();
			break;

		default:
			break;
		}
	}
	
	public static void menuCartaOferta() {
		Syso.menuMenuOferta();
		Repository c=new Repository();
		int n=GUI.getint("");
		while (n<=0||n>=5){
			Syso.print("Fuera de rango");
			n=GUI.getint("");
		}

		switch (n) {
		case 1:
			Syso.printCarta();
			menuCartaOferta();
			break;
		case 2:
			Syso.printF(c.getAllFoods());
			menuCartaOferta();
			break;
		case 3:
			Syso.printD(c.getAllDrinks());
			menuCartaOferta();
			break;
		case 4:
			Syso.printP(c.getBundleProducts());
			menuCartaOferta();
			break;
		case 5:
			menuPrincipal();
			break;

		default:menuPrincipal();
			break;
		}
	}
	
	public static void menuPedidos() {
		Syso.menuPedidosRealizados();
		MainMenu u=new MainMenu();
		RepositoryC c=RepositoryC.getInstance();
		GUI.importarC(c);
		int n=GUI.getint("");
		while (n<=0||n>=5){
			Syso.print("Fuera de rango");
			n=GUI.getint("");
		}
		
		switch (n) {
		case 1:
			Syso.printOrders();
			menuPedidos();
			break;
		case 2:
			u.viewOrdersNotPayed();
			menuPedidos();
			break;
		case 3:
			u.viewOrdersPendingDelivered();
			menuPedidos();
			break;
		case 4:
			u.deleteOrder(c.searchClient(GUI.getDni()));
			menuPedidos();
			break;
		case 5:
			menuPrincipal();
			break;
		
		default:menuPrincipal();
			break;
		}
	}
	public static void menuClientes() {
		Syso.menuClientes();
		MainMenu u=new MainMenu();
		RepositoryC c=RepositoryC.getInstance();
		GUI.importarC(c);
		int n=GUI.getint("");
		while (n<=0||n>=7){
			Syso.print("Fuera de rango");
			n=GUI.getint("");
		}
		
		switch (n) {
		case 1:
			u.newClient();
			menuClientes();
			break;
		case 2:
			c.searchClient(GUI.getDni()).addAddress("Introduce la direccion");
			menuClientes();
			break;
		case 3:
			c.searchClient(GUI.getDni()).setAge(GUI.getAge());
			menuClientes();
			break;
		case 4:
			Syso.printClients();
			menuClientes();
			break;
		case 5:
			GUI.exportarC(c);
			menuClientes();
			break;
		case 6:
			menuPrincipal();
			break;

		default:menuPrincipal();
			break;
		}
	}
	public static void menuFinanzas() {
		Syso.menuFinanzas();
		MainMenu u=new MainMenu();
		int n=GUI.getint("");
		while (n<=0||n>=5){
			Syso.print("Fuera de rango");
			n=GUI.getint("");
		}
		switch (n) {
		case 1:
			u.cashTotal();
			menuFinanzas();
			break;
		case 2:
			u.cashThisMonht();
			menuFinanzas();
			break;
		case 3:
			u.cashToday();
			menuFinanzas();
			break;
		case 4:
			u.cashNoPayed();
			menuFinanzas();
			break;
		case 5:
			menuPrincipal();
			break;

		default:menuPrincipal();
			break;
		}
	}
		@SuppressWarnings("static-access")
		public static void menuCarrito() {
			Syso.menuCarrito();
			MainMenu u=new MainMenu();
			RepositoryC c=RepositoryC.getInstance();
			NewCarrito ca=NewCarrito.getInstanced();
			int n=GUI.getint("");
			while (n<=0||n>=12){
				Syso.print("Fuera de rango");
				n=GUI.getint("");
			}
			switch (n) {
			case 1:
				ca.NewCarritoO();
				menuCarrito();
				break;
			case 2:
				ca.addProduct();
				menuCarrito();
				break;
			case 3:
				ca.editLine();
				menuCarrito();
				break;
			case 4:
				ca.removeLine();
				menuCarrito();
				break;
			case 5:
				ca.setAddress(GUI.getString("Introduce la direccion:"));
				menuCarrito();
				break;
			case 6:
				ca.saveNoPaid();
				menuCarrito();
				break;
			case 7:
				ca.savePaid();
				menuCarrito();
				break;
			case 8:
				ca.setDelivered();
				menuCarrito();
				break;
			case 9:
				ca.sobreEscribir();
				menuCarrito();
				break;
			case 10:
				u.changeOrder(c.searchClient(GUI.getDni()));
				menuCarrito();
				break;
			case 11:
				menuPrincipal();
				break;

			default:menuPrincipal();
				break;
			}
	}
	
	
	public void newClient() {
		RepositoryC c=RepositoryC.getInstance();
		GUI.importarC(c);
		try {
			c.addClient(new Client(GUI.getDni(), GUI.getString("Introduce el nombre:"), GUI.getAge(), GUI.getString("Introduce direccion:")));
		} catch (Exception e) {
			Syso.print("Error al crear al cliente.");
		}
		
	}
	public void addProduct() {
		Repository carta=new Repository();
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		try {
			Syso.printOrders();
			o.getAllOrders().get(GUI.getint("Introduce el id de la orden")-1).addProduct(carta.searchProduct(GUI.getString("Introduce el nombre del producto")).getId());
		} catch (Exception e) {
			Syso.print("Error al añadir producto.");
		}

	}
	public  double cashNoPayed() {
		double result=0;
		RepositoryO o=RepositoryO.getInstance();
		for (Order item : o.getAllOrders()) {
			if (!item.isPayed()){
				result+=item.getTotal();
			}
		}
		return result;
	}
	@Override
	public void newOrder(Client c, LocalDate d) {
		NewCarrito Ca=NewCarrito.getInstanced();
		Ca.NewCarritoO();
		
		
	}

	@Override
	public Order changeOrder(Client c) {
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		NewCarrito.selectOrder(c);
		

		return null;
	}

	@Override
	public Order changeOrder(LocalDate d) {
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);

		return null;
	}

	@Override
	public Order changeOrder(Client c, LocalDate d) {
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);

		return null;
	}

	@Override
	public void deleteOrder(Client c) {
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		List<Order> item=o.getOrdersByClient(GUI.getDni());
		if (c!=null) {
			Iterator<Order> i=item.iterator(); 
			
			while (i.hasNext()) {
				if (GUI.getint("Introduce el id")==i.next().getId()) {
					i.remove();
				}
			}
		}
	}

	@Override
	public void deleteOrder(LocalDate d) {
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		List<Order> item=o.getOrdersByClient(GUI.getDni());
		if (d!=null) {
			Iterator<Order> i=item.iterator(); 
			
			while (i.hasNext()) {
				if (LocalDateTime.of(GUI.getint("Año:"), GUI.getint("mes:"), GUI.getint("dia:"), GUI.getint("Hora:"), GUI.getint("Minutos:"))==i.next().getLocalDateTime().withNano(00)) {
					i.remove();
				}
			}
		}
	}

	@Override
	public void deleteOrder(Client c, LocalDate d) {
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		List<Order> item=o.getOrdersByClient(GUI.getDni());
		if (c!=null && d!=null) {
			Iterator<Order> i=item.iterator(); 
			
			while (i.hasNext()) {
				if (GUI.getint("Introduce el id")==i.next().getId() &&LocalDateTime.of(GUI.getint("Año:"), GUI.getint("mes:"), GUI.getint("dia:"), GUI.getint("Hora:"), GUI.getint("Minutos:"))==i.next().getLocalDateTime().withNano(00)) {
					i.remove();
				}
			}
		}
	}

	@Override
	public Double cashToday() {
		double result=0;
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		for (Order item : o.getAllOrders()) {
			if (item.getLocalDateTime().isAfter(LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT))) {
				result+=item.getTotal();
			}
		}
		return result;
	}

	@Override
	public Double cashThisMonht() {
		double result=0;
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		for (Order item : o.getAllOrders()) {
			if (item.getLocalDateTime().isAfter(LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 01, LocalTime.MIDNIGHT.getHour(), LocalTime.MIDNIGHT.getMinute()))){
				result+=item.getTotal();
			}
		}
		return result;
	}

	@Override
	public Double cashTotal() {
		double result=0;
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		for (Order item : o.getAllOrders()) {
			result+=item.getTotal();
		}
		return result;
	}

	@Override
	public void viewOrdersNotPayed() {
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		Syso.printO(o.getOrdersNoPayed());
		
	}

	@Override
	public void viewOrdersPendingDelivered() {
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		Syso.printO(o.getOrdersNoDelivered());
	}

	@Override
	public void saveAllAndClose() {
		RepositoryC c=RepositoryC.getInstance();
		RepositoryO o=RepositoryO.getInstance();
		GUI.importarO(o);
		GUI.importarC(c);
		GUI.exportarC(c);
		GUI.exportarO(o);
	}
	

	
	
}
