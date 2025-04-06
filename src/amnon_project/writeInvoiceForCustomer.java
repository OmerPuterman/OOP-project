package amnon_project;

public class writeInvoiceForCustomer implements writableToInvoice{

	@Override
	public void writeInvoice(Invoice i) {
		product p=i.getProduct();
		String s=p.toString();
		s+="tax 17% "+p.getTax()+"\n";
		System.out.println(s);
	}

}
