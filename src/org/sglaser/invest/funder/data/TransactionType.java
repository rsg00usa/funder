package org.sglaser.invest.funder.data;

public enum TransactionType {

	Buy("buy"),
    Sell("sell");

    private final String type;

    private TransactionType(final String type) {
        this.type = type;
    }
    
    public String getValue() {
    	return this.type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
