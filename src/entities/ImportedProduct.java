package entities;

public class ImportedProduct extends Product{

	private Double customsFree;
	
	public ImportedProduct() {
	}

	public ImportedProduct(String name, Double price, Double customsFree) {
		super(name, price);
		this.customsFree = customsFree;
	}

	public Double getCustomsFree() {
		return customsFree;
	}

	public void setCustomsFree(Double customsFree) {
		this.customsFree = customsFree;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName() + " $ " + String.format("%.2f", totalPrice()) + " (Customs fee: $ " + customsFree + ")");
		return sb.toString();
	}
	
	public Double totalPrice() {
		return super.getPrice() + customsFree;
	}
	
	
}
