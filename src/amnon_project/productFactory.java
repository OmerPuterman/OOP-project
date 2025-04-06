package amnon_project;

import java.util.ArrayList;
import java.util.Scanner;

public class productFactory {
	public product createProduct(int weight,String product_name,int cost_price,int selling_price,int stock,String countryDest,int type,String catalogNum) {
		if(type == 1) {
			return new storeProduct(weight,product_name,cost_price,selling_price,stock,catalogNum);
		}
		else if(type== 2) {
			return new websiteProduct(weight,product_name,cost_price,selling_price,stock,catalogNum,countryDest);
		}
		return new wholesalersProduct(weight,product_name,cost_price,selling_price,stock,catalogNum);
	}
	public product createProductByUser(int type,String catalogNum) {
		Scanner sc = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		System.out.println("enter wight for product");
		int weight=sc.nextInt();
		System.out.println("enter name for product");
		String product_name=scString.next();
		System.out.println("enter cost price for product");
		int cost_price=sc.nextInt();
		System.out.println("enter selling price for product");
		int selling_price=sc.nextInt();
		System.out.println("enter stock ammount for product");
		int stock=sc.nextInt();
		if(type == 1) {
			
			return new storeProduct(weight,product_name,cost_price,selling_price,stock,catalogNum);
		}
		else if(type== 2) {
			System.out.println("enter country origin for product");
			String countryDest=scString.next();
			return new websiteProduct(weight,product_name,cost_price,selling_price,stock,catalogNum,countryDest);
		}
		return new wholesalersProduct(weight,product_name,cost_price,selling_price,stock,catalogNum);
	}
}
