package org.sglaser.invest.funder.model;

import java.sql.SQLException;
import java.util.Collection;

import org.sglaser.invest.funder.data.DBConnector;
import org.sglaser.invest.funder.ui.TradeView;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;

public class Investment {

	private static final Logger LOG = LoggerFactory.getLogger(TradeView.class);
	
	public void calculate(Transaction transaction) {
		DBConnector dbconn = new DBConnector();
        SQLContainer sqlcon = dbconn.getSQLContainer("portfolio");
        
        LOG.info("Compare data from transaction bean with data in portfolio table");
        Collection<?> idList = sqlcon.getItemIds();        
        boolean newTransaction = true;
        for (Object id: idList) {
        	Object symbol = sqlcon.getContainerProperty(id, "symbol").getValue();
	        if (symbol.equals(transaction.getSymbol())) {  
	        	newTransaction = false;
	        	Integer shares = (Integer) sqlcon.getContainerProperty(id, "shares").getValue();
	        	Integer value = (Integer) sqlcon.getContainerProperty(id, "value").getValue();
        		
	        	if ((transaction.getType().toString()).equals("buy")) {
	        		shares += transaction.getNumberOfShares();
	        		value += (transaction.getPrice() * transaction.getNumberOfShares());
	        	} else {
	        		shares -= transaction.getNumberOfShares();
	        		value -= (transaction.getPrice() * transaction.getNumberOfShares());
	        	}
	        	 sqlcon.getContainerProperty(id, "shares").setValue(shares);
	        	 sqlcon.getContainerProperty(id, "value").setValue(value);
	        	 sqlcon.getContainerProperty(id, "Last Updated").setValue(transaction.getDate());
	        	 try {
	        		 sqlcon.commit();
	        	 } catch (UnsupportedOperationException e) {
	        		 throw new RuntimeException(e);
	        	 } catch (SQLException e) {
	        		 throw new RuntimeException(e);
	        	 }
	        } 
        }
        if (newTransaction) {
        	LOG.info("Add new investment into portfolio");
        	Object portfolioId = sqlcon.addItem();
        	sqlcon.getContainerProperty(portfolioId, "symbol").setValue(transaction.getSymbol());
        	sqlcon.getContainerProperty(portfolioId, "shares").setValue(transaction.getNumberOfShares());
        	sqlcon.getContainerProperty(portfolioId, "value").setValue(transaction.getNumberOfShares() * transaction.getPrice());
        	sqlcon.getContainerProperty(portfolioId, "Last Updated").setValue(transaction.getDate());
        	try {
       		 sqlcon.commit();
       	 } catch (UnsupportedOperationException e) {
       		 throw new RuntimeException(e);
       	 } catch (SQLException e) {
       		 throw new RuntimeException(e);
       	 }
        }
	}
}
