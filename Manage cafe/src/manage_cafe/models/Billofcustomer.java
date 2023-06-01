package manage_cafe.models;

import java.util.Date;

public class Billofcustomer {
	private String address;
	private String hotline;
	private Date date;
	private Date time;
	private int code;
	private String namestf;
	private String product;
	private int quantities;
	private double cost;
	private double total;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHotline() {
		return hotline;
	}
	public void setHotline(String hotline) {
		this.hotline = hotline;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNamestf() {
		return namestf;
	}
	public void setNamestf(String namestf) {
		this.namestf = namestf;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantities() {
		return quantities;
	}
	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Billofcustomer() {
		super();
	}
	public Billofcustomer(String address, String hotline, Date date, Date time, int code, String namestf,
			String product, int quantities, double cost, double total) {
		super();
		this.address = address;
		this.hotline = hotline;
		this.date = date;
		this.time = time;
		this.code = code;
		this.namestf = namestf;
		this.product = product;
		this.quantities = quantities;
		this.cost = cost;
		this.total = total;
	}
}
