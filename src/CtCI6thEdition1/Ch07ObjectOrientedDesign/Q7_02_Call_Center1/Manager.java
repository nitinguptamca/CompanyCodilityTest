package CtCI6thEdition1.Ch07ObjectOrientedDesign.Q7_02_Call_Center1;

class Manager extends Employee {
    public Manager(CallHandler callHandler) {
    	super(callHandler);
    	rank = Rank.Manager;
    }
}
