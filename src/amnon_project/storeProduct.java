package amnon_project;

import java.util.ArrayList;
import java.util.HashSet;

import amnon_project.Invoice.invoice;

public class storeProduct extends product {
	private ArrayList<Invoice> invoices;
	
	public storeProduct(int weight, String product_name, int cost_price, int selling_price, int stock,
			ArrayList<order> Orders,String catalogNum) {
		super(weight, product_name, cost_price, selling_price, stock, Orders,catalogNum);
		Invoice i1=Invoice.getInstance();
		Invoice i2=Invoice.getInstance2();
		i1.SetProduct(this);
		i2.SetProduct(this);
		invoices=new ArrayList<Invoice>();
		invoices.add(i1);
		invoices.add(i2);
		// TODO Auto-generated constructor stub
	}
	public storeProduct(int weight, String product_name, int cost_price, int selling_price, int stock,String catalogNum) {
		super(weight, product_name, cost_price, selling_price, stock,catalogNum);
		Invoice i1=Invoice.getInstance();
		Invoice i2=Invoice.getInstance2();
		i1.SetProduct(this);
		i2.SetProduct(this);
		invoices=new ArrayList<Invoice>();
		invoices.add(i1);
		invoices.add(i2);
		// TODO Auto-generated constructor stub
	}
	public void printInvoice(invoice invoiceType)
	{
		if (invoiceType==invoice.toCustomer)
		{
			writeInvoiceForCustomer WIFC =new writeInvoiceForCustomer();
			invoices.get(0).SetProduct(this);
			invoices.get(0).printInvoice(WIFC);
		}
		else
		{
			writeInvoiceForAccounted WIFA =new writeInvoiceForAccounted();
			invoices.get(1).SetProduct(this);
			invoices.get(1).printInvoice(WIFA);
		}
	}
	public String toString() {
		return super.toString();
	}


}
