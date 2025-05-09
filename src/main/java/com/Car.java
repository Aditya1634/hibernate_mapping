package com;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Car {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO) // Ids not coming in sequence
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "car_id")
	@SequenceGenerator(name="car_id",initialValue=100,allocationSize=1)
	private int id;
	private String Brand;
	private String Model;
	private LocalDate registerDate;
	@OneToOne
	Engine e;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public Engine getEngine() {
		return e;
	}
	public void setEngine(Engine e) {
		this.e = e;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
}