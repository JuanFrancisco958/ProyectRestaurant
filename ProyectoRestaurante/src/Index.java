import Clases.Repository;

public class Index {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		Repository carta=new Repository();
		carta.getAllProducts();//.forEach(p->System.out.println(p));
		System.out.println("");
		System.out.println(""+carta.searchDrinks("Fanta"));

		//carta.getAllAlcoholicsDrinks().forEach(p->System.out.println(p));

			
	}

	

}
