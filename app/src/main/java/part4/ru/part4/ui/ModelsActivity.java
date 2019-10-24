package part4.ru.part4.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import part4.ru.part4.R;
import part4.ru.part4.adapters.models.ModelsAdapter;
import part4.ru.part4.api.PartAPI;
import part4.ru.part4.model.models.ModelsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelsActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<ModelsResponse> modelsList;
    private RecyclerView mRecyclerView;
    private ModelsAdapter modelsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_models);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        final int brand_id = intent.getIntExtra("brand_id",0);

        modelsList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.modelsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        modelsAdapter = new ModelsAdapter(modelsList);
        mRecyclerView.setAdapter(modelsAdapter);

        final PartAPI partAPI = PartAPI.retrofit.create(PartAPI.class);
        final Call<List<ModelsResponse>> call = partAPI.getModels(brand_id);
        call.enqueue(new Callback<List<ModelsResponse>>() {
            @Override
            public void onResponse(Call<List<ModelsResponse>> call, Response<List<ModelsResponse>> response) {
                if (response.isSuccessful()) {
                    List<ModelsResponse> models = response.body();
                    modelsList.addAll(models);
                    mRecyclerView.getAdapter().notifyDataSetChanged();
                } else {
                    ResponseBody errorBody = response.errorBody();
                    try {
                        Toast.makeText(getApplicationContext(), errorBody.string(),
                                Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelsResponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Что-то пошло не так" + t,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);

        final MenuItem menuItem = menu.findItem(R.id.search_menu);
        final SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Поиск");
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        List<ModelsResponse> newList = new ArrayList<>();
        for (ModelsResponse PItem : modelsList) {
//                    String name = PItem.getName().toUpperCase();
            if (PItem.getName().toLowerCase().contains(newText))
                newList.add(PItem);
        }
        if (modelsAdapter != null) {
            modelsAdapter.setFilter(newList);
        }
//                modelsAdapter.filter(newText);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
