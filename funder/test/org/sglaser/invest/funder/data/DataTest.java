package org.sglaser.invest.funder.data;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import com.vaadin.data.Item;
import com.vaadin.data.util.sqlcontainer.SQLContainer;

public class DataTest {

	public static void main(String[] args) {

		// Create simple test to verify it works
		DBConnector conn = new DBConnector();
		SQLContainer con = null;
		try {
			con = conn.getSQLContainer("investment");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Number of rows/items: " + con.size());
		System.out.println("Item: " + con.getItem(con.lastItemId()));
		Item item = con.getItem(con.lastItemId());
		Collection<?> list = item.getItemPropertyIds();
		for (Iterator<?> it = list.iterator(); it.hasNext();) {
			String s = (String) it.next();
			System.out.println("Property: " + s);
		}
		System.out.println("Number of properties per item: " + list.size());

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
