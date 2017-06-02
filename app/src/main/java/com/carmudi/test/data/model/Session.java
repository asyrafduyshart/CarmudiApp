package com.carmudi.test.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Session{

	@SerializedName("expire")
	private String expire;

	@SerializedName("YII_CSRF_TOKEN")
	private String yIICSRFTOKEN;

	@SerializedName("id")
	private String id;

	public void setExpire(String expire){
		this.expire = expire;
	}

	public String getExpire(){
		return expire;
	}

	public void setYIICSRFTOKEN(String yIICSRFTOKEN){
		this.yIICSRFTOKEN = yIICSRFTOKEN;
	}

	public String getYIICSRFTOKEN(){
		return yIICSRFTOKEN;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Session{" + 
			"expire = '" + expire + '\'' + 
			",yII_CSRF_TOKEN = '" + yIICSRFTOKEN + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}