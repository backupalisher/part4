package part4.ru.part4;

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
import part4.ru.part4.adapters.partcodes.PartcodesAdapter;
import part4.ru.part4.api.PartAPI;
import part4.ru.part4.model.partcodes.PartcodesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private List<PartcodesResponse> partcodesList;
    private RecyclerView mRecyclerView;
    private PartcodesAdapter partcodesAdapter;

    private int model_id = 0;
    private int module_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        model_id = intent.getIntExtra("model_id", 0);
        module_id = intent.getIntExtra("module_id", 0);

        System.out.println(model_id + ", " + module_id);
        partcodesList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.resultsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        partcodesAdapter = new PartcodesAdapter(partcodesList);
        mRecyclerView.setAdapter(partcodesAdapter);

        final PartAPI partAPI = PartAPI.retrofit.create(PartAPI.class);
        final Call<List<PartcodesResponse>> call = partAPI.getPartcodes(model_id);
        call.enqueue(new Callback<List<PartcodesResponse>>() {
            @Override
            public void onResponse(Call<List<PartcodesResponse>> call, Response<List<PartcodesResponse>> response) {
                if (response.isSuccessful()) {
                    List<PartcodesResponse> partcodes = response.body();
                    partcodesList.addAll(partcodes);
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
            public void onFailure(Call<List<PartcodesResponse>> call, Throwable t) {
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
        List<PartcodesResponse> newList = new ArrayList<>();
        for (PartcodesResponse PItem : partcodesList) {
//                    String name = PItem.getName().toUpperCase();
            if (PItem.getPartcode().toLowerCase().contains(newText) || PItem.getDetailName().toLowerCase().contains(newText) || PItem.getModule().toLowerCase().contains(newText))
                newList.add(PItem);
        }
        if (partcodesAdapter != null) {
            partcodesAdapter.setFilter(newList);
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
