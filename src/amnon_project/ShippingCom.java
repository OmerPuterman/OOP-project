package amnon_project;

import amnon_project.ShippingCom.company;

public class ShippingCom {
		public enum delivery  {express, standart};
		public enum company {DHL, FedEx};
		protected delivery deliveryType;
		private company companyType;
		private String contact;
		private String whatsUpNumber;
		private int ShippingFees;

		public ShippingCom(delivery deliveryType, company companyType, String contact, String whatsUpNumber,
				int shippingFees) {
			this.deliveryType = deliveryType;
			this.companyType = companyType;
			this.contact = contact;
			this.whatsUpNumber = whatsUpNumber;
			ShippingFees = shippingFees;
		}
		public String toString()
		{
			String s="The shipping company is: "+this.companyType + " and type "+this.deliveryType+ " contact and whatsup Number "+ this.contact+ " " +this.whatsUpNumber;
			return s;
		}
		public delivery getDeliveryType() {
			return deliveryType;
		}

		public void setDeliveryType(delivery deliveryType) {
			this.deliveryType = deliveryType;
		}

		public company getCompanyType() {
			return companyType;
		}

		public void setCompanyType(company companyType) {
			this.companyType = companyType;
		}

		

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getWhatsUpNumber() {
			return whatsUpNumber;
		}

		public void setWhatsUpNumber(String whatsUpNumber) {
			this.whatsUpNumber = whatsUpNumber;
		}

		public int getShippingFees() {
			return ShippingFees;
		}

		public void setShippingFees(int shippingFees) {
			ShippingFees = shippingFees;
		}

		public double calcExpressShipping(product p) {
			
			double price = 0;
			
			if( this.getCompanyType() == company.DHL ) {
				price += 100 + websiteProduct.importTax;
			}else {
				price += 50*p.weight + websiteProduct.importTax;
			}
			
			return price;
		}
		
		public double calcStandartShipping(product p) {
			
			double price = 0;
			
			if(this.getCompanyType() == company.DHL ) {
				price += p.selling_price*(0.10);
				if(price>100)
					price = 100;
			}else {
				price += 10*p.weight;
			}
			
			return price;
		}

}
