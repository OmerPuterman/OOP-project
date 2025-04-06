package amnon_project;


public class Invoice {
	
	private static Invoice instance;
	private static Invoice instance2;
	private invoice invoiceType;
	private product product;
	public enum invoice {toCustomer, toAccountant};
	private Invoice(invoice invoiceType,product product)
	{
		this.invoiceType=invoiceType;
		this.product=product;
	}
	public static Invoice getInstance() {
		if (instance == null) {
            instance = new Invoice(invoice.toCustomer,null);
        }
        return instance;
	}
	public static Invoice getInstance2() {
		if (instance2 == null) {
            instance2 = new Invoice(invoice.toAccountant,null);
        }
        return instance2;
	}
	public product getProduct() {
		return this.product;
	}
	public void SetProduct(product p)
	{
		this.product=p;
	}
	public void printInvoice(writableToInvoice WTI)
	{
		WTI.writeInvoice(this);
	}

}
