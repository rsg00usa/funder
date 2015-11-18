package org.sglaser.invest.funder.ui;

import org.sglaser.invest.funder.model.InvestmentDetail;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class BuyView extends Panel implements View {

	private static final Logger LOG = LoggerFactory.getLogger(BuyView.class);
	private static final long serialVersionUID = -3605296157272609711L;
	protected static final String NAME = "buyview";

	@SuppressWarnings("serial")
	public BuyView() {
		
		LOG.info("Bind the model beans to the UI");
		InvestmentDetail investmentDetailBean = new InvestmentDetail();
		final BeanFieldGroup<InvestmentDetail> binder = new BeanFieldGroup<InvestmentDetail>(InvestmentDetail.class);
		binder.setItemDataSource(investmentDetailBean);
		
		LOG.info("Build the buy view form");
		FormLayout layout = new FormLayout();
		layout.setMargin(true);	
		layout.addComponent(new Label("Buy Investments"));
		layout.addComponent(binder.buildAndBind("Symbol", "symbol"));
		layout.addComponent(new TextField("Number of shares"));
		layout.addComponent(new TextField("Buy Price"));
		layout.addComponent(new TextField("Buy Date"));
		layout.addComponent(new TextField("Commission"));
		
		LOG.info("Add submit button to commit input to bean");
		binder.clear();
		binder.setBuffered(true);
		layout.addComponent(new Button("Commit", new ClickListener() {
		    @Override
		    public void buttonClick(ClickEvent event) {
		        try {
		            binder.commit();
		            binder.clear();
		            Notification.show("Commited"); 
		        } catch (CommitException e) {
		        	e.printStackTrace();
		        }
		    }
		}));
		setContent(layout);
    }
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("In BuyView");
	}
}
