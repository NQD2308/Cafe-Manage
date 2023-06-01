package manage_cafe.models;

import java.util.ArrayList;
import java.util.Objects;

public class Employee_timeworking {
	private String time;

	public Employee_timeworking() {
		super();
	}

	public Employee_timeworking(String time) {
		super();
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee_timeworking other = (Employee_timeworking) obj;
		return Objects.equals(time, other.time);
	}
	
	public static ArrayList<Employee_timeworking> gettime(){
		String[] arr_time = { "7h - 15h",
				"15h - 23h",
				"9h - 14h",
				"13h - 18h",
				"18h - 23h"
		};
		ArrayList<Employee_timeworking> listtime = new ArrayList<Employee_timeworking>();
		for(String time : arr_time) {
			Employee_timeworking timelist = new Employee_timeworking(time);
			listtime.add(timelist);
		}
		return listtime;
	}

	public static Employee_timeworking gettimebyid(int timeworking) {
		return Employee_timeworking.gettime().get(timeworking);
	}
}
