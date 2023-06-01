package manage_cafe.models;

import java.util.ArrayList;
import java.util.Objects;

public class Employee_position {
	private String position;

	public Employee_position(String position) {
		this.position = position;
	}
	
	public Employee_position() {

	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "Employee_position [position=" + position + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee_position other = (Employee_position) obj;
		return Objects.equals(position, other.position);
	}
	
	public static ArrayList <Employee_position> getposition() {
		String[] arr_position= { "Bảo vệ",
				"Phục vụ",
				"Pha chế",
				"Thu ngân",
				"Ca trưởng",
				"Quản lý"
		};
		
		ArrayList <Employee_position> listpos = new ArrayList <Employee_position>();
		for(String list : arr_position) {
			Employee_position listposs = new Employee_position(list);
			listpos.add(listposs);
		}
		return listpos;
	}

	public static Employee_position getposbyid(int position) {
		return Employee_position.getposition().get(position);
	} 
}
