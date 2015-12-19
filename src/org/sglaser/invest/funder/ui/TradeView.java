package org.sglaser.invest.funder.ui;

import java.sql.SQLException;

import org.sglaser.invest.funder.data.DBConnector;
import org.sglaser.invest.funder.model.Investment;
import org.sglaser.invest.funder.model.Transaction;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class TradeView extends Panel implements View {

	private static final Logger LOG = LoggerFactory.getLogger(TradeView.class);
	private static final long serialVersionUID = -3605296157272609711L;
	protected static final String NAME = "tradeview";

	@SuppressWarnings("serial")
	public TradeView() {
		
		LOG.info("Bind the model beans to the UI for input");
		Transaction transactionBean = new Transaction();
		final BeanFieldGroup<Transaction> binder = new BeanFieldGroup<Transaction>(Transaction.class);
		binder.setItemDataSource(transactionBean);
		binder.setBuffered(true);
		
		LOG.info("Build the trade form for entering trade transactions");
		FormLayout layout = new FormLayout();
		layout.setMargin(true);	
		layout.addComponent(new Label("Trade"));
		layout.addComponent(binder.buildAndBind("symbol"));
		layout.addComponent(binder.buildAndBind("Number of Shares", "numberOfShares"));
		layout.addComponent(binder.buildAndBind("price"));
		layout.addComponent(binder.buildAndBind("date"));
		layout.addComponent(binder.buildAndBind("commission"));
		layout.addComponent(binder.buildAndBind("Transaction Type", "type", OptionGroup.class));

		LOG.info("Add submit button to commit input to bean");
		layout.addComponent(new Button("Commit", new ClickListener() {
		    @Override
		    public void buttonClick(ClickEvent event) {
		        try {
		            binder.commit();
		            binder.clear();
		            Notification.show("Commited");
		            
		            LOG.info("Write input from bean to database");
		            DBConnector dbconn = new DBConnector();
		            SQLContainer sqlcon = dbconn.getSQLContainer("history");
		            Object id = sqlcon.addItem();
		            sqlcon.getContainerProperty(id, "symbol").setValue(transactionBean.getSymbol());
		            sqlcon.getContainerProperty(id, "price").setValue(transactionBean.getPrice());
		            sqlcon.getContainerProperty(id, "shares").setValue(transactionBean.getNumberOfShares());
		            sqlcon.getContainerProperty(id, "transaction").setValue(transactionBean.getType().toString());
		            sqlcon.getContainerProperty(id, "commission").setValue(transactionBean.getCommission());
		            sqlcon.getContainerProperty(id, "Transaction Date").setValue(transactionBean.getDate());
		            sqlcon.commit();
		            
		            LOG.info("Invoke calcuation of existing investments");
		            Investment inv = new Investment();
		            inv.calculate(transactionBean);
		        } catch (CommitException e) {
					new RuntimeException(e);
				} catch (SQLException e) {
					new RuntimeException(e);
				}
		    }
		}));
		setContent(layout);
    }
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("In Trade View");
	}
}
