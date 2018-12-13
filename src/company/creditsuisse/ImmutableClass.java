package company.creditsuisse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

///https://codepumpkin.com/immutable-class-with-mutable-member-fields-in-java/
////https://www.javadevjournal.com/java/java-deep-copy/
//suppose this is Third party code.
class Address {
	String Addline1;
	String AddLine2;
	String city;
	StringBuffer State;
	int flatNo;

	public Address(String addline1, String addLine2, String city, StringBuffer state, int flatNo) {
		super();
		Addline1 = addline1;
		AddLine2 = addLine2;
		this.city = city;
		State = state;
		this.flatNo = flatNo;
	}

	public Address() {
	}

	public String getAddline1() {
		return Addline1;
	}

	public void setAddline1(String addline1) {
		Addline1 = addline1;
	}

	public String getAddLine2() {
		return AddLine2;
	}

	public void setAddLine2(String addLine2) {
		AddLine2 = addLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public StringBuffer getState() {
		return State;
	}

	public void setState(StringBuffer state) {
		State = state;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	};

}

class Child extends Address {
	String firstName;
	String LastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Child(String addline1, String addLine2, String city, StringBuffer state, int flatNo, String firstName,
			String lastName) {
		super(addline1, addLine2, city, state, flatNo);
		this.firstName = firstName;
		LastName = lastName;
	}

	public Child(String firstName, String LastName) {
		super();
		this.firstName = firstName;
		this.LastName = LastName;
	}

}

class Order implements Serializable {

	private String orderNumber;
	private double orderAmount;
	private String orderStatus;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order(String orderNumber, double orderAmount, String orderStatus) {
		super();
		this.orderNumber = orderNumber;
		this.orderAmount = orderAmount;
		this.orderStatus = orderStatus;
	}

	public Order(Order order) {
		this(order.getOrderNumber(), order.getOrderAmount(), order.getOrderStatus());
	}

	@Override
	public Order clone() {
		try {
			return (Order) super.clone();
		} catch (CloneNotSupportedException e) {
			return new Order(this.orderNumber, this.orderAmount, this.orderStatus);
		}
	}

}

class Customer implements Serializable {

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Customer(String firstName, String lastName, Order order) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.order = order;
	}

	public Customer(Customer customer) {
		this(customer.getFirstName(), customer.getFirstName(), new Order(customer.getOrder()));
	}

	private Order order;

	// Customer
	@Override
	public Customer clone() {
		Customer customer = null;
		try {
			customer = (Customer) super.clone();
		} catch (CloneNotSupportedException e) {
			customer = new Customer(this.firstName, this.lastName, this.order);
		}
		customer.order = this.order.clone();
		return customer;
	}
}

public class ImmutableClass<T> {
	public static void main(String[] args) {
		// First Approach copy Constructor

		Order order = new Order("12345", 100.45, "In Progress");
		Customer customer = new Customer("Test", "CUstomer", order);
		Customer customerCopy = new Customer(customer);

		order.setOrderStatus("Shipped");
		assertNotEquals(customer.getOrder().getOrderStatus(), customerCopy.getOrder().getOrderStatus());

	}

	public T deepClone(T object) {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(object);
			ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(bais);
			return (T) objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
