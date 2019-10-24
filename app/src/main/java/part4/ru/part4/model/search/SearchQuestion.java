package part4.ru.part4.model.search;

import com.google.gson.annotations.SerializedName;

public class SearchQuestion {
    @SerializedName("search_parameters")
    public String search_parameters;

    @SerializedName("sval")
    public String question;

    public void setSearch_parameters(String search_parameters) {
        this.search_parameters = search_parameters;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
