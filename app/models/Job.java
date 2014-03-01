package models;

import java.util.Date;

import models.Printer.PrintQuality;

public class Job {
	private int seekerId;
	private int materialId;
	private Date deadlineDate;
	private double minPrice;
	private double maxPrice;
	private String cadFilePath;
	private PrintQuality desiredQuality;
	private String desiredModelName;
	
	public Job(int seekerId, int materialId, Date deadlineDate,
			double minPrice, double maxPrice, String cadFilePath,
			PrintQuality desiredQuality, String desiredModelName) {
		super();
		this.seekerId = seekerId;
		this.materialId = materialId;
		this.deadlineDate = deadlineDate;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.cadFilePath = cadFilePath;
		this.desiredQuality = desiredQuality;
		this.desiredModelName = desiredModelName;
	}

	public int getSeekerId() {
		return seekerId;
	}

	public void setSeekerId(int seekerId) {
		this.seekerId = seekerId;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public Date getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getCadFilePath() {
		return cadFilePath;
	}

	public void setCadFilePath(String cadFilePath) {
		this.cadFilePath = cadFilePath;
	}

	public PrintQuality getDesiredQuality() {
		return desiredQuality;
	}

	public void setDesiredQuality(PrintQuality desiredQuality) {
		this.desiredQuality = desiredQuality;
	}

	public String getDesiredModelName() {
		return desiredModelName;
	}

	public void setDesiredModelName(String desiredModelName) {
		this.desiredModelName = desiredModelName;
	}
	
}
