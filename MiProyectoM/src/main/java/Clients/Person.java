package Clients;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name = "Perso")
@XmlAccessorType (XmlAccessType.FIELD)
public class Person implements Serializable{
	protected String dni;
	protected String name;
	protected int age;
	protected Person() {}
	
	

	public Person(String dni, String name, int age) {
		this.dni = dni;
		this.name = name;
		this.age = age;
	}
	
	//Metodos Getters y Setters de los atributos
	public String getDni() {
		return dni;
	}
	@SuppressWarnings("unused")
	private void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		try {
			this.name = name;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		try {
			this.age = age;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [dni=" + dni + ", name=" + name + ", age=" + age ;
	}
	
	
}
