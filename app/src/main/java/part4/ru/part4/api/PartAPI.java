package part4.ru.part4.api;

import java.util.List;

import part4.ru.part4.model.brands.BrandsResponse;
import part4.ru.part4.model.models.ModelsResponse;
import part4.ru.part4.model.partcodes.PartcodesResponse;
import part4.ru.part4.model.search.SearchQuestion;
import part4.ru.part4.model.search.SearchResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PartAPI {

    @GET("brands")
    Call<List<BrandsResponse>> getBrands();

    @GET("models")
    Call<List<ModelsResponse>> getModels(@Query("brand_id") int index);

    @GET("partcodes")
    Call<List<PartcodesResponse>> getPartcodes(@Query("model") int model_id);

    @POST("search")
    Call<List<SearchResponse>> getSearchResponse(@Body SearchQuestion searchQuestion);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://apin.part4.ru:3000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
