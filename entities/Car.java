package entities;

import java.util.Date;

import enums.CarColor;
import enums.Transmission;

public class Car {

	private String brandName;
	private String model;
	private Date dateOfRelease;
	private int mileage;
	private Transmission transmission;
	private int power;
	private String fuel;
	private CarColor color;
	private String status;
	private double price;


	public Car(CarBuilder builder) {

		this.brandName = builder.getBrandName();
		this.model = builder.getModel();
		this.dateOfRelease = builder.getDateOfRelease();
		this.mileage = builder.getMileage();
		this.transmission = builder.getTransmission();
		this.power = builder.getPower();
		this.fuel = builder.getFuel();
		this.color = builder.getColor();
		this.status = builder.getStatus();
		this.price = builder.getPrice();

	}


	public String getBrandName() {
		return this.brandName;
	}


	public String getModel() {
		return this.model;
	}


	public Date getDateOfRelease() {
		return this.dateOfRelease;
	}


	public int getMileage() {
		return this.mileage;
	}


	public Transmission getTransmission() {
		return this.transmission;
	}


	public int getPower() {
		return this.power;
	}


	public String getFuel() {
		return this.fuel;
	}


	public CarColor getColor() {
		return this.color;
	}


	public String getStatus() {
		return this.status;
	}


	public double getPrice() {
		return this.price;
	}


}
