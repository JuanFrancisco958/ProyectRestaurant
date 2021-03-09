package Clients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Utils.RepositoryUtil;
import Vista.Syso;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Orders.Order;

@XmlRootElement (name = "Client")
@XmlAccessorType (XmlAccessType.FIELD)
public class RepositoryC implements Serializable{
	private static RepositoryC _instance;
	private static RepositoryUtil u=new RepositoryUtil();
	@XmlElement(name = "cliente")
	private static List<Client> clientes=new ArrayList<>();

	
	public RepositoryC(){}
	
	public static RepositoryC getInstance(){
        if(_instance==null){
            _instance = new RepositoryC();
        }
        return _instance;
    }
	
	public void setClientes(List<Client> c) {
		clientes=c;
	}
	public List<Client> getAllClients(){
		return clientes;
	}
	
	public List<Client> searchClientByName(String name) {
		List<Client> result=new ArrayList<>();
			if (name!=null) {
				for (Client c : clientes) {
					if (c.getName().equals(name)) {
						result.add(c);
					}
				}
			}
		return result;
	}
	
	public boolean updateClient(Client c){
		boolean result=false;
			if (c!=null) {
				try {
					for (Client cl : clientes) {
						if (c.getDni().equals(cl.getDni())) {
							clientes.set(clientes.indexOf(cl), c);
							result=true;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		return result;
	}
	
	public boolean addClient(Client c){
		boolean result=false;
		if (c!=null && !clientes.contains(c)) {
			clientes.add(c);
			
		}
		return result;
	}
	
	public boolean deleteClient(String dni){
		boolean result=false;
			if (dni!=null) {
				try {
					for (Client c : clientes) {
						if (c.getDni().equals(dni)) {
							clientes.remove(clientes.indexOf(c));
							result=true;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		return result;
	}
	
	public Client searchClient(String dni){
		Client result=null;
			if (dni!=null) {
				for (Client c : clientes) {
					if (c.getDni().equals(dni)) {
						result=c;
					}
				}
			}
			if (result==null) {
				Syso.print("No se encuentra al cliente.");
			}
		return result;
	}
	
	
	

}