package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Order;

public class Tester {

	public static void main(String[] args) {
		//CREATING ORDERS WITH ITEMS
		Order order1 = new Order();
		order1.setOrderName("Order1");
		order1.setItems(Arrays.asList("item1", "item3"));
		Order order2 = new Order();
		order2.setOrderName("Order2");
		order2.setItems(Arrays.asList("item3"));
		Order order3 = new Order();
		order3.setOrderName("Order3");
		order3.setItems(Arrays.asList("item1"));
		Order order4 = new Order();
		order4.setOrderName("Order4");
		order4.setItems(Arrays.asList("item1", "item2"));
		
		// CREATING LIST OF ORDERS
		List<Order> orders = Arrays.asList(order1, order2, order3, order4);
		
		// CREATING A HASHMAP WITH KEY AS ITEMS AND 
		// VALUE AS A LIST OF ORDERS CONTAINING THE ITEM
		HashMap<String, List<Order>> map = new HashMap<>();
		for (Order o : orders) {
			for (String i : o.getItems()) {
				if(map.containsKey(i)) {
					List<Order> existing = map.get(i);
					existing.add(o);
					map.put(i, existing);
				}else {
					ArrayList<Order> newList = new ArrayList<Order>();
					newList.add(o);
					map.put(i, newList);
				}
			}
		}
		
		// IDENTIFYING THE TOP 1 AND TOP 2 ITEMS BASED ON HOW MANY ORDERS CONTAIN THE ITEM		
		int max = 1, secondMax = 1;
		String top1 = null, top2 = null;
		
		for (String item : map.keySet()) {
			if(map.get(item).size()>max) {
				max = map.get(item).size();
				top1 = item;
			}
		}
		
		for (String item : map.keySet()) {
			if(!item.equals(top1)) {
				if(map.get(item).size()>secondMax) {
					secondMax = map.get(item).size();
					top2 = item;
				}
			}
		}
		
		//DOING THE SAME IN ONE LOOP
//		for (String item : map.keySet()) {
//		if(map.get(item).size()>max) {
//			max = map.get(item).size();
//			top1 = item;
//		}else if(map.get(item).size()>secondMax) {
//			secondMax = map.get(item).size();
//			top2 = item;
//		}
//	}
		
		//DISPLAYING THE OUTPUT
		List<Order> top1Orders = map.get(top1);
		List<Order> top2Orders = map.get(top2);
		
		System.out.println(top1 + "-> " + "usageCount: " + top1Orders.size() + "; corresponding orders; "+ top1Orders);
		System.out.println();
		System.out.println(top2 + "-> " + "usageCount: " + top2Orders.size() + "; corresponding orders; "+ top2Orders);
		
		
	}

}
