package models;

public class Item implements RuleSet{
	private int id;
	private int categoryId;
	private String name;
	private String unit;
	private int price;
	private int quantity;
	private int status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public void applyRules() throws RuleException {
		if(RuleSetFactory.isEmpty(name) || RuleSetFactory.isEmpty(String.valueOf(categoryId))|| RuleSetFactory.isEmpty(unit)
				||RuleSetFactory.isEmpty(String.valueOf(price)) || RuleSetFactory.isEmpty(String.valueOf(quantity))){
			throw new RuleException(" All fields must be non empty");

		}

	}
}
