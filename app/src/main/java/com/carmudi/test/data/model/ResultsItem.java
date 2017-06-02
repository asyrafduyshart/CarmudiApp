package com.carmudi.test.data.model;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResultsItem{

	@SerializedName("images")
	private List<ImagesItem> images;

	@SerializedName("data")
	private Data data;

	@SerializedName("id")
	private String id;

	public void setImages(List<ImagesItem> images){
		this.images = images;
	}

	public List<ImagesItem> getImages(){
		return images;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
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
			"ResultsItem{" + 
			"images = '" + images + '\'' + 
			",data = '" + data + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}