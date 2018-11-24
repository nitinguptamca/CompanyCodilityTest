package CtCI6thEdition1.Ch07ObjectOrientedDesign.Q7_04_Parking_Lot1;

public class Bus extends Vehicle {
	public Bus() {
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large;
	}
	
	public void print() {
		System.out.print("B");
	}
}
