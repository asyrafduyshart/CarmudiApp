package com.carmudi.test.data.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class OptionalItem{

	@SerializedName("name")
	private String name;

	@SerializedName("options")
	private List<String> options;

	@SerializedName("label")
	private String label;

	@SerializedName("label_en")
	private String labelEn;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setOptions(List<String> options){
		this.options = options;
	}

	public List<String> getOptions(){
		return options;
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

	@Override
 	public String toString(){
		return 
			"OptionalItem{" + 
			"name = '" + name + '\'' + 
			",options = '" + options + '\'' + 
			",label = '" + label + '\'' + 
			",label_en = '" + labelEn + '\'' + 
			"}";
		}
}