package amnon_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

import amnon_project.Invoice.invoice;
import amnon_project.ShippingCom.company;
import amnon_project.ShippingCom.delivery;

public class Main {
	private static Stack<Command> stackCommand = new Stack<>();
	private static Stack<storeMemento> stack = new Stack<storeMemento>();
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ArrayList<Observer> observer=new ArrayList<>();
		String catalogNum;
		store s=store.getInstance();
		String cNum;
		Scanner sc = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		productFactory pFactory=new productFactory();
		Boolean going=true;
		while (going)
		{
			Collections.sort(s.getProducts(),new productComparator());
			System.out.println("Welcome to the Menu");
			System.out.println("4.1 To create a example for the system press a");
			System.out.println("4.2 To add a product press b");
			System.out.println("4.3 To delete a product from the store press c");
			System.out.println("4.4 To add stock to a product press d");
			System.out.println("4.5 To add a Order to a product press f");
			System.out.println("4.6 To undo the last Order from a product press g");
			System.out.println("4.7 To show a product using catalog number press h");
			System.out.println("4.8 To print all the store products press i");
			System.out.println("4.9 To print the orders of a product using catalog number press j");
			System.out.println("4.10 To create a backup point in the store press k");
			System.out.println("4.10 To change back to the backup press l");
			System.out.println("If you want to exit the menu press e/E");
			char num = sc.next().charAt(0);
			switch (num) {
			case 'a':
				customer c1=new customer("eric","000000");
				customer c2=new customer("ben el","000001");
				customer c3=new customer("michal","000002");
				customer c4=new customer("jordi","000003");
				customer c5=new customer("static","000004");
				product p1=pFactory.createProduct(2, "milk", 6, 10, 100, null, 1,"aa");
				product p2=pFactory.createProduct(1, "chocolate", 4, 9, 20, null, 1,"ab");
				product p3=pFactory.createProduct(1, "gum", 10, 12, 30, null, 1,"ac");
				order o1=new order(c1,20,p1,"1");
				order o2=new order(c2,10,p1,"2");
				order o3=new order(c3,2,p1,"3");
				order o4=new order(c2,1,p2,"4");
				order o5=new order(c3,5,p2,"5");
				order o6=new order(c4,6,p2,"6");
				order o7=new order(c3,10,p3,"7");
				order o8=new order(c4,10,p3,"8");
				order o9=new order(c5,9,p3,"9");
				ShippingCom s1=new ShippingCom(delivery.express, company.DHL, "Avi", "123456",12);
				ShippingCom s2=new ShippingCom(delivery.standart, company.DHL, "Aviella", "654321",5);
				ShippingCom s3=new ShippingCom(delivery.express, company.FedEx, "ella", "999999",25);
				observer.add(new shippingComListener("Calculating price ",s1));
				observer.add(new shippingComListener("Be right there with the price ",s3));
				product p4=pFactory.createProduct(300, "planes", 5000, 8000, 45, "Israel", 2,"ba");
				product p5=pFactory.createProduct(250, "boats", 1000, 2500, 10, "Russia", 2,"bb");
				product p6=pFactory.createProduct(60, "monkeys", 500, 700, 20, "United Kingdom", 2,"bc");
				((websiteProduct)p4).addShipping(s1);
				((websiteProduct)p4).addShipping(s2);
				((websiteProduct)p5).addShipping(s1);
				((websiteProduct)p5).addShipping(s2);
				((websiteProduct)p5).addShipping(s3);
				((websiteProduct)p6).addShipping(s3);
				order o10=new order(c5,10,p4,"10");
				order o11=new order(c2,20,p4,"11");
				order o12=new order(c1,5,p4,"12");
				order o13=new order(c3,2,p5,"13");
				order o14=new order(c1,3,p5,"14");
				order o15=new order(c4,1,p5,"15");
				order o16=new order(c2,15,p6,"16");
				order o17=new order(c4,2,p6,"17");
				order o18=new order(c5,2,p6,"18");
				product p7=pFactory.createProduct(2, "Tuna", 10, 20, 1000, null, 3,"bd");
				product p8=pFactory.createProduct(5, "Rice", 5, 12, 1000, null, 3,"be");
				product p9=pFactory.createProduct(1, "Eggs", 6, 10, 1000, null, 3,"bf");
				order o19=new order(c5,100,p7,"19");
				order o20=new order(c4,200,p7,"20");
				order o21=new order(c3,350,p7,"21");
				order o22=new order(c5,500,p8,"22");
				order o23=new order(c2,100,p8,"23");
				order o24=new order(c1,100,p8,"24");
				order o25=new order(c5,50,p9,"25");
				order o26=new order(c3,50,p9,"26");
				order o27=new order(c2,150,p9,"27");
				//customer a=new customer("eric","000000");
				//customer a1=new customer("ben el","000001");
				//customer a2=new customer("michal","000002");
				//customer a3=new customer("jordi","000003");
				//customer a4=new customer("static","000004");
				//product a5=pFactory.createProduct(2, "milk", 6, 10, 100, null, 1,"kl");
				//product a6=pFactory.createProduct(1, "chocolate", 4, 9, 20, null, null, 1);
				//product a7=pFactory.createProduct(1, "gum", 10, 12, 30, null, null, 1);
				//order a8=new order(a1,20,a5);
				//((storeProduct)a5).printInvoice(invoice.toCustomer);
				//((storeProduct)a5).printInvoice(invoice.toAccountant);
				s.addProduct(p1);
				s.addProduct(p2);
				s.addProduct(p3);
				s.addProduct(p4);
				s.addProduct(p5);
				s.addProduct(p6);
				s.addProduct(p7);
				s.addProduct(p8);
				s.addProduct(p9);
				updateOrder(o1.getProduct(),o1);
				updateOrder(o2.getProduct(),o2);
				updateOrder(o3.getProduct(),o3);
				updateOrder(o4.getProduct(),o4);
				updateOrder(o5.getProduct(),o5);
				updateOrder(o6.getProduct(),o6);
				updateOrder(o7.getProduct(),o7);
				updateOrder(o8.getProduct(),o8);
				updateOrder(o9.getProduct(),o9);
				updateOrder(o10.getProduct(),o10);
				updateOrder(o11.getProduct(),o11);
				updateOrder(o12.getProduct(),o12);
				updateOrder(o13.getProduct(),o13);
				updateOrder(o14.getProduct(),o14);
				updateOrder(o15.getProduct(),o15);
				updateOrder(o16.getProduct(),o16);
				updateOrder(o17.getProduct(),o17);
				updateOrder(o18.getProduct(),o18);
				updateOrder(o19.getProduct(),o19);
				updateOrder(o20.getProduct(),o20);
				updateOrder(o21.getProduct(),o21);
				updateOrder(o22.getProduct(),o22);
				updateOrder(o23.getProduct(),o23);
				updateOrder(o24.getProduct(),o24);
				updateOrder(o25.getProduct(),o25);
				updateOrder(o26.getProduct(),o26);
				updateOrder(o27.getProduct(),o27);
				//System.out.println(p6.selling_price);
				break;
			case 'b':
				do
				{
					System.out.println("Please Enter the catalog number (String) that you want to Add");
					catalogNum=scString.next();
				}while(s.productExists(catalogNum));
				
				
				System.out.println("Please choose the type of product Store Product-1 Website Product-2 Wholesalers Product-3");
				int type=sc.nextInt();
				product pnew=pFactory.createProductByUser(type, catalogNum);
				s.addProduct(pnew);
				break;
			case 'c':
			       s.deleteProduct(); //hashset of products.
	               break;
			case 'd':
			      s.updateStock(); //hashset of products.
	              break;
			case 'f':
				order o=s.addOrderToProduct();
				updateOrder(o.getProduct(),o);
				break;
			case 'g':
					undoUpdateOrder();
				
				break;
				
			case 'h':
				System.out.println("please enter product catalog number: ");
				cNum = scString.next();
				s.productByCatalogNum(cNum,observer);
				break;
			case 'i':
				System.out.println(s.toString());
				break;
			case 'j':
				System.out.println(s.toString());
				System.out.println("please enter product catalog number: ");
				cNum = scString.next();
				s.printOrdersByProduct(cNum);

				break;
			case 'k':
				saveStore(s);
				break;
			case 'l':
				//store newS=store.getInstance();
				undo(s);
				break;
			case 'e':
				going=false;
				break;
			case 'E':
				going=false;
				break;
			default:
				System.out.println("Wrong input try again");
				break;
			}
		
		}
	}
	public static void saveStore(store s) {
		storeMemento m=new storeMemento(s);
		stack.push(m);
		System.out.println(s);
	}

	public static void undo(store s) {
		if (!stack.isEmpty()) {
			storeMemento m=new storeMemento(null);
			s.setProducts(m.setMemento(stack.pop()));
			
			System.out.println(s);
		}
	}
	public static void updateOrder(product p ,order o) {
		Command cmd = new productUndoOrder(p, o);
		stackCommand.add(cmd);
	}

	public static void undoUpdateOrder() {
		if (!stackCommand.isEmpty()) {
			Command cmd = stackCommand.pop();
			cmd.undo();
		}
	}


}
