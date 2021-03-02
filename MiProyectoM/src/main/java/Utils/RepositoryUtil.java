package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Clients.Client;
import Clients.RepositoryC;
import Orders.Order;
import Orders.RepositoryO;
import Products.Repository;
/**
 * Repositorio sobre metodos de importación y exportación de datos en archivo xml.
 * @author JF
 *
 */
public class RepositoryUtil{
	/**
	 * Método de guardado de clientes en .xml .
	 * @param r datos a guardar.
	 */
	public static void saveFile(RepositoryC r) {
		//marshaling
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RepositoryC.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    //Marshal the list in console
		    //jaxbMarshaller.marshal(_instance, System.out);
		     
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(r, new File("clients.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * Método para importar clientes.
	 * @return devuelve una lista de clientes.
	 */
	public static List<Client> loadFile() {
		List<Client> result=new ArrayList<Client>();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RepositoryC.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    //We had written this file in marshalling example
		    RepositoryC newR = (RepositoryC) jaxbUnmarshaller.unmarshal( new File("clients.xml") );
		    result=newR.getAllClients();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Método de guardado de ordenes en .xml .
	 * @param r datos a guardar.
	 */
	public static void saveFileO(RepositoryO r) {
		//marshaling
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RepositoryO.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    //Marshal the list in console
		    //jaxbMarshaller.marshal(_instance, System.out);
		     
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(r, new File("orders.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * Método para importar ordenes.
	 * @return devuelve una lista de ordenes.
	 */
	public static List<Order> loadFileO() {
		List<Order> result=new ArrayList<Order>();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RepositoryO.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    //We had written this file in marshalling example
		    RepositoryO newR = (RepositoryO) jaxbUnmarshaller.unmarshal( new File("orders.xml"));
		    result=(List<Order>)newR.getAllOrders();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
