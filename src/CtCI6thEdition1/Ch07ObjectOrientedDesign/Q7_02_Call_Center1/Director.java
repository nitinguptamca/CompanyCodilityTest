package CtCI6thEdition1.Ch07ObjectOrientedDesign.Q7_02_Call_Center1;

class Director extends Employee {
    public Director(CallHandler callHandler) {
    	super(callHandler);
    	rank = Rank.Director;
    }
}
