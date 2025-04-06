package amnon_project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import amnon_project.ShippingCom.company;
import amnon_project.ShippingCom.delivery;

public class websiteProduct extends product {
	
	public final static int importTax =20;
	private String countryDest;
	private ArrayList<ShippingCom> shipping;
	public websiteProduct(int weight, String product_name, int cost_price, int selling_price, int stock,
			ArrayList<order> Orders,ArrayList<ShippingCom> shipping,String catalogNum) {
		super(weight, product_name, cost_price, selling_price*USD_TO_ILS, stock, Orders,catalogNum);
		// TODO Auto-generated constructor stub
		this.shipping=shipping;
		this.countryDest=countryDest;
	}
	public websiteProduct(int weight, String product_name, int cost_price, int selling_price, int stock,String catalogNum,String countryDest) {
		super(weight, product_name, cost_price, selling_price*USD_TO_ILS, stock,catalogNum);
		// TODO Auto-generated constructor stub
		this.shipping=new ArrayList<ShippingCom>();
		this.countryDest=countryDest;
	}
	//public String toString() {
	//	return super.toString()+" country destination: "+ this.countryDest+ "\n ";
	//}
	public String getCountryDest() {
		return countryDest;
	}

	public void setCountryDest(String countryDest) {
		this.countryDest = countryDest;
	}
	
	public ArrayList<ShippingCom> getShipping() {
		return shipping;
	}


	public void setShipping(ArrayList<ShippingCom> shipping) {
		this.shipping = shipping;
	}


	public static int getUsdToIls() {
		return USD_TO_ILS;
	}
	public void addShipping(ShippingCom s)
	{
		shipping.add(s);
	}
	
	
	
	
	public ShippingCom getBestShipping (ArrayList<Observer>o) {
		int type;
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("enter type of delivery you want 1-standart 2-express");
			type=sc.nextInt();
		}while(type!=1&&type!=2);
		for (Observer ob:o)
		{
			ob.msg();
		}
		DoubleComparator d = new DoubleComparator();
		 ArrayList<Double> temp = new ArrayList();
		 if (type==2)
		 {
			 for(int i =0 ;i < shipping.size(); i++ ) { 

			 	if(shipping.get(i).getDeliveryType() == delivery.express)
					 	temp.add(shipping.get(i).calcExpressShipping(this));
			 
		 	}
		 }
		 else
		 {
			 for(int i =0 ;i < shipping.size(); i++ ) { 
				 if(shipping.get(i).getDeliveryType() == delivery.standart)
					 temp.add(shipping.get(i).calcStandartShipping(this));		
				 }
			 
		 }
		 
		 temp.sort(d);
		 double min = temp.get(0);
		 
		 for(int i =0 ;i < shipping.size(); i++ ) { 
			 if(shipping.get(i).getDeliveryType() == delivery.express&&type==2) {
				 if(shipping.get(i).calcExpressShipping(this) == min)
					return shipping.get(i);
			 }
			 else {
				 if(shipping.get(i).getDeliveryType() == delivery.standart&&type==1)
				 {
					 if( shipping.get(i).calcStandartShipping(this) == min)
						 return shipping.get(i);
				 }
				 
			 }
		 }
		 return null;
	}


	



}
