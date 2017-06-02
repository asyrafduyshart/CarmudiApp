package com.carmudi.test.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Attributes{

	@SerializedName("drive_type")
	private String driveType;

	@SerializedName("all")
	private All all;

	@SerializedName("description")
	private String description;

	@SerializedName("price_conditions")
	private String priceConditions;

	@SerializedName("warranty_type")
	private String warrantyType;

	@SerializedName("seats")
	private String seats;

	@SerializedName("warranty_years")
	private String warrantyYears;

	@SerializedName("doors")
	private String doors;

	@SerializedName("color_family")
	private String colorFamily;

	@SerializedName("engine")
	private String engine;

	@SerializedName("year_built")
	private String yearBuilt;

	@SerializedName("price_conditions_id")
	private String priceConditionsId;

	@SerializedName("warranty_kms")
	private String warrantyKms;

	public void setDriveType(String driveType){
		this.driveType = driveType;
	}

	public String getDriveType(){
		return driveType;
	}

	public void setAll(All all){
		this.all = all;
	}

	public All getAll(){
		return all;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setPriceConditions(String priceConditions){
		this.priceConditions = priceConditions;
	}

	public String getPriceConditions(){
		return priceConditions;
	}

	public void setWarrantyType(String warrantyType){
		this.warrantyType = warrantyType;
	}

	public String getWarrantyType(){
		return warrantyType;
	}

	public void setSeats(String seats){
		this.seats = seats;
	}

	public String getSeats(){
		return seats;
	}

	public void setWarrantyYears(String warrantyYears){
		this.warrantyYears = warrantyYears;
	}

	public String getWarrantyYears(){
		return warrantyYears;
	}

	public void setDoors(String doors){
		this.doors = doors;
	}

	public String getDoors(){
		return doors;
	}

	public void setColorFamily(String colorFamily){
		this.colorFamily = colorFamily;
	}

	public String getColorFamily(){
		return colorFamily;
	}

	public void setEngine(String engine){
		this.engine = engine;
	}

	public String getEngine(){
		return engine;
	}

	public void setYearBuilt(String yearBuilt){
		this.yearBuilt = yearBuilt;
	}

	public String getYearBuilt(){
		return yearBuilt;
	}

	public void setPriceConditionsId(String priceConditionsId){
		this.priceConditionsId = priceConditionsId;
	}

	public String getPriceConditionsId(){
		return priceConditionsId;
	}

	public void setWarrantyKms(String warrantyKms){
		this.warrantyKms = warrantyKms;
	}

	public String getWarrantyKms(){
		return warrantyKms;
	}

	@Override
 	public String toString(){
		return 
			"Attributes{" + 
			"drive_type = '" + driveType + '\'' + 
			",all = '" + all + '\'' + 
			",description = '" + description + '\'' + 
			",price_conditions = '" + priceConditions + '\'' + 
			",warranty_type = '" + warrantyType + '\'' + 
			",seats = '" + seats + '\'' + 
			",warranty_years = '" + warrantyYears + '\'' + 
			",doors = '" + doors + '\'' + 
			",color_family = '" + colorFamily + '\'' + 
			",engine = '" + engine + '\'' + 
			",year_built = '" + yearBuilt + '\'' + 
			",price_conditions_id = '" + priceConditionsId + '\'' + 
			",warranty_kms = '" + warrantyKms + '\'' + 
			"}";
		}
}