package amnon_project;

import java.util.ArrayList;
import java.util.HashSet;

import amnon_project.Invoice.invoice;

public class wholesalersProduct extends product{
	private Invoice i;
	public wholesalersProduct(int weight, String product_name, int cost_price, int selling_price, int stock,
			ArrayList<order> Orders,String catalogNum) {
		super(weight, product_name, cost_price, selling_price, stock, Orders,catalogNum);
		i=Invoice.getInstance2();
		i.SetProduct(this);
		// TODO Auto-generated constructor stub
	}
	public wholesalersProduct(int weight, String product_name, int cost_price, int selling_price, int stock,String catalogNum) {
		super(weight, product_name, cost_price, selling_price, stock,catalogNum);
		i=Invoice.getInstance2();
		i.SetProduct(this);
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return super.toString();
	}
	public void printInvoice()
	{
			writeInvoiceForAccounted WIFA =new writeInvoiceForAccounted();
			i.SetProduct(this);
			i.printInvoice(WIFA);
	}


}
