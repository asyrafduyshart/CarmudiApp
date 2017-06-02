package com.carmudi.test.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DetailsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("label")
	private String label;

	@SerializedName("label_en")
	private String labelEn;

	@SerializedName("value")
	private String value;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setLabelEn(String labelEn){
		this.labelEn = labelEn;
	}

	public String getLabelEn(){
		return labelEn;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"DetailsItem{" + 
			"name = '" + name + '\'' + 
			",label = '" + label + '\'' + 
			",label_en = '" + labelEn + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}