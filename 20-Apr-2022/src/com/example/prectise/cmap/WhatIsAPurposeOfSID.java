package com.example.prectise.cmap;

import java.io.*;
import java.util.logging.Logger;
public class WhatIsAPurposeOfSID implements java.io.Serializable {
    private static final long serialVersionUID = 5256470541573745906L;

    private static final String fileName = "DemoClassBytes.ser"; // Any random name
    private static final Logger logger = Logger.getLogger("");
    // Few data fields
    // Able to serialize
    private static String staticVariable;
    private String name;
    private StringBuffer value;
    private int intVariable;
    transient private String transientVariable = "this is a transient instance field";

    public WhatIsAPurposeOfSID() {
        super();
    }

    public WhatIsAPurposeOfSID(String name, StringBuffer value, int intVariable, String transientVariable) {
        super();
        this.name = name;
        this.value = value;
        this.intVariable = intVariable;
        this.transientVariable = transientVariable;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Serialization

        WhatIsAPurposeOfSID test = new WhatIsAPurposeOfSID();
        test.intVariable = 1;

        staticVariable = "this is a static variable";
        writeOut(test);

        WhatIsAPurposeOfSID test1 = new WhatIsAPurposeOfSID("name", new StringBuffer("nitinsds"), 23, "this is test");
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
                + ", transient instance transientVariable=" + transientVariable;
    }

}
