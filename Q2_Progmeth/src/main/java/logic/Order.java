package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		// TODO
		this.orderNumber = totalOrderCount;
		totalOrderCount++;
		orderItemList = new ArrayList<OrderItem>(0);
	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		// Loop the orderItemList to find if item of any orderItem equals to the given item
		// if there is orderItem with given item, increase that orderItem itemAmount with amount
		// and return that orderItem

		// else create new orderItem with given item and amount, then return the new orderItem

		// Increase Item
		for (int i=0; i<orderItemList.size(); i++) {
			if (orderItemList.get(i).getItem() == item) {
				orderItemList.get(i).increaseItemAmount(amount);
				return orderItemList.get(i);
			}
		}

		// Add order
		orderItemList.add(new OrderItem(item, amount));
		return orderItemList.getLast();
	}

	public int calculateOrderTotalPrice() {
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int result = 0;

		for (int i=0; i<orderItemList.size(); i++) result = result + orderItemList.get(i).calculateTotalPrice();

		return result;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
