package models;

public class Printer {
	
	public enum PrintQuality {
		HIGH("high"),
		MEDIUM("medium"),
		LOW("low");
		
		private String quality;
		
		private PrintQuality(String quality)
		{
			this.quality = quality;
		}
	}
	
	private int id;
	private String model;
	private PrintQuality quality;
	public Printer(int id, String model, PrintQuality quality) {
		super();
		this.id = id;
		this.model = model;
		this.quality = quality;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public PrintQuality getQuality() {
		return quality;
	}
	public void setQuality(PrintQuality quality) {
		this.quality = quality;
	}
	
}
