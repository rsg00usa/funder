package org.sglaser.invest.funder;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("funder")
public class FunderUI extends UI {
	
	private final static Logger LOG = LoggerFactory.getLogger(FunderUI.class);

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = FunderUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		getPage().setTitle("Funder");
		
		// Build the root container
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setSizeFull();  // to ensure whole space is in use
		mainLayout.setSpacing(true);
		setContent(mainLayout);
		
		// Build the header container which will be added to the root container
		HorizontalLayout header = new HorizontalLayout();
		header.setSpacing(true);
		header.addComponent(new Link("Investments", new ExternalResource("#!" + "")));
		header.addComponent(new Link("Buy Investment", new ExternalResource("#!" + "buyview")));
		header.addComponent(new Link("Sell Investment", new ExternalResource("#!" + "sellview")));
		mainLayout.addComponent(header);

		// Build the content as a panel component which will be added to the root container where all navigation happens
		Panel content = new Panel();
		content.setSizeFull();  // to ensure the panel only takes the available space	
		mainLayout.addComponent(content);
		mainLayout.setExpandRatio(content, 1);  // to determine which component takes the excess space
		
		// Configure navigation
		Navigator navigator = new Navigator(this, content);
        navigator.addView(InvestmentView.NAME, new InvestmentView());
        navigator.addView(BuyView.NAME, new BuyView());
        navigator.addView(SellView.NAME, new SellView());
	}
}