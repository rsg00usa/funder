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
		SQLContainer sqlcon = dbcon.getSQLContainer("transaction");

		
		System.out.println("Number of items(rows): " + sqlcon.size());
		System.out.println("Last item: " + sqlcon.getItem(sqlcon.lastItemId()));
		Item item = sqlcon.getItem(sqlcon.lastItemId());
		Collection<?> list = item.getItemPropertyIds();
		for (Iterator<?> it = list.iterator(); it.hasNext();) {
			String s = (String) it.next();
			System.out.println("Property: " + s);
		}
		System.out.println("Number of properties per item: " + list.size());

//		Object id = sqlcon.addItem();
//		sqlcon.getContainerProperty(id, "symbol").setValue("YHOO");		
//		System.out.println("Item: " + con.firstItemId());
//		for (HashMap<String,String> map : list) {
//			System.out.println("Map: " + map);
//		}
//		Object o = con.lastItemId();
//		Item i = con.getItem(con.lastItemId());
//		i.getItemProperty(1);
//		System.out.println("Item: " + con.getItemIds());
//		ArrayList<String> list = (ArrayList<String>) con.getPageLength().getItemIds();
//		for(String item : list) {
//			System.out.println("Value: " + item);
//		}
	}
}
