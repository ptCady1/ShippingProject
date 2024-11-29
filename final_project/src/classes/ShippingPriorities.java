package classes;

import java.util.Comparator;


public class ShippingPriorities implements Comparator<Containers>{
	@Override
	public int compare(Containers c1, Containers c2) {
		//Setting the priority order for PriorityQueue
		String[] items = {"steel", "cars", "clothes"};
		int i = 0;
		if( c1.perishable == "yes") {
			i++;
		}
		if(c1.Location == "Shanghai") {
			i++;
		}
		for(int x = 0; x < items.length; x++) {
			if(c1.Material == items[x]) {
				i--;
				break;
			}
		}
		return i;
	}

}
