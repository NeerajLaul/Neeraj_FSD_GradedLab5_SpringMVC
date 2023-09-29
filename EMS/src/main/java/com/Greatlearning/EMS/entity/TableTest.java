package com.Greatlearning.EMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Table1")
public class TableTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public int rno;
	
	public String sname;
	
	public double per;
	
	
	public TableTest(int rno1, String sname1, double per1) {
		super();
		this.rno = rno1;
		this.sname = sname1;
		this.per = per1;
	}
}
