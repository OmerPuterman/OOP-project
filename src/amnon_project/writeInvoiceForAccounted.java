package amnon_project;

public class writeInvoiceForAccounted implements writableToInvoice {

	@Override
	public void writeInvoice(Invoice i) {
		product p=i.getProduct();
		String s=p.toString();
		s+="Profit on product "+p.getProfit()+"₪\n";
		System.out.println(s);
	}

}
