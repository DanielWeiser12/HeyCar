package entities;

import java.time.LocalDate;

import enums.CarColor;
import enums.Transmission;

public class CarBuilder {

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

	public CarBuilder() {

	}

	public CarBuilder withBrandName(String brandName) {
		this.brandName = brandName;
		return this;
	}

	public CarBuilder withModel(String model) {
		this.model = model;
		return this;
	}

	public CarBuilder withDateOfRelease(LocalDate dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
		return this;
	}

	public CarBuilder withMileage(int mileage) {
		this.mileage = mileage;
		return this;
	}



	public CarBuilder withTransmission(Transmission transmission) {
		this.transmission = transmission;
		return this;
	}



	public CarBuilder withPower(int power) {
		this.power = power;
		return this;
	}



	public CarBuilder withFuel(String fuel) {
		this.fuel = fuel;
		return this;
	}


	public CarBuilder withColor(CarColor color) {
		this.color = color;
		return this;
	}


	public CarBuilder withStatus(String status) {
		 this.status = status;
		 return this;
	}


	public CarBuilder withPrice(double price) {
		this.price = price;
		return this;
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

	public Car create() {
		return new Car(this);
	}

}
