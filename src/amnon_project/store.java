package amnon_project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class store {
	private static store instance;
	private ArrayList<product> products;
	private store()
	{
		this.products = new ArrayList();
	}
	public static store getInstance()
	{
		if (instance==null)
		{
			instance = new store();
		}
		return store.instance;
	}
	public static void setInstance(store s)
	{
		store.instance=s;
	}
	public void printProducts ()
	{
		Iterator itr = products.iterator();
		int i = 0;
        while (itr.hasNext()) 
        {
            System.out.println("#" + i + " " + itr.next());
            i++;
        }
	}
	
	public void deleteProduct ()
	{
		Scanner s = new Scanner(System.in);
		boolean isDeleted=false;
		String name = "";
		printProducts();
		System.out.println("Please enter the name of the product you would like to remove: ");
		name = s.next();
		 for (product p : products) {
	            if (p.getName().equals(name)) {
	                // Remove the element if found
	            	isDeleted =  products.remove(p);
	                break; // Stop iterating after removing the element
	            }
		 }
		if(isDeleted)
			System.out.println("Item succcessfully removed.");
		else
			System.out.println("Item was not removed.");
	            
	}
	
	public void updateStock()
	{
		Scanner s = new Scanner(System.in);
		int num;
		printProducts();
		do {
		System.out.println("Please enter the number of the product to update his stock:");
		num = s.nextInt();
		}while(num<0||num>getNumOfProducts());
		
		product p = getElementAtIndex(num);
	
		do {
		System.out.println("Please enter the amount to add to stock:");
		num = s.nextInt();
		}while(num<0);
		p.setStock(num);
		System.out.println("Stock updated succcessfully.");
		
		
		
	
	}
	
	public product getElementAtIndex( int index) {
        Iterator<product> iterator = this.products.iterator();
        int currentIndex = 0;

        while (iterator.hasNext()) {
            product element = iterator.next();
            if (currentIndex == index) {
                return element;
            }
            currentIndex++;
        }
		return null;
	}
	
	public int getNumOfProducts () {
		return products.size();
	}
	public Boolean productExists(String catalogNum)
	{
		for(product p:products)
		{
			if (p.getCatalogNum().equals(catalogNum))
			{
				System.out.println("Product already added");
				return true;
			}
		}
		return false;
	}
	public void addProduct(product p)
	{
		products.add(p);
	}
	public ArrayList<product> getProducts()
	{
		return this.products;
	}
	
	public order addOrderToProduct () {
		Scanner s = new Scanner(System.in);
		String name, mobileNum,catalogNum;
		boolean found = false;
		printProducts();
		
		do {
		System.out.println("enter catalog number of the product you want: ");
		String prodNum = s.next();
		
		for(product p: products) {
			if(p.getCatalogNum().equals(prodNum))
			{
				do {
					System.out.println("Please catalog number for your order: ");
					catalogNum = s.next();
				}while (p.orderExist(catalogNum));
			
				System.out.println("Please enter your name: ");
				name = s.next();
				System.out.println("Please enter your mobile phone number: ");
				mobileNum = s.next();
				customer c = new customer(name,mobileNum);
		
				System.out.println("Please enter the ammount you want: ");
				int ammount = s.nextInt();
				found = true;
				order o = new order(c,ammount,p ,catalogNum);
				return o;
			}
			
		}
		}while(!found);
		return null;
	}
	public String toString()
	{
		int profit=0;
		String s=new String();
		for (product p:products)
		{
			s+=p.toString();
			profit+=p.AllOrdersProfit();
		}
		s+="and the current profit of the store is: "+ profit+"\n ";
		return s;
		
	}
	public void productByCatalogNum(String cNum,ArrayList<Observer>o)
	{
		//Iterator itr = products.iterator();
	//	int i = 0;
      //  while (itr.hasNext()) 
      //  {
      //  	if(getElementAtIndex(i).catalogNum == cNum)
      //  	{
      //  		getElementAtIndex(i).printProduct();
      //  		break;
       // 	}
       // 	itr.next();
        //    i++;
          
        //}
		for(product p:products)
		{
			if (p.getCatalogNum().equals(cNum))
			{
				p.printProduct(o);
				break;
			}
		}
	}
	
	public void printOrdersByProduct(String cNum)
	{
		for(product p:products)
		{
			if (p.getCatalogNum().equals(cNum))
			{
				p.printOrders();
				break;
			}
		}
	}
	public void setProducts(ArrayList<product>products)
	{
		this.products=products;
	}
}
