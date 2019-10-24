package part4.ru.part4.fragments.MainNavigation;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import part4.ru.part4.R;
import part4.ru.part4.adapters.brands.BrandsAdapter;
import part4.ru.part4.api.PartAPI;
import part4.ru.part4.model.brands.BrandsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandsFragment extends Fragment {
    private List<BrandsResponse> brandsList;
    private RecyclerView mRecyclerView;
    private BrandsAdapter brandsAdapter;

    private Context context;

    public BrandsFragment(){
    }

    public static BrandsFragment newInstance() {
        return new BrandsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brands, container, false);

        context = view.getContext();
        brandsList = new ArrayList<>();

        mRecyclerView = view.findViewById(R.id.brandsRecyclerView);
        LinearLayoutManager layoutManager = new GridLayoutManager(view.getContext(),3);
        mRecyclerView.setLayoutManager(layoutManager);

        brandsAdapter = new BrandsAdapter(brandsList);
        mRecyclerView.setAdapter(brandsAdapter);

        final PartAPI partAPI = PartAPI.retrofit.create(PartAPI.class);
        final Call<List<BrandsResponse>> call = partAPI.getBrands();
        call.enqueue(new Callback<List<BrandsResponse>>() {
            @Override
            public void onResponse(Call<List<BrandsResponse>> call, Response<List<BrandsResponse>> response) {
                if (response.isSuccessful()) {
                    List<BrandsResponse> brands = response.body();
                    brandsList.addAll(brands);
                    mRecyclerView.getAdapter().notifyDataSetChanged();
                } else {
                    ResponseBody errorBody = response.errorBody();
                    try {
                        Toast.makeText(context, errorBody.string(),
                                Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<BrandsResponse>> call, Throwable t) {
                Toast.makeText(context, "Что-то пошло не так" + t,
                        Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
