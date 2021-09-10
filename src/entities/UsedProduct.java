package entities;

import java.util.Date;

public class UsedProduct extends Product{

	private Date date;
	
	public UsedProduct() {
	}

	public UsedProduct(String name, Double price, Date date) {
		super(name, price);
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName());
		sb.append(" (used) $ " + String.format("%.2f",super.getPrice()));
		sb.append(" (Manufacture date: " + Product.sdf.format(date) + ")");
		return sb.toString();
	}
	
	
}
