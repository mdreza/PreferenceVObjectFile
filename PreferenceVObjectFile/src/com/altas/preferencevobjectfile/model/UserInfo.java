package com.altas.preferencevobjectfile.model;

import java.io.Serializable;

/**
 * @author Altas
 * @email Altas.TuTu@gmail.com
 * @date 2014年9月27日
 */
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8558071977129572083L;
	public int id;
	public String token;
	public String userName;
	public String headImg;
	public String phoneNum;
	public double balance;
	public int integral;
	public UserInfo(){}
	public UserInfo(int i,String t,String un,String hi,String pn,double b,int point){
		id=i;
		token=t;
		userName = un;
		headImg = hi;
		phoneNum = pn;
		balance = b;
		integral = point;
	}
}
