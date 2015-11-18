package org.sglaser.invest.funder.ui;

import java.sql.SQLException;

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

public class InvestmentView extends VerticalLayout implements View {

	private static final Logger LOG = LoggerFactory.getLogger(InvestmentView.class);
	private static final long serialVersionUID = -8245699813132323553L;
	protected static final String NAME = "";  // Default name is "" for navigation
	
	public InvestmentView() {

		setMargin(true);
		setSpacing(true);
		
		addComponent(new Label("Investments"));
		
		LOG.info("Load data into grid");
		DBConnector conn = new DBConnector();
		SQLContainer sqlcon = null;
		try {
			sqlcon = conn.getSQLContainer("investment");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQLContainer Error");
		}
		LOG.info("Filter out unwanted data such as PKey");
//		sqlcon.addContainerFilter(propertyId, filterString, ignoreCase, onlyMatchPrefix);
		Grid grid = new Grid();
		grid.setContainerDataSource(sqlcon);

//		grid.addColumn("name", String.class);
//		grid.addColumn("born", Integer.class);
//
//		LOG.info("Add some data rows");
//		grid.addRow("Nicolaus Copernicus", 1543);
//		grid.addRow("Galileo Galilei", 1564);
//		grid.addRow("Johannes Kepler", 1571);

		addComponent(grid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("In InvestmentView");
	}
}
