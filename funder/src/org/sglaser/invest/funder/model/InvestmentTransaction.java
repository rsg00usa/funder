package org.sglaser.invest.funder.model;

/**
 * Simple entity bean that contains the data for an investment.
 */
public class InvestmentTransaction extends Investment {

	private static final long serialVersionUID = -1530033535975616381L;
	private InvestmentDetail buyInvestment;
	private InvestmentDetail sellInvestment;

	public InvestmentTransaction() {
	}

	public InvestmentTransaction(String symbol, InvestmentDetail buyInvestment, InvestmentDetail sellInvestment) {
		super();
		this.setSymbol(symbol);
		this.setBuyInvestment(buyInvestment);
		this.setSellInvestment(sellInvestment);
	}

	public InvestmentDetail getBuyInvestment() {
		return buyInvestment;
	}

	public void setBuyInvestment(InvestmentDetail buyInvestment) {
		this.buyInvestment = buyInvestment;
	}

	public InvestmentDetail getSellInvestment() {
		return sellInvestment;
	}

	public void setSellInvestment(InvestmentDetail sellInvestment) {
		this.sellInvestment = sellInvestment;
	}
}
