package org.sglaser.invest.funder.model;

import java.io.Serializable;

/**
 * Simple entity bean that contains the data for an investment.
 */
public class Investment implements Serializable {

	private static final long serialVersionUID = -1530033535975616381L;
	private String symbol;
	private InvestmentTransaction buyInvestment;
	private InvestmentTransaction sellInvestment;

	public Investment() {
	}

	public Investment(String symbol, InvestmentTransaction buyInvestment, InvestmentTransaction sellInvestment) {
		super();
		this.setSymbol(symbol);
		this.setBuyInvestment(buyInvestment);
		this.setSellInvestment(sellInvestment);
	}

	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public InvestmentTransaction getBuyInvestment() {
		return buyInvestment;
	}

	public void setBuyInvestment(InvestmentTransaction buyInvestment) {
		this.buyInvestment = buyInvestment;
	}

	public InvestmentTransaction getSellInvestment() {
		return sellInvestment;
	}

	public void setSellInvestment(InvestmentTransaction sellInvestment) {
		this.sellInvestment = sellInvestment;
	}
}
