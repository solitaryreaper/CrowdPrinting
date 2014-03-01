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
	private int quality;
	private double max_b;
	private double max_w;
	private double max_h;
	private double resolution;
	
	public double getMax_b()
	{
		return max_b;
	}
	public void setMax_b(double max_b)
	{
		this.max_b = max_b;
	}
	public double getMax_w()
	{
		return max_w;
	}
	public void setMax_w(double max_w)
	{
		this.max_w = max_w;
	}
	public double getMax_h()
	{
		return max_h;
	}
	public void setMax_h(double max_h)
	{
		this.max_h = max_h;
	}
	public double getResolution()
	{
		return resolution;
	}
	public void setResolution(double resolution)
	{
		this.resolution = resolution;
	}
	
	public Printer(int id, String model, int quality, double max_b, double max_w,
			double max_h, double resolution)
	{
		super();
		this.id = id;
		this.model = model;
		this.quality = quality;
		this.max_b = max_b;
		this.max_w = max_w;
		this.max_h = max_h;
		this.resolution = resolution;
	}
	public Printer(int id, String model, int quality) {
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
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	
}
