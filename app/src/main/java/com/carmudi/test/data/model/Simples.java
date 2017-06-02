package com.carmudi.test.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Simples{

	@SerializedName("DA031CAAAKXJGINTCARID")
	private DA031CAAAKXJGINTCARID dA031CAAAKXJGINTCARID;

	public void setDA031CAAAKXJGINTCARID(DA031CAAAKXJGINTCARID dA031CAAAKXJGINTCARID){
		this.dA031CAAAKXJGINTCARID = dA031CAAAKXJGINTCARID;
	}

	public DA031CAAAKXJGINTCARID getDA031CAAAKXJGINTCARID(){
		return dA031CAAAKXJGINTCARID;
	}

	@Override
 	public String toString(){
		return 
			"Simples{" + 
			"dA031CAAAKXJGINTCARID = '" + dA031CAAAKXJGINTCARID + '\'' + 
			"}";
		}
}