package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Plants{
	
	@Id
	private Integer plantId;
	private Integer plantHeight;
	private String plantName;
	private String plantBloomTime;
	private String plantUse;
	private String plantDiffLevel;
	private String plantTemp;
	private String plantType;
	private String plantDescription;
	private Integer plantStock;
	private Integer plantCost;
	
	public Plants() {
		// TODO Auto-generated constructor stub
	}

	public Plants(Integer plantId, Integer plantHeight, String plantName, String plantBloomTime, String plantUse,
			String plantDiffLevel, String plantTemp, String plantType, String plantDescription, Integer plantStock,
			Integer plantCost) {
		super();
		this.plantId = plantId;
		this.plantHeight = plantHeight;
		this.plantName = plantName;
		this.plantBloomTime = plantBloomTime;
		this.plantUse = plantUse;
		this.plantDiffLevel = plantDiffLevel;
		this.plantTemp = plantTemp;
		this.plantType = plantType;
		this.plantDescription = plantDescription;
		this.plantStock = plantStock;
		this.plantCost = plantCost;
	}

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public Integer getPlantHeight() {
		return plantHeight;
	}

	public void setPlantHeight(Integer plantHeight) {
		this.plantHeight = plantHeight;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantBloomTime() {
		return plantBloomTime;
	}

	public void setPlantBloomTime(String plantBloomTime) {
		this.plantBloomTime = plantBloomTime;
	}

	public String getPlantUse() {
		return plantUse;
	}

	public void setPlantUse(String plantUse) {
		this.plantUse = plantUse;
	}

	public String getPlantDiffLevel() {
		return plantDiffLevel;
	}

	public void setPlantDiffLevel(String plantDiffLevel) {
		this.plantDiffLevel = plantDiffLevel;
	}

	public String getPlantTemp() {
		return plantTemp;
	}

	public void setPlantTemp(String plantTemp) {
		this.plantTemp = plantTemp;
	}

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public Integer getPlantStock() {
		return plantStock;
	}

	public void setPlantStock(Integer plantStock) {
		this.plantStock = plantStock;
	}

	public Integer getPlantCost() {
		return plantCost;
	}

	public void setPlantCost(Integer plantCost) {
		this.plantCost = plantCost;
	}

	@Override
	public String toString() {
		return "Plants [plantId=" + plantId + ", plantHeight=" + plantHeight + ", plantName=" + plantName
				+ ", plantBloomTime=" + plantBloomTime + ", plantUse=" + plantUse + ", plantDiffLevel=" + plantDiffLevel
				+ ", plantTemp=" + plantTemp + ", plantType=" + plantType + ", plantDescription=" + plantDescription
				+ ", plantStock=" + plantStock + ", plantCost=" + plantCost + "]";
	}
	
	
	
}