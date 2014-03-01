package models;


public class Job {
	private int id;
	private String material;
	private String color;
	private int quantity;
	
	public Job(int id, String material, String color, int quantity) {
		super();
		this.id = id;
		this.material = material;
		this.color = color;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
