package org.sglaser.invest.funder.model;

import java.io.Serializable;

/**
 * Simple entity bean that contains the data for an investment.
 */
public abstract class Trade implements Serializable {

	private static final long serialVersionUID = 4410529370740890035L;
	private String symbol;

	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
