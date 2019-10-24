package part4.ru.part4.model.partcodes;

import com.google.gson.annotations.SerializedName;

public class PartcodesResponse{

	@SerializedName("detail_name")
	private String detailName;

	@SerializedName("detail_name_ru")
	private String detailNameRu;

	@SerializedName("model_shceme")
	private String modelShceme;

	@SerializedName("model_image")
	private String modelImage;

	@SerializedName("module")
	private String module;

	@SerializedName("module_image")
	private String moduleImage;

	@SerializedName("partcode")
	private String partcode;

	@SerializedName("model")
	private String model;

	@SerializedName("partcodes_description")
	private String partcodesDescription;

	@SerializedName("detail_id")
	private String detailId;

	public void setDetailName(String detailName){
		this.detailName = detailName;
	}

	public String getDetailName(){
		return detailName;
	}

	public void setDetailNameRu(String detailNameRu){
		this.detailNameRu = detailNameRu;
	}

	public String getDetailNameRu(){
		return detailNameRu;
	}

	public void setModelShceme(String modelShceme){
		this.modelShceme = modelShceme;
	}

	public String getModelShceme(){
		return modelShceme;
	}

	public void setModelImage(String modelImage){
		this.modelImage = modelImage;
	}

	public String getModelImage(){
		return modelImage;
	}

	public void setModule(String module){
		this.module = module;
	}

	public String getModule(){
		return module;
	}

	public void setModuleImage(String moduleImage){
		this.moduleImage = moduleImage;
	}

	public String getModuleImage(){
		return moduleImage;
	}

	public void setPartcode(String partcode){
		this.partcode = partcode;
	}

	public String getPartcode(){
		return partcode;
	}

	public void setModel(String model){
		this.model = model;
	}

	public String getModel(){
		return model;
	}

	public void setPartcodesDescription(String partcodesDescription){
		this.partcodesDescription = partcodesDescription;
	}

	public String getPartcodesDescription(){
		return partcodesDescription;
	}

	public void setDetailId(String detailId){
		this.detailId = detailId;
	}

	public String getDetailId(){
		return detailId;
	}
}