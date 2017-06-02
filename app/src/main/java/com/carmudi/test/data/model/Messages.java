package com.carmudi.test.data.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Messages{

	@SerializedName("success")
	private List<String> success;

	public void setSuccess(List<String> success){
		this.success = success;
	}

	public List<String> getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"Messages{" + 
			"success = '" + success + '\'' + 
			"}";
		}
}