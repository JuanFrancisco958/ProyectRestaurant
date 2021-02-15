package Interfacez;

public interface IOrderMenuController {

	public void addProduct(IProduct p);
	public void editLine();
	public void removeLine(int id);
	public void setAdress();
	public void savePaid();
	public void saveNotPaid();
}
