package com.carmudi.test.data.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Metadata{

	@SerializedName("product_count")
	private String productCount;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setProductCount(String productCount){
		this.productCount = productCount;
	}

	public String getProductCount(){
		return productCount;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"Metadata{" + 
			"product_count = '" + productCount + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}