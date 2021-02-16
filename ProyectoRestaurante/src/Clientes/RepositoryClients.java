package Clientes;

import java.io.Serializable;
import java.util.ArrayList;

public class RepositoryClients implements Serializable{
	ArrayList<Client> clients=new ArrayList<>();
	
	public RepositoryClients() {
		clients.add(new Client("50627461E", "Raul", 25));
		clients.add(new Client("15451593D", "Jesus", 24));
		clients.add(new Client("12345678Z", "Angel", 24));
		
	}
	
	public void getAllClients() {
		clients.forEach(p->System.out.println(p));
		
	}
	public Client searchClient(String name) {
		for (Client client : clients) {
			if (client.getName().equals(name)) {
				return client;
			}	
		}
		return null;
		
	}
	//se puede poner Boolean para que diga si se ha hecho bien la operacion
	public void updateClient(Client c, String dni) {
		for (Client client : clients) {
			if (client.getDni().equals(dni)) {
				client=c;
			}
		}
	}
	public void addClient(Client c) {
		clients.add(c);
		
	}
	//se puede poner Boolean para que diga si se ha hecho bien la operacion
	public void deleteClient(String dni) {
		for (Client client : clients) {
			if (client.getDni().equals(dni)){
				clients.remove(client);
			}
		}
	}
	public Client searchClientDni(String dni) {
		for (Client client : clients) {
			if (client.getDni().equals(dni)) {
				return client;
			}
		}
		return null;
	}
}

