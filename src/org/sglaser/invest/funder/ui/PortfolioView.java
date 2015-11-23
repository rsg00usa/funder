package org.sglaser.invest.funder.ui;

import org.sglaser.invest.funder.data.DBConnector;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class PortfolioView extends VerticalLayout implements View {

	private static final Logger LOG = LoggerFactory.getLogger(PortfolioView.class);
	private static final long serialVersionUID = -8245699813132323553L;
	protected static final String NAME = "";  // Default name is "" for navigation
	
	public PortfolioView() {

		setMargin(true);
		setSpacing(true);
		
		addComponent(new Label("Portfolio"));
		
		LOG.info("Load data from investment table into grid");
		DBConnector conn = new DBConnector();
		SQLContainer sqlcon = conn.getSQLContainer("portfolio");
		
		LOG.info("Filter out unwanted data such as PKey");
		Grid grid = new Grid();
		grid.setSizeFull();
		grid.setContainerDataSource(sqlcon);
		grid.removeColumn("pkey");
		addComponent(grid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("In Portfolio View");
	}
}
