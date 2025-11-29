package org.entity;

public class POJO_addproperty {
	private int propertyId;
    private String address;
    private double rentAmount;
    private String status;


    public POJO_addproperty(int propertyId, String address, double rentAmount, String status) {
        this.propertyId = propertyId;
        this.address = address;
        this.rentAmount = rentAmount;
        this.status = status;
    }

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
