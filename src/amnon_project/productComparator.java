package amnon_project;

import java.util.Comparator;

public class productComparator implements Comparator<product>{

	@Override
	public int compare(product p1, product p2) {
		return p1.getCatalogNum().compareTo(p2.getCatalogNum());
	}

}
