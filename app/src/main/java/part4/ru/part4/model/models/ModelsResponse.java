package part4.ru.part4.model.models;

import com.google.gson.annotations.SerializedName;

public class ModelsResponse{

	@SerializedName("scheme_picture")
	private String schemePicture;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("picture")
	private String picture;

	public void setSchemePicture(String schemePicture){
		this.schemePicture = schemePicture;
	}

	public String getSchemePicture(){
		return schemePicture;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public String getPicture(){
		return picture;
	}
}