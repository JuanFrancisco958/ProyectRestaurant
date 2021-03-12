package Products;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Vista.Syso;


/**
 * Repositorio de productos.
 * @author JF
 *
 */
@XmlRootElement(name = "Order")
@XmlAccessorType (XmlAccessType.FIELD)
public class Repository {
	@XmlElement(name = "carta")
	//Atributo.
		private List<Product> carta=new ArrayList<>();
		
		/**
		 * Creacion de la carta de productos(Bebidas y comidas).
		 */
		public Repository() {
			carta.add(new Drink(1,"Fanta", 1.2, true, false));
			carta.add(new Drink(2,"Raddler", 1.1, true, true));
			carta.add(new Drink(3,"Agua", 0.8, true, false));
			carta.add(new Food(4,"Durum", 1, false, false));
			carta.add(new Food(5, "Pizza Vegana", 4.5, true, true));
			carta.add(new Food(6,"Kebab", 1.5, true, false));
		}

		/**
		 * Obtener todos los productos.
		 * @return Lista de productos.
		 */
		  public List<Product> getAllProducts() {
			  return carta;
		  }
		  /**
		   * Obtener todas las bebidas.
		   * @return Lista de bebidas.
		   */
		  public List<Drink> getAllDrinks() {
			  List<Drink> result=new ArrayList<>();
			  for (Product item : carta) {
				  if (item instanceof Drink) {
					result.add((Drink) item);
				}
				
			}
		    return result;
		  }
		  /**
		   * Obtener todas las comidas.
		   * @return Lista de comidas.
		   */
		  public List<Food> getAllFoods() {
			  List<Food> result=new ArrayList<>();
			  for (Product item : carta) {
				  if (item instanceof Food) {
					result.add((Food) item);
				}
				
			}
		    return result;
		  }
		  /**
		   * Obtener bebidas no alcoholicas.
		   * @return Lista de bebidas.
		   */
		  public List<Drink> getAllNoAlcoholicDrinks() {
			  List<Drink> result=new ArrayList<>(); 
			  for (Drink item : getAllDrinks()) {
				  if (!item.isAlcoholic()) {
					result.add(item);
				}
				
			}
		    return result;
		  }
		  /**
		   * Obtener bebidas alcoholicas.
		   * @return Lista de bebidas.
		   */
		  public List<Drink> getAllAlcoholicsDrinks() {
			  List<Drink> result=new ArrayList<>(); 
			  for (Drink item : getAllDrinks()) {
				  if (item.isAlcoholic()) {
					result.add(item);
				  }
				
			  }
		    return result;
		  }
		  /**
		   * Obtener comidas veganas.
		   * @return Lista de comidas.
		   */
		  public List<Food> getAllForVeganFood() {
			  List<Food> result=new ArrayList<>(); 
			  for (Food item : getAllFoods()) {
				  if (item.isForVegans()) {
					result.add(item);
				  }
				
			  }
		    return result;
		  }
		  /**
		   * Obtener lista de productos con Bundle.
		   * @return Lista de productos.
		   */
		  public List<Product> getBundleProducts(Product p) {
		    List<Product> result=new ArrayList<>();
			  for (Product item : carta) {
				  if (!item.getBundlePack().isEmpty()) {
					  result.add(item);
				}
			}
			  
		    return result;
		  }
		  public List<Product> getBundleProducts() {
				  List<Product> result=new ArrayList<>();
				  for (Product product : getAllProducts()) {
					if (!product.getBundle().isEmpty()) {
						result.add(product);
					}
				}
				  
			    return result;
			  }
		  /**
		   * Obtener producto por su nombre.
		   * @param name Nombre del producto.
		   * @return Un producto.
		   */
		  public Product searchProduct(String name) {
			  Product result = null;
			  for (Product item : carta) {
				  if (item.getName().equals(name)) {
					  result=item;
				  }
				
			  }
			  if (result==null) {
				Syso.print("No se encuentra el producto");
			}
		    return result;
		  }
		  /**
		   * Obtener producto por id.
		   * @param id Identificador del producto.
		   * @return Producto.
		   */
		  public Product searchProduct(Integer id) {
			  Product result = null;
			  for (Product item : carta) {
				  if (item.getId()==id) {
					  result=item;
				  }
				
			  }
			  if (result==null) {
				Syso.print("No se encuentra el producto");
			}
		    return result;
		  }
		  /**
		   * Obtención de bebida por nombre.
		   * @param name Nombre de la benida.
		   * @return Una bebida.
		   */
		  public Drink searchDrinks(String name) {
		    Drink result=(Drink)searchProduct(name);
		    return result;
		  }
		  /**
		   * Obtención de comida por nombre.
		   * @param name Nombre de la comida.
		   * @return Una comida.
		   */
		  public Food searchFood(String name) {
		    Food result=(Food)searchProduct(name);
		    return result;
		  }
		  /**
		   * Obtener tamaño de la carta.
		   * @return Entero del tamaño de la carta.
		   */
		  public int getSize() {
			  int result=carta.size();
			  return result;
		  }

		//Método para imprimir la carta.
		@Override
		public String toString() {
			return "Repository [carta=" + carta + "]";
		}
	
		  
		
	
	
}
