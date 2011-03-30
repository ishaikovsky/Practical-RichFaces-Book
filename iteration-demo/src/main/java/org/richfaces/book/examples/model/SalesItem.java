package org.richfaces.book.examples.model;

import java.util.ArrayList;

import javax.faces.model.SelectItem;

public class SalesItem {
	private int productCode;
	private double proposedPrice;
	private double salesCost;
	private String reason;
	private double discount = 0;

	public ArrayList<SelectItem> getReasons() {
		ArrayList<SelectItem> reasons = new ArrayList<SelectItem>();
		if (proposedPrice != 0.0) {
			if (proposedPrice <= salesCost) {
				reasons.add(new SelectItem("Nobody Needs it"));
				reasons.add(new SelectItem("Bad Quality"));
				reasons.add(new SelectItem("Partly Broken"));
			} else {
				reasons.add(new SelectItem("Just Good"));
				reasons.add(new SelectItem("Everybody Asks for it"));
			}
		}
		return reasons;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public SalesItem(int productCode, double salesCost) {
		super();
		this.productCode = productCode;
		this.salesCost = salesCost;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public double getProposedGrossMargin() {
		if (proposedPrice == 0)
			return 0;
		else {
			return (proposedPrice - salesCost) / proposedPrice;
		}
	}

	public double getProposedPrice() {
		return proposedPrice;
	}

	public void setProposedPrice(double proposedPrice) {
		this.proposedPrice = proposedPrice;
	}

	public double getSalesCost() {
		return salesCost;
	}

	public void setSalesCost(double salesCost) {
		this.salesCost = salesCost;
	}
}
