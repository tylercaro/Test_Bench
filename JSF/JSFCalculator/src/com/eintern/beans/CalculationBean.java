package com.eintern.beans;

import com.eintern.dao.CalcDao;
import com.eintern.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped 
public class CalculationBean {
	@ManagedProperty(value="#{calcDao}")
	private CalcDao calcdao;
	
	private Calculation calc = new Calculation();
	private List<Calculation> calcList= new ArrayList<Calculation>();

	public List<Calculation> getCalcList() {
		setCalcList();
		return calcList;
	}

	public void setCalcList() {
		List <Calculation> temp = calcdao.getAllCalculations();
		this.calcList = temp;
	}

	public Calculation getCalc() {
		return calc;
	}

	public void setCalc(Calculation calc) {
		this.calc = calc;
	}

	public CalcDao getCalcdao() {
		return calcdao;
	}

	public void setCalcdao(CalcDao calcdao) {
		this.calcdao = calcdao;
	}

	public String addition(){
		String nextPage="";
		calc.setOperation("ADD");
		calc.setResultVal(calc.getFirstVal()+calc.getSecondVal());
		calcdao.saveObject(calc);
		return nextPage;
	}
	
	public String subtraction(){
		String nextPage="";
		calc.setOperation("SUB");
		calc.setResultVal(calc.getFirstVal()-calc.getSecondVal());
		calcdao.saveObject(calc);
		return nextPage;
	}
	
	public String multiplication(){
		String nextPage="";
		calc.setOperation("MUL");
		calc.setResultVal(calc.getFirstVal()*calc.getSecondVal());
		calcdao.saveObject(calc);
		return nextPage;
	}
	
	public String division(){
		String nextPage="";
		if(calc.getSecondVal()==0){
			FacesContext.getCurrentInstance().
			addMessage(null, new FacesMessage("cannot divide by zero!!"));
		}else{
			calc.setOperation("DIV");
			calc.setResultVal(calc.getFirstVal()/calc.getSecondVal());
			calcdao.saveObject(calc);
		}
		return nextPage;
	}
	
/*	public List<Calculation> calculations(){
		setCalcList(calcdao.getAllCalculations());
		return calcList;
	}*/
	

}
