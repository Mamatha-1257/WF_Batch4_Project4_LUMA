package com.wf.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items_master")
public class Item {
	
	@Id
	private int item_id = 1;
	
	@Column
	private String item_category;
	
	@Column
	private String item_description;
	
	@Column
	private double item_valuation;
	
	@Column
	private String item_make;
	
	@Column
	private String item_status;
	
	public Item() {
		
	}

	public Item(String item_category, String item_description, double item_valuation, String item_make) {
		super();
		this.item_id = 1;
		this.item_category = item_category;
		this.item_description = item_description;
		this.item_valuation = item_valuation;
		this.item_make = item_make;
		this.item_status = "S";
	}

	public String getItem_status() {
		return item_status;
	}

	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public double getItem_valuation() {
		return item_valuation;
	}

	public void setItem_valuation(double item_valuation) {
		this.item_valuation = item_valuation;
	}

	public String getItem_make() {
		return item_make;
	}

	public void setItem_make(String item_make) {
		this.item_make = item_make;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_category=" + item_category + ", item_description="
				+ item_description + ", item_valuation=" + item_valuation + ", item_make=" + item_make
				+ ", item_status=" + item_status + "]";
	}

	
	
}

