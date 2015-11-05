package org.sglaser.invest.funder;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class BuyView extends Panel implements View {

	private static final long serialVersionUID = -3605296157272609711L;
	protected static final String NAME = "buyview";

	public BuyView() {
		
		setSizeFull();  // to ensure the panel takes the available space	
        
		FormLayout layout = new FormLayout();
		layout.setSizeUndefined(); // Shrink to fit
		layout.setMargin(true);	
		layout.addComponent(new Label("Buy Investments"));
		layout.addComponent(new TextField("Symbol"));
		layout.addComponent(new TextField("Number of shares"));
		layout.addComponent(new TextField("Buy Price"));
		layout.addComponent(new TextField("Buy Date"));
		layout.addComponent(new TextField("Commission"));
		
		Button button = new Button("Submit");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Saved"));
			}
		});
		layout.addComponent(button);
		setContent(layout);
    }
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("In BuyView");
	}
}
