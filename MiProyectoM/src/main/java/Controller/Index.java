package Controller;
import java.time.LocalDateTime;
import java.util.Scanner;

import Clients.Client;
import Clients.RepositoryC;
import Orders.Order;
import Orders.RepositoryO;
import Products.Drink;
import Products.Repository;
import Utils.RepositoryUtil;
import Vista.Syso;

public class Index {

	public static void main(String[] args) throws ClassNotFoundException  {
		Repository carta=new Repository();
		RepositoryC clientes=RepositoryC.getInstance();
		RepositoryO comandas=RepositoryO.getInstance();
		importarC(clientes);
		importarO(comandas);
		
		//clientes.addClient(new Client("1122334455p", "pepe", 22, "C/bonifacio"));
		//comandas.addOrder(new Order(1,clientes.searchClient("1122334455p"), 4, "C/Bonifacio", false, true));
		comandas.addOrder(new Order(clientes.searchClient("1122334455p"), 1, 1, "C/Bonifacio", false, true));
				
				
		clientes.getAllClients().forEach(item->System.out.println(item));
		comandas.getAllOrders().forEach(item->System.out.println(item));
		
		//Guardar e importar comanda
		//RepositoryUtil.saveFileO(comandas.getInstance());
		//comandas.setcomandas(RepositoryUtil.loadFileO());
		//Guardar e importar clientes
		//RepositoryUtil.saveFile(clientes.getInstance());
		//clientes.setClientes(RepositoryUtil.loadFile());
		
	}
	
	public static int getInt() {
		int result=-1;
		Scanner teclado=new Scanner(System.in);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public static void Menu(RepositoryC c, RepositoryO o) {
		Syso.menuP();
		
		switch (getInt()) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		case 8:
			
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		case 11:
			
			break;
		case 12:
			
			break;
		

		default:
			break;
		}
	}
	public static void añadirOrden() {
		
	}
	
	
	public static void exportarC(RepositoryC c) {
		RepositoryUtil.saveFile(c.getInstance());
	}
	public static void exportarO(RepositoryO o) {
		RepositoryUtil.saveFileO(o.getInstance());
	}
	public static void importarC(RepositoryC c) {
		c.setClientes(RepositoryUtil.loadFile());
	}
	public static void importarO(RepositoryO o) {
		o.setcomandas(RepositoryUtil.loadFileO());
	}
	
}
