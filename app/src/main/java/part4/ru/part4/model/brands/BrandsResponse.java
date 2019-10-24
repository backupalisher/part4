package part4.ru.part4.model.brands;

import com.google.gson.annotations.SerializedName;

public class BrandsResponse{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("logotype")
	private String logotype;

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

	public void setLogotype(String logotype){
		this.logotype = logotype;
	}

	public String getLogotype(){
		return logotype;
	}
}