package com.eintern.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CALCULATIONTABLE")
public class Calculation {
	
	@Id
	@GeneratedValue(generator="seq_calcid", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_calcid",sequenceName="seq_shipid")
	private int calcId;
	
	@Column
	private String operation;
	private double firstVal;
	private double secondVal;
	private double resultVal;
	
	public int getCalcId() {
		return calcId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getFirstVal() {
		return firstVal;
	}
	public void setFirstVal(double firstVal) {
		this.firstVal = firstVal;
	}
	public double getSecondVal() {
		return secondVal;
	}
	public void setSecondVal(double secondVal) {
		this.secondVal = secondVal;
	}
	public double getResultVal() {
		return resultVal;
	}
	public void setResultVal(double resultVal) {
		this.resultVal = resultVal;
	}

	
	
	

}
