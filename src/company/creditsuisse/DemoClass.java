package company.creditsuisse;

import java.io.*;
import java.util.logging.Logger;
///What is the purpose of serialVersionUID
public class DemoClass implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5256470541573745906L;

	public DemoClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemoClass(String name, StringBuffer value, int intVariable, String transientVariable) {
		super();
		this.name = name;
		this.value = value;
		this.intVariable = intVariable;
		this.transientVariable = transientVariable;
	}

	/**
	 * 
	 */
	//private static final long serialVersionUID = 3559618371255808517L;
	///private static final long serialVersionUID = 4L; // Default serial version uid
	private static final String fileName = "DemoClassBytes.ser"; // Any random name
	private static final Logger logger = Logger.getLogger("");
	// Few data fields
	// Able to serialize
	private static String staticVariable;
	private String name;
	private StringBuffer value;
	private int intVariable;

	// Not able to serialize
	transient private String transientVariable = "this is a transient instance field";
	private Thread threadClass;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Serialization

		DemoClass test = new DemoClass();
		test.intVariable = 1;
		
		staticVariable = "this is a static variable";
		writeOut(test);
		
		DemoClass test1 = new DemoClass("name", new StringBuffer("nitinsds"), 23, "this is test");
		test1.intVariable = 11;
		staticVariable = "this is a11111static variable";
		///writeOut(test1);
		System.out.println("DemoClass to be saved: " + test);

		// De-serialization

		System.out.println("DemoClass deserialized: " + readIn());
	}

	private static Object readIn() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
		return ois.readObject();
	}

	private static void writeOut(java.io.Serializable obj) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
		oos.writeObject(obj);
		oos.close();
	}

	@Override
	public String toString() {
		return "DemoClass: final static fileName=" + fileName + ", final static logger=" + logger
				+ ", non-final static staticVariable=" + staticVariable + ", instance intVariable=" + intVariable
				+ ", transient instance transientVariable=" + transientVariable
				+ ", non-serializable instance field threadClass:=" + threadClass;
	}
}
