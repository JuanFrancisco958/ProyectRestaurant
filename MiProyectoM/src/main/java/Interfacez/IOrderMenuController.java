package Interfacez;
/**
 * Interfaz del controlador de edicion de una orden, implementado en el Chart
 * @author JF
 * 
 */
public interface IOrderMenuController {
	//Añadir un producto a una orden
	void addProduct();
	//Editar elemento
	void editLine();
	//Borrar linea
	void removeLine();
	//Añadir direccion a una orden
	void setAddress(String a);
	//Guardar como pagado
	void savePaid();
	//Guardar como no pagado
	void saveNoPaid();

}
