package amnon_project;

import java.util.ArrayList;

public class productUndoOrder implements Command {
	
	private product p;
	private ArrayList<order> Orders;
	private order newOrder;
	
	public productUndoOrder(product p,order o) {
		this.p = p;
		this.Orders=p.getOrders();
		this.newOrder=o;
	}
	
	public void undo() {
		p.setStock(newOrder.getAmmount()); 
		this.Orders.remove(newOrder);
		newOrder.printOrder();
		System.out.println("Order cancelled by the store :(");
	}



}
