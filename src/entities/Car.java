package entities;

import java.time.LocalDate;

import enums.CarColor;
import enums.Transmission;

/**
 * This class creates an object "car" by using the carbuilder.
 *
 * @author Mohammed Al-Ashtal, Daniel Weiser
 *
 */

public class Car {

	private int carId;
	private String brandName;
	private String model;
	private LocalDate dateOfRelease;
	private int mileage;
	private Transmission transmission;
	private int power;
	private String fuel;
	private CarColor color;
	private String status;
	private double price;


	public Car(CarBuilder builder) {

		this.carId = builder.getCarId();
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


	public LocalDate getDateOfRelease() {
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


	public int getCarId() {
		return this.carId;
	}

}
