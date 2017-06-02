package com.carmudi.test.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DA031CAAAKXJGINTCARID{

	@SerializedName("meta")
	private Meta meta;

	@SerializedName("attributes")
	private Attributes attributes;

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setAttributes(Attributes attributes){
		this.attributes = attributes;
	}

	public Attributes getAttributes(){
		return attributes;
	}

	@Override
 	public String toString(){
		return 
			"DA031CAAAKXJGINTCARID{" + 
			"meta = '" + meta + '\'' + 
			",attributes = '" + attributes + '\'' + 
			"}";
		}
}