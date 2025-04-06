package amnon_project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import amnon_project.Invoice.invoice;
import amnon_project.ShippingCom.delivery;

public abstract class product {
	public final static int USD_TO_ILS =4;
	protected int weight;
	protected String product_name;
	protected int cost_price;
	protected int selling_price;
	protected int stock;
	protected ArrayList<order> Orders;
	protected String catalogNum;
	public product(int weight,String product_name,int cost_price,int selling_price,int stock,ArrayList<order> Orders,String catalogNum)
	{
		this.weight=weight;
		this.product_name=product_name;
		this.cost_price=cost_price;
		this.selling_price=selling_price;
		this.stock=stock;
		this.Orders=Orders;
		this.catalogNum=catalogNum;
	}
	public product(int weight,String product_name,int cost_price,int selling_price,int stock,String catalogNum)
	{
		this.weight=weight;
		this.product_name=product_name;
		this.cost_price=cost_price;
		this.selling_price=selling_price;
		this.stock=stock;
		this.Orders=new ArrayList<order>();
		this.catalogNum=catalogNum;
	}
	public String toString() {
		String s = "the product is: " + this.product_name + "\n";
		s+= "it weighs: "+ this.weight+"\n";
		s+="and it costs "+this.selling_price+ "₪ \n";
		s+="catalog num is: "+this.catalogNum+"\n";
		s+="stock is "+this.stock+"\n";
		s+="\n";
		return s;
	}
	public boolean orderExist(String catalogNum)
	{
		boolean found = false;
		
		
		for (order o : Orders)
		{
			if(o.getCatalogNum().equals(catalogNum))
					found = true;
		}
	
		return found;
	}
	public String getCatalogNum() {
		return this.catalogNum;
	}
	public void setCatalogNum(String catalogNum) {
		this.catalogNum = catalogNum;
	}

	public double getTax()
	{
		return this.selling_price*0.17;
	}
	public int getProfit()
	{
		return this.selling_price-this.cost_price;
	}
	public int AllOrdersProfit()
	{
		int sumProfit=0;
		for (order o:Orders)
		{
			sumProfit+=o.getAmmount()*this.getProfit();
		}
		return sumProfit;
	}
	public void addOrder(order o)
	{
		if (this.stock<o.getAmmount())
		{
			System.out.println("not enough in stock to enter request");
			return;
		}
		this.stock-=o.getAmmount();
		this.Orders.add(o);
	}
	public void setStock(int s)
	{
		this.stock+=s;
	}
	public String getName()
	{
		return this.product_name;
	}
	public void printProduct(ArrayList<Observer>observer)
	{
		ShippingCom ship=null;
		Scanner s = new Scanner(System.in);
		int num = 0;
		double shippingFee = 0;
		System.out.println(this.toString());
		System.out.println("product stock is - " + this.getStock());
		
		if(this instanceof storeProduct)
		{
			System.out.println("product type is - store product.");
		}
		else if(this instanceof wholesalersProduct)
		{
			System.out.println("product type is - wholesalers product.");
		}
		else
		{
			System.out.println("product type is - website product. \n");
			System.out.println("Price in dollars $"+this.selling_price/USD_TO_ILS);
		}
			
		
		for(order o : this.Orders)
		{
			o.printOrder();
			
			if(this instanceof storeProduct)
				{
					do {
						System.out.println("what type of invoice would you like to print?");
						System.out.println("(1 for customer format, 2 for accountant format");
						num = s.nextInt();
					}while((num!=1)&&(num!=2));
			
						if(num == 1)
						{
							((storeProduct)this).printInvoice(invoice.toCustomer);
						}else {
							((storeProduct)this).printInvoice(invoice.toAccountant);
						}
						System.out.println("");
						
				}
			else if(this instanceof wholesalersProduct)
			{
				((wholesalersProduct)this).printInvoice();
			}else
			{
				System.out.println("Destination country - " + ((websiteProduct)this).getCountryDest());
				
				ship=((websiteProduct)this).getBestShipping(observer);
				if(ship.deliveryType == delivery.standart)
					shippingFee = ship.calcStandartShipping(this);
				else
					shippingFee = ship.calcExpressShipping(this);
				
				
			}
			
			System.out.println("shipping fee - " + shippingFee);
			System.out.println(ship);
			
			
			
			}
		
			System.out.println("total profit - " +  this.AllOrdersProfit());

			}
public int getStock() {
	return stock;
}
	
	public void printOrders()
	{
		for(order o : this.Orders)
		{
			o.printOrder();
		}
	}
	public ArrayList<order> getOrders()
	{
		return this.Orders;
	}
	

}
