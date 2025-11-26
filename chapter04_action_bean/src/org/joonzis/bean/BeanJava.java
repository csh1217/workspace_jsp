package org.joonzis.bean;

public class BeanJava{
	private String val1;
	private String val2;
	
	public BeanJava(){}
	public BeanJava(String val1, String val2){ // 생성자
			this.val1 = val1;
			this.val2 = val2;
	}
	// getter & setter
	public String getVal1() {return val1;}
	public void setVal1(String val1) {this.val1 = val1;}
	public String getVal2() {return val2;}
	public void setVal2(String val2){this.val2 = val2;}
	
}
