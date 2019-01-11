package company.nishamTechnology;


class Employee {
	int id;
	String name;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

public class SwapTest {
	static int a = 20;
	static int b = 10;

	public static void main(String[] args) {
		SwapTest SwapTest = new SwapTest();
		SwapTest.swap(a, b);
		System.out.println(a + "  " + b);

		SwapTest.swap((Integer) a, (Integer) b);
		System.out.println(a + "  " + b);
		Employee e1 = new Employee(10, "Nitin");
		Employee e2 = new Employee(20, "Sachin");
		SwapTest.swap(e1, e2);
		System.out.println(e1.toString() + "  " + e2.toString());
	}

	public void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public void swap(Integer a, Integer b) {
		int temp = a;
		a = b;
		b = temp;
	}

	/*
	 * public void swap(Employee a, Employee b) { Employee temp = a; a = b; b =
	 * temp; }
	 */

	public void swap(Employee a, Employee b) {
		Employee temp = a;
		a.setId(b.getId());
		a.setName(b.getName());
		b.setId(temp.getId());
		b.setName(temp.getName());
	}
}
