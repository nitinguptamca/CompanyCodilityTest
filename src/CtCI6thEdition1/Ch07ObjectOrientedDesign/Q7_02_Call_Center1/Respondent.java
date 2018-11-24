package CtCI6thEdition1.Ch07ObjectOrientedDesign.Q7_02_Call_Center1;

class Respondent extends Employee {
    public Respondent(CallHandler callHandler) {
    	super(callHandler);
    	rank = Rank.Responder;
    }
}
