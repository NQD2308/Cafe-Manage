package manage_cafe.models;

public class Timesheets extends Employee{
	
	private Employee id;
	private Employee name;
	private Employee position;
	private int workinghour;
	private int dayoff;
	private double totalsalary;
	
	public Timesheets() {
		super();
	}

	public void setPosition(Employee position) {
		this.position = position;
	}

	public int getWorkinghour() {
		return workinghour;
	}

	public void setWorkinghour(int workinghour) {
		this.workinghour = workinghour;
	}

	public int getDayoff() {
		return dayoff;
	}

	public void setDayoff(int dayoff) {
		this.dayoff = dayoff;
	}

	public double getTotalsalary() {
		return totalsalary;
	}

	public void setTotalsalary(double totalsalary) {
		this.totalsalary = totalsalary;
	}
	
}
