package org.sglaser.invest.funder.data;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.sglaser.invest.funder.ui.TradeView;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;

public class DBConnector {

	private static final Logger LOG = LoggerFactory.getLogger(TradeView.class);
	private final String dbConfigFile = "dbconfig.properties";
	private final Properties dbprop = new Properties();
    
	public DBConnector() {
   
	  LOG.info("Read configuration information form dbConfigFile");
      InputStream in = getClass().getClassLoader().getResourceAsStream(dbConfigFile);
      try {
          dbprop.load(in);
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
	}
		
	public SQLContainer getSQLContainer(String tablename) {
		
		SQLContainer sqlCon = null;
		
		LOG.info("Create JDBC connecton");
		try {
			JDBCConnectionPool pool = new SimpleJDBCConnectionPool(
					dbprop.getProperty("drivername"),
					dbprop.getProperty("connectionuri"),
					dbprop.getProperty("dbuser"),
					dbprop.getProperty("dbpasswd"));
			
			TableQuery tq = new TableQuery(tablename, pool);
			tq.setVersionColumn("OPTLOCK");
			sqlCon = new SQLContainer(tq);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
		return sqlCon;
	}
}
