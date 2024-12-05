package tests;

import java.util.LinkedList;
import java.util.PriorityQueue;

import classes.Containers;
import classes.ShippingPriorities;

public class StructureTests {

	public static void main(String[] args) {
		LinkedList<Containers> storageList = new LinkedList<Containers>();
		PriorityQueue<Containers> storagePriority = new PriorityQueue<Containers>(1000, new ShippingPriorities());
		
		Containers input1 = new Containers("Billy","Shanghai","oil","Kilos","no","small" , 5000);
		Containers input2 = new Containers("Mack","Lisbon","steel","pounds","no","medium" , 5000);
		Containers input3 = new Containers("Jim","New York City","oil","Kilos","no","large" , 9000);
		Containers input4 = new Containers("Mike","Shanghai","bananas","pounds","yes","small" , 3000);
		Containers input5 = new Containers("Sam","London","cars","Kilos","no","large" , 9200);
		Containers input6 = new Containers("Rob","Shanghai","clothes","Kilos","no","small" , 4000);
		
		storageList.add(input1);
		storageList.add(input2);
		storageList.add(input3);
		storageList.add(input4);
		storageList.add(input5);
		storageList.add(input6);
		
		storagePriority.add(input1);
		storagePriority.add(input2);
		storagePriority.add(input3);
		storagePriority.add(input4);
		storagePriority.add(input5);
		storagePriority.add(input6);
		
		sorting(storageList);
		
		for(int x = 0; x < storageList.size(); x++) {
			System.out.println(storageList.get(x));
		}
		System.out.println();
		while(!storagePriority.isEmpty()){
			System.out.println(storagePriority.poll());
		}
		
	}
		
		public static void sorting(LinkedList<Containers> storageList) {
			if(storageList == null || storageList.size() <= 1) {
				return;
			}
			for(int x = 1; x < storageList.size(); x++) {
				Containers val = storageList.get(x);
				int j = x - 1;
				
				while(j >= 0 && storageList.get(j).compareTo(val) > 0) {
					storageList.set(j + 1, storageList.get(j));
					j--;
				}
				
				storageList.set(j + 1, val);
			}

	}

}
