package com.carmudi.test.data.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class All{

	@SerializedName("details")
	private List<DetailsItem> details;

	@SerializedName("optional")
	private List<OptionalItem> optional;

	public void setDetails(List<DetailsItem> details){
		this.details = details;
	}

	public List<DetailsItem> getDetails(){
		return details;
	}

	public void setOptional(List<OptionalItem> optional){
		this.optional = optional;
	}

	public List<OptionalItem> getOptional(){
		return optional;
	}

	@Override
 	public String toString(){
		return 
			"All{" + 
			"details = '" + details + '\'' + 
			",optional = '" + optional + '\'' + 
			"}";
		}
}