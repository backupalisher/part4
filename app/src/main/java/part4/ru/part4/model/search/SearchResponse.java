package part4.ru.part4.model.search;

import com.google.gson.annotations.SerializedName;

public class SearchResponse {
    @SerializedName("code")
    private String code;

    @SerializedName("consumables")
    private boolean consumables;

    @SerializedName("link")
    private String link;

    @SerializedName("all_model_id")
    private int allModelId;

    @SerializedName("description")
    private String description;

    @SerializedName("priority")
    private int priority;

    @SerializedName("title")
    private String title;

    @SerializedName("picture")
    private String picture;

    @SerializedName("module_id")
    private int moduleId;

    @SerializedName("base_image")
    private String baseImage;

    @SerializedName("scheme_picture")
    private String schemePicture;

    @SerializedName("model_name")
    private String modelName;

    @SerializedName("name_ru")
    private String nameRu;

    @SerializedName("service_id")
    private int serviceId;

    @SerializedName("name")
    private String name;

    @SerializedName("analogs")
    private String analogs;

    @SerializedName("rank")
    private int rank;

    @SerializedName("id")
    private String id;

    @SerializedName("seo")
    private String seo;

    @SerializedName("partcode_id")
    private int partcodeId;

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setConsumables(boolean consumables){
        this.consumables = consumables;
    }

    public boolean isConsumables(){
        return consumables;
    }

    public void setLink(String link){
        this.link = link;
    }

    public String getLink(){
        return link;
    }

    public void setAllModelId(int allModelId){
        this.allModelId = allModelId;
    }

    public int getAllModelId(){
        return allModelId;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setPicture(String picture){
        this.picture = picture;
    }

    public String getPicture(){
        return picture;
    }

    public void setModuleId(int moduleId){
        this.moduleId = moduleId;
    }

    public int getModuleId(){
        return moduleId;
    }

    public void setBaseImage(String baseImage){
        this.baseImage = baseImage;
    }

    public String getBaseImage(){
        return baseImage;
    }

    public void setSchemePicture(String schemePicture){
        this.schemePicture = schemePicture;
    }

    public String getSchemePicture(){
        return schemePicture;
    }

    public void setModelName(String modelName){
        this.modelName = modelName;
    }

    public String getModelName(){
        return modelName;
    }

    public void setNameRu(String nameRu){
        this.nameRu = nameRu;
    }

    public String getNameRu(){
        return nameRu;
    }

    public void setServiceId(int serviceId){
        this.serviceId = serviceId;
    }

    public int getServiceId(){
        return serviceId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAnalogs(String analogs){
        this.analogs = analogs;
    }

    public String getAnalogs(){
        return analogs;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public int getRank(){
        return rank;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setSeo(String seo){
        this.seo = seo;
    }

    public String getSeo(){
        return seo;
    }

    public void setPartcodeId(int partcodeId){
        this.partcodeId = partcodeId;
    }

    public int getPartcodeId(){
        return partcodeId;
    }
}
