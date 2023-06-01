package manage_cafe.models;

import java.util.ArrayList;
import java.util.Objects;

public class Menu_Topping {
	private String topping;
	private double price;
	
	public Menu_Topping(String topping, double price) {
	
		this.topping = topping;
		this.price = price;
	}

	public Menu_Topping() {
		
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, topping);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu_Topping other = (Menu_Topping) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(topping, other.topping);
	}
	
	public static ArrayList<Menu_Topping> ListTopping(){
		String[] arr_topping = {
				"Machiato",
				"Caoacao pouder",
				"Matcha pouder",
				"Pudding"
		};
		
		double i = 0;
		ArrayList<Menu_Topping> topping = new ArrayList<Menu_Topping>();
		for(String name : arr_topping) {
			Menu_Topping Listtopping = new Menu_Topping(name, i);
			topping.add(Listtopping);
		}
		return topping;
	}
}
