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

public class HistoryView extends VerticalLayout implements View {

	private static final Logger LOG = LoggerFactory.getLogger(HistoryView.class);
	private static final long serialVersionUID = -8245699813132323553L;
	protected static final String NAME = "historyview"; 
	
	public HistoryView() {

		setMargin(true);
		setSpacing(true);
		
		addComponent(new Label("Transaction History"));
		
		LOG.info("Load data from transaction table into grid");
		DBConnector conn = new DBConnector();
		SQLContainer sqlcon = conn.getSQLContainer("history");
		
		LOG.info("Filter out unwanted data such as PKey");
		Grid grid = new Grid();
		grid.setSizeFull();
		grid.setContainerDataSource(sqlcon);
		grid.removeColumn("pkey");
		addComponent(grid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("In History View");
	}
}
