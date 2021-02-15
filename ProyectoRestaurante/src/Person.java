package Clases;

public class Person {
	private String dni;
	private String name;
	private int age;
	
	
	public Person(String dni, String name, int age) {
		this.dni=dni;
		this.name=name;
		this.age=age;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [dni=" + dni + ", name=" + name + ", age=" + age + "]";
	}
	

}