package org.sglaser.invest.funder.data;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import org.sglaser.invest.funder.ui.BuyView;

import com.vaadin.data.Item;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;

public class DBConnector {

	private static final Logger LOG = LoggerFactory.getLogger(BuyView.class);
	private final String dbConfigFile = "dbconfig.properties";
    
	private Properties getDbProperties() {
	   
	  final Properties configProp = new Properties();
   
	  LOG.info("Read configuraiton information form dbConfigFile");
      InputStream in = getClass().getClassLoader().getResourceAsStream(dbConfigFile);
      try {
          configProp.load(in);
      } catch (IOException e) {
          e.printStackTrace();
      }
      return configProp;
   }
		
	public SQLContainer getSQLContainer(String tablename) throws SQLException {
		
		Properties dbprop = getDbProperties();
		JDBCConnectionPool pool = null;
		
		LOG.info("Create JDBC connecton");
		try {
			pool = new SimpleJDBCConnectionPool(
					dbprop.getProperty("drivername"),
					dbprop.getProperty("connectionuri"),
					dbprop.getProperty("dbuser"),
					dbprop.getProperty("dbpasswd"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		TableQuery tq = new TableQuery(tablename, pool);
		tq.setVersionColumn("OPTLOCK");
		SQLContainer con = new SQLContainer(tq);
		return con;
	}
	
//	Object id = personContainer.addItem();
//	personContainer.getContainerProperty(id, "FIRSTNAME")
//	.setValue(firstName);
//	personContainer.getContainerProperty(id, "LASTNAME")
//	.setValue(lastName);
}
