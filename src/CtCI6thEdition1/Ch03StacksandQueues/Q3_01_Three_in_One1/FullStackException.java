package CtCI6thEdition1.Ch03StacksandQueues.Q3_01_Three_in_One1;

public class FullStackException extends Exception {
	private static final long serialVersionUID = 1L;

	public FullStackException(){
        super();
    }

    public FullStackException(String message){
        super(message);
    }
}
