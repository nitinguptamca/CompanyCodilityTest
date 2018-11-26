package company.Intellact;

class GenericsType2131<T> {
	private T t;

	public T get() {
		return this.t;
	}

	public void set(T t1) {
		this.t = t1;
	}

}

public class GenericValueCheck {
	public static void main(String[] args) {
		GenericsType2131<String> type23 = new GenericsType2131<>();
		type23.set("Pankaj"); // valid
		GenericsType2131<?> type3 = new GenericsType2131<Object>();
		type3=type23;
		
		GenericsType2131 type1 = new GenericsType2131(); // raw type
		type1.set("Pankaj"); // valid
		type1.set(10); // valid and autoboxing support
	}

}
