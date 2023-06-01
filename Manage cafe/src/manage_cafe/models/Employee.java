package manage_cafe.models;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Employee implements Comparable<Employee>{
	//Field
	protected String name;
	private int idcard;
	private Date daywork;
	private boolean sex;
	private String address;
	private String email;
	protected int id;
	protected Employee_position position;
	private boolean koj;
	private Employee_timeworking timeworking;
	private double salary;
	private Account account;
	private Account pass;
	
	public Employee() {

	}

	//Constructor
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdcard() {
		return idcard;
	}

	public void setIdcard(int idcard) {
		this.idcard = idcard;
	}

	public Date getDaywork() {
		return daywork;
	}

	public void setDaywork(Date daywork) {
		this.daywork = daywork;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee_position getPosition() {
		return position;
	}

	public void setPosition(Employee_position position) {
		this.position = position;
	}

	public boolean isKoj() {
		return koj;
	}

	public void setKoj(boolean koj) {
		this.koj = koj;
	}

	public Employee_timeworking getTimeworking() {
		return timeworking;
	}

	public void setTimeworking(Employee_timeworking timeworking) {
		this.timeworking = timeworking;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getPass() {
		return pass;
	}

	public void setPass(Account pass) {
		this.pass = pass;
	}

	@Override
	public int compareTo(Employee emp) {
		if(id < emp.getId()) {
			return -1;
		} else if(id == emp.getId()) {
			return
					name.compareTo(emp.getName());
		} else
		return 1;
	}
}
