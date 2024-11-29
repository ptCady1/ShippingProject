package classes;

import java.util.Objects;

public class Containers implements Comparable<Containers>{
	public String owner;
	public String Location;
	public String Material;
	public String weightClass;
	public String perishable;
	public String size;
	public int weight;
	
	//Default Container
	public Containers() {
		super();
	}
	//Set Container
	public Containers(String owner, String location, String material,String weightClass, String perishable, String size, int weight) {
		super();
		this.owner = owner;
		Location = location;
		Material = material;
		this.weightClass = weightClass;
		this.perishable = perishable;
		this.size = size;
		this.weight = weight;
	}
	
	//Getters and Setters
	public String getOwner() {
		return owner;
	}

	public void setSize(String size) {
		this.size = size;
	}
	public String getSize() {
		return size;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}
	public String getWeightClass() {
		return Material;
	}

	public void setWeightClass(String weightClass) {
		this.weightClass = weightClass;
	}

	public String isPerishable() {
		return perishable;
	}

	public void setPerishable(String perishable) {
		this.perishable = perishable;
	}
	public int weight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	//Seeing if weight exceeds limit
	public static String WeightLimit(int weight, String size, String weightClass) {
		int smallLimit = 60000;
		int medLimit = 58000;
		int largeLimit = 90000;
		int curWeight = totalWeight(weight, size, weightClass);
		if(weightClass == "Kilos") {
			weight = weight/1000;
		}
		if(size == "small") {
			if(curWeight > smallLimit)
			return "Over the weight limit";
		}
		else if(size == "medium") {
			if(curWeight > medLimit)
			return "Over the weight limit";
		}
		else if(size == "large") {
			if(curWeight > largeLimit)
			return "Over the weight limit";
		}
			return "Weight within limits.";
	}
	
	//Calculating total weight for container
	public static int totalWeight(int weight, String size, String weightClass) {
		int small = 4000;
		int med = 6000;
		int large = 9500;
		int total = 0;
		if(weightClass == "Kilos") {
			weight = weight * 2;
		}
		if(size == "small") {
			total = small + weight;
		}
		else if(size == "medium") {
			total = med + weight;
		}
		else if(size == "large") {
			total = large + weight;
		}
		if(weightClass == "Kilos") {
			total = total/2;
		}
		return total;
	}
	//Formating output
	public String Formating() {
		int curWeight = totalWeight(weight, size, weightClass);
		return "Container Owner: " + owner + " Destination: " + Location + " Material Contained: " + Material + " Container weight " + curWeight + " Material Perishable: " + perishable;
	}
	//Overrides for equals and has since custom object is used
	@Override
	public boolean equals(Object o ) {
        if (o == null) return false;
        if (o.getClass() != Containers.class) return false;
        Containers p = (Containers)o;
        if (p.owner != owner) return false;
        if (p.Location != Location) return false;
        if (p.Material != Material) return false;
        if (p.weightClass != weightClass) return false;
        if (p.perishable != perishable) return false;
        if (p.size != size) return false;
        if (p.weight != weight) return false;

        return true;
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(owner, Location, Material, weightClass, perishable, size, weight);
    }

	@Override
	public String toString() {
		return "Containers [owner=" + owner + ", Location=" + Location + ", Material=" + Material + ", weightClass="
				+ weightClass + ", perishable=" + perishable + ", size=" + size + ", weight=" + weight + "]";
	}
	//compareTo for insertionSort
	@Override
	public int compareTo(Containers c1) {
		return Integer.compare(this.weight, c1.weight);
	}
}
