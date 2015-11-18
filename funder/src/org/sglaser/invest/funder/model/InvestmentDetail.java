package org.sglaser.invest.funder.model;

import java.util.Date;

/**
 * Simple entity bean that contains the data for an investment.
 */
public class InvestmentDetail extends Investment {

	private static final long serialVersionUID = -6990593733218115847L;
	private int numberOfShares;
	private int price;
	private Date date;
	private int commission;

	public InvestmentDetail() {
	}

	public InvestmentDetail(String symbol, int numberOfShares, int price, Date date, int commission) {
		super();
		this.setSymbol(symbol);
		this.setNumberOfShares(numberOfShares);
		this.setPrice(price);
		this.setDate(date);
		this.setCommission(commission);
	}
	
	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}
}
