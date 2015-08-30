package com.eintern.model;

import javax.persistence.*;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(generator="seq_carid",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_carid",sequenceName="seq_carid")
	private int carId;
	
	@Column
	private String make;
	private String model;
	private int year;
	private int miles;
	private double cost;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMiles() {
		return miles;
	}
	public void setMiles(int miles) {
		this.miles = miles;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}
