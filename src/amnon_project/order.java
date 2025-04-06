package amnon_project;

public class order {
	private customer customer;
	private int ammount;
	private product product;
	private String catalogNum;
	public order(customer customer,int ammount,product product, String catalogNum)
	{
		this.customer=customer;
		this.ammount=ammount;
		this.product=product;
		this.catalogNum = catalogNum;
		product.addOrder(this);
	}

	public customer getCustomer() {
		return customer;
	}



	public void setCustomer(customer customer) {
		this.customer = customer;
	}



	public product getProduct() {
		return product;
	}



	public void setProduct(product product) {
		this.product = product;
	}



	public String getCatalogNum() {
		return catalogNum;
	}



	public void setCatalogNum(String catalogNum) {
		this.catalogNum = catalogNum;
	}



	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}



	public int getAmmount()
	{
		return this.ammount;
	}

	public void printOrder()
	{
		System.out.println("customer details - " + this.getCustomer().getName() + " " + this.getCustomer().getMobileNum());
		System.out.println("order catalog number - " + this.getCatalogNum());
		System.out.println("order ammount - " + this.getAmmount());
	}


}
