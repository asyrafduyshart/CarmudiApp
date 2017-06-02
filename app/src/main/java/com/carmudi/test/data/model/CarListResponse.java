package com.carmudi.test.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class CarListResponse{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("success")
	private boolean success;

	@SerializedName("session")
	private Session session;

	@SerializedName("messages")
	private Messages messages;

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Session getSession(){
		return session;
	}

	public void setMessages(Messages messages){
		this.messages = messages;
	}

	public Messages getMessages(){
		return messages;
	}

	@Override
 	public String toString(){
		return 
			"CarListResponse{" + 
			"metadata = '" + metadata + '\'' + 
			",success = '" + success + '\'' + 
			",session = '" + session + '\'' + 
			",messages = '" + messages + '\'' + 
			"}";
		}
}