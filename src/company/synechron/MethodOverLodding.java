package company.synechron;

import java.util.HashMap;

import company.Employee;
import company.Trade;

class Animal {

	public void sound() {
		System.out.println("Animal is making a sound");
	}
}

class Horse extends Animal {

	@Override
	public void sound() {
		System.out.println("Neigh");
	}
}

class Cat extends Animal {

	@Override
	public void sound() {
		System.out.println("Meow");
	}
}

public class MethodOverLodding {

	/*
	  public void display(int a) { System.out.println(a); }
	 */

	public String display(String a) {
		System.out.println(a);
		return a;
	}

	public Object display(Object a) {
		System.out.println(a.toString());
		return a;
	}

	public Employee display(Employee a) {
		System.out.println(a.toString());
		return a;
	}

	public int display(int a) {
		System.out.println(a);
		return a;
	}

	public Integer display(Integer a) {
		System.out.println(a);
		return a;
	}

	
	  public long display(long a) { System.out.println(a); return a; }
	  
	  public float display(float a) { System.out.println(a); return a; }
	 

	/// Duplicate method display(int) in type MethodOverLodding
	
	  ////public int display(int a) { // System.out.println(a); return a; }
	 

	
	  public Float display(Float a) { System.out.println(a.toString()); return a; }
	  
	  public Double display(Double a) { System.out.println(a.toString()); return a;
	  }
	  
	  public double display(double a) { //// System.out.println(a.toString());
	  return a; }
	  
	  public Number display(Number a) { System.out.println(a.toString()); return a;
	  }
	 

	void sum(int a, int b) {
		System.out.println(a + b);
	}

	void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	void sum(double a, double b) {
		System.out.println(a + b);
	}

	void sum(int a, long b) {
		System.out.println(a + b);
	}

	void sum(long a, long b) {
		System.out.println("long arg method invoked");
	}

	public static void main(String[] args) {
		MethodOverLodding methodOverLodding = new MethodOverLodding();
		Employee emp = new Employee(10, "Nitin");
		String empstr = "Nitin";
		methodOverLodding.display(10);
		methodOverLodding.display(10L);
		methodOverLodding.display(10.98D);
		methodOverLodding.display(10.55656);
		methodOverLodding.display(empstr);
		methodOverLodding.display(new Trade());
		methodOverLodding.display(emp);
		methodOverLodding.display(new HashMap<Integer, Integer>());
		methodOverLodding.display(new Trade());
		// int result=methodOverLodding.sum(30,20); //Compile Time Error
		methodOverLodding.sum(20, 20);// now int arg sum() method gets invoked
		methodOverLodding.sum(20, 20L);
		// now second int literal will be promoted to long
		methodOverLodding.sum(20, 20, 20);
		methodOverLodding.sum(20L, 20);// now ambiguity
	}

}
