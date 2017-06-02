package com.carmudi.test.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Meta{

	@SerializedName("original_price")
	private String originalPrice;

	@SerializedName("original_price_currency")
	private String originalPriceCurrency;

	@SerializedName("price")
	private String price;

	@SerializedName("price_conditions_position")
	private String priceConditionsPosition;

	@SerializedName("price_not_available")
	private String priceNotAvailable;

	@SerializedName("sku")
	private String sku;

	@SerializedName("price_conditions_id")
	private String priceConditionsId;

	public void setOriginalPrice(String originalPrice){
		this.originalPrice = originalPrice;
	}

	public String getOriginalPrice(){
		return originalPrice;
	}

	public void setOriginalPriceCurrency(String originalPriceCurrency){
		this.originalPriceCurrency = originalPriceCurrency;
	}

	public String getOriginalPriceCurrency(){
		return originalPriceCurrency;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setPriceConditionsPosition(String priceConditionsPosition){
		this.priceConditionsPosition = priceConditionsPosition;
	}

	public String getPriceConditionsPosition(){
		return priceConditionsPosition;
	}

	public void setPriceNotAvailable(String priceNotAvailable){
		this.priceNotAvailable = priceNotAvailable;
	}

	public String getPriceNotAvailable(){
		return priceNotAvailable;
	}

	public void setSku(String sku){
		this.sku = sku;
	}

	public String getSku(){
		return sku;
	}

	public void setPriceConditionsId(String priceConditionsId){
		this.priceConditionsId = priceConditionsId;
	}

	public String getPriceConditionsId(){
		return priceConditionsId;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"original_price = '" + originalPrice + '\'' + 
			",original_price_currency = '" + originalPriceCurrency + '\'' + 
			",price = '" + price + '\'' + 
			",price_conditions_position = '" + priceConditionsPosition + '\'' + 
			",price_not_available = '" + priceNotAvailable + '\'' + 
			",sku = '" + sku + '\'' + 
			",price_conditions_id = '" + priceConditionsId + '\'' + 
			"}";
		}
}