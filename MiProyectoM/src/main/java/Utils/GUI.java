package Utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Vista.Syso;

public class GUI {
	/**
	 * Obtener un entero introducido por teclado
	 * @param frase Texto con la informacion deseada.
	 * @return devuelve un entero introducido por teclado
	 */
	public static int  getint(String frase) {
		@SuppressWarnings("resource")
		Scanner teclado=new Scanner(System.in);
		int result=-1;
		
		try {
			Syso.print(frase);
			result=teclado.nextInt();
		} catch (Exception e) {
			Syso.print("Error al obtener entero.");
		}
		return result;
	}
	/**
	 * Obtener edad entre 15-110 años
	 * @return devuelve un entero.
	 */
	public static int  getAge() {
		@SuppressWarnings("resource")
		Scanner teclado=new Scanner(System.in);
		int result=-1;
		
		do {
			try {
				Syso.print("Introduce la edad:");
				result=teclado.nextInt();
			} catch (Exception e) {
				Syso.print("Error al obtener entero.");
			}
		} while (result<=15 && result>=110);
		
		return result;
	}

	/***
	 * Obtener una cadena de caracteres.
	 * @param frase Texto con la informacion deseada.
	 * @return devuelve un string introducido por teclado
	 */
	public static String  getString(String frase) {
		@SuppressWarnings("resource")
		Scanner teclado=new Scanner(System.in);
		String result=null;
		
		if (result==null) {
			try {
				Syso.print(frase);
				result=teclado.nextLine();
			} catch (Exception e) {
				Syso.print("Error al obtener string.");
			}
		}
		
		return result;
	}
	public static String getAddress() {
		String result=null;
		@SuppressWarnings("resource")
		Scanner teclado=new Scanner(System.in);

		if (result==null) {
			try {
				Syso.print("Introduce la direcccion");
				result=teclado.nextLine();
				while (!validaAddress(result)) {
					Syso.print("Vueleve a introducir una direccion valida(C/********):");
					result=teclado.nextLine();
					
				}
				
			} catch (Exception e) {
				Syso.print("Error al obtener string.");
			}
		}
			
		return result;
	}
	public static String getDni() {
		 String result = null;
	        @SuppressWarnings("resource")
			Scanner miScanner = new Scanner(System.in);
	        Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
	        Syso.print("Introduce un DNI correcto: ");
	        result = miScanner.nextLine();
	        Matcher mat = patron.matcher(result);
	       
				while((!mat.matches() || !validaDNI(result))&&result.length()==9){
					Syso.print("El DNI introducido es incorrecto, por favor introduzca un DNI válido, con la letra en mayuscula.");
			           Syso.print("Introduce un DNI correcto: ");
			           result = miScanner.nextLine();
			           mat = patron.matcher(result);
			     }
			
	        
	        return result;
	}
	
	private static boolean validaAddress(String address) {
		boolean result=false;
		if(address!=null) {
			char l1='C';
			char l2='/';
			char letra=address.charAt(0);
			char letra2=address.charAt(1);
			if(letra==l1||letra2==l2) {
				result=true;
			}
		}
		return result;
	}
	
	private static boolean validaDNI(String dni){
		boolean result=false;
		if(dni.length()==9) {
			char letra=dni.charAt(8);
			String n=dni.substring(0, 8);
			Integer num=Integer.parseInt(n);
			if(calcularLetraArray(num)==letra) {
				result=true;
			}
		}
		return result;
	}
	private static char calcularLetraArray(int dni){
        char caracteres[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int resto = dni%23;
        return caracteres[resto];
   }
    
	/**
	 * 
	 * @param frase Texto con la informacion deseada.
	 * @return devuelve un boleano a decisión del usuario.
	 */
	public static Boolean  getBoolean(String frase) {
		@SuppressWarnings("resource")
		Scanner teclado=new Scanner(System.in);
		Boolean result=null;
		
		if (result==null) {
			try {
				Syso.print(frase);
				Syso.print("0=true 1=false");

				if (teclado.nextInt()==1) {
					result=true;
				}else {
					result=false;
				}
			} catch (Exception e) {
				Syso.print("Error al obtener booleano.");
			}
		}
		
		return result;
	} 


}
