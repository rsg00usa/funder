package org.sglaser.invest.funder.model;

import java.util.Date;

import org.sglaser.invest.funder.data.TransactionType;

/**
 * Simple entity bean that contains the data for an investment.
 */
public class Transaction extends Trade {

	private static final long serialVersionUID = -6990593733218115847L;
	private int numberOfShares;
	private int price;
	private Date date;
	private int commission;
	private TransactionType type;

	public Transaction() {
	}

	public Transaction(String symbol, int numberOfShares, int price, TransactionType type, Date date, int commission) {
		super();
		this.setSymbol(symbol);
		this.setNumberOfShares(numberOfShares);
		this.setPrice(price);
		this.setType(type);
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

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
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
