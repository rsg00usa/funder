package org.sglaser.invest.funder.data;

import java.util.Collection;
import java.util.Iterator;

import com.vaadin.data.Item;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;

public class DataTest {

	private static final Logger LOG = LoggerFactory.getLogger(DataTest.class);
	
	public static void main(String[] args) {

		LOG.info("Create simple test to verify it works");
		DBConnector dbcon = new DBConnector();
		SQLContainer sqlcon = dbcon.getSQLContainer("history");
		System.out.println("Number of items(rows): " + sqlcon.size() + " row ids: " + sqlcon.getItemIds());
		System.out.println("Last item: " + sqlcon.getItem(sqlcon.lastItemId()));
		System.out.println("Last item id: " + sqlcon.lastItemId());
		Item item = sqlcon.getItem(sqlcon.lastItemId());
		Collection<?> list = item.getItemPropertyIds();
		for (Iterator<?> it = list.iterator(); it.hasNext();) {
			System.out.println("Property: " + (String) it.next());
		}
		System.out.println("Number of properties per item: " + list.size());
	}
}
