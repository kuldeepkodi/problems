package model;

import java.util.List;

public class Order {
	private String orderName;
	private List<String> items;
	
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return orderName;
	}
}
