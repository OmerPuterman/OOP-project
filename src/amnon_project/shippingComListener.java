package amnon_project;

import amnon_project.ShippingCom.company;

public class shippingComListener implements Observer {
	private String msg;
	private ShippingCom s;
	public shippingComListener(String msg,ShippingCom s)
	{
		this.msg=msg;
		this.s=s;
	}

	@Override
	public void msg() {
		System.out.println(msg+" "+s.getCompanyType());
		
	}
	
}
