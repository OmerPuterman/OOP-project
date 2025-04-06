package amnon_project;

import java.util.ArrayList;

public class storeMemento {
		private ArrayList<product>products;

		public storeMemento(store s) {
			this.products=new ArrayList<>();
			if (s!=null)
			{
				ArrayList<product>temp=s.getProducts();
				for (product p:temp)
				{
					products.add(p);
				}
			}
			
		}

	public ArrayList<product> setMemento(storeMemento m) {
		this.products=m.products;
		return this.products;
	}
}

