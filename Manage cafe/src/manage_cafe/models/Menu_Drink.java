package manage_cafe.models;

import java.util.ArrayList;
import java.util.Objects;

public class Menu_Drink {
	private String drink;
	private int id;
	private int cost;
	private static double price = 0;
	
	
	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
//	public static double getPrice() {
//		return price+= cost;
//	}
//
//	public static void setPrice(double price) {
//		Menu_Drink.price = price;
//	}

	public Menu_Drink(String drink, int id) {
		this.drink = drink;
		this.id = id;
	}
	
	public Menu_Drink() {
		
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(drink, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu_Drink other = (Menu_Drink) obj;
		return Objects.equals(drink, other.drink)
				&& Double.doubleToLongBits(id) == Double.doubleToLongBits(other.id);
	}
	
	public static ArrayList <Menu_Drink> getListDrink() {
		String[] arr_drink = {
				"Espresso",
				"Capuccino",
				"Cafe latte",
				"Vanilla latte",
				"Cafe americano",
				"Cafe chocolate",
				"Orange Juice",
				"Lavender",
				"Lemonadever",
				"Avocado smoothie",
				"Strawberry smoothi",
				"Meak tea",
				"Fruit tea",
				"Garlic tea",
		};
		
		ArrayList <Menu_Drink> listname = new ArrayList<Menu_Drink>();
		int i = 0;
		for(String name : arr_drink) {
			Menu_Drink namepr = new Menu_Drink(name, i);
			listname.add(namepr);
		}
		return listname;
	}
	
}
