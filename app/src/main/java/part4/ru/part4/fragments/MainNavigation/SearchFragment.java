package part4.ru.part4.fragments.MainNavigation;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import part4.ru.part4.R;
import part4.ru.part4.adapters.search.SearchAdapter;
import part4.ru.part4.api.PartAPI;
import part4.ru.part4.model.search.SearchQuestion;
import part4.ru.part4.model.search.SearchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {
    private List<SearchResponse> searchResponses;
    private RecyclerView recyclerView;
//    private StatefulRecyclerView statefulRecyclerView;
    private SearchAdapter searchAdapter;
    private Context context;
    private View view;
    private Parcelable listState;
    private LinearLayoutManager mLayoutManager;
    private static Bundle mBundleRecyclerViewState;
    ProgressBar progressBar;

    private EditText search_edit;
    private ImageButton search_button;

    private static final String LIST_STATE_KEY = "listState";

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);
        search_edit = view.findViewById(R.id.search_edit);
        search_button = view.findViewById(R.id.search_button);
        progressBar = view.findViewById(R.id.progressBar);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!search_edit.getText().equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    context = view.getContext();
                    searchResponses = new ArrayList<>();

                    recyclerView = view.findViewById(R.id.searchResponseRecyclerView);
//                LinearLayoutManager layoutManager = new GridLayoutManager(view.getContext(),3);
                    mLayoutManager = new LinearLayoutManager(context);
                    recyclerView.setLayoutManager(mLayoutManager);

                    searchAdapter = new SearchAdapter(searchResponses);
                    recyclerView.setAdapter(searchAdapter);

                    SearchQuestion searchQuestion = new SearchQuestion();
                    searchQuestion.setQuestion(search_edit.getText().toString());

                    final PartAPI partAPI = PartAPI.retrofit.create(PartAPI.class);
                    final Call<List<SearchResponse>> call = partAPI.getSearchResponse(searchQuestion);
                    call.enqueue(new Callback<List<SearchResponse>>() {
                        @Override
                        public void onResponse(Call<List<SearchResponse>> call, Response<List<SearchResponse>> response) {
                            if (response.isSuccessful()) {
                                List<SearchResponse> search = response.body();
                                searchResponses.addAll(search);
                                recyclerView.getAdapter().notifyDataSetChanged();
                                progressBar.setVisibility(View.GONE);
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
                        public void onFailure(Call<List<SearchResponse>> call, Throwable t) {
                            Toast.makeText(context, "Что-то пошло не так: " + t,
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return view;
    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        listState = mLayoutManager.onSaveInstanceState();
//        outState.putParcelable(LIST_STATE_KEY, listState);
//        Log.d("mLog", "Saved: " + LIST_STATE_KEY + listState);
//        super.onSaveInstanceState(outState);
//    }
////
//    @Override
//    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
//        if (savedInstanceState != null){
//            listState = savedInstanceState.getParcelable(LIST_STATE_KEY);
//            mLayoutManager.onRestoreInstanceState(listState);
//            Log.d("mLog", "Restored: " + LIST_STATE_KEY + listState);
//        }
//        super.onViewStateRestored(savedInstanceState);
//    }


//    @Override
//    public void onResume() {
//        super.onResume();
//
//        if (mBundleRecyclerViewState != null) {
//            listState = mBundleRecyclerViewState.getParcelable(LIST_STATE_KEY);
//            mLayoutManager.onRestoreInstanceState(listState);
//            Log.d("mLog", "Restored: " + LIST_STATE_KEY + listState);
////            listState = mBundleRecyclerViewState.getParcelable(LIST_STATE_KEY);
////            Log.d("mLog", "Restored: " + LIST_STATE_KEY + listState);
////            recyclerView.getLayoutManager().onRestoreInstanceState(listState);
//        }
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//
//        mBundleRecyclerViewState = new Bundle();
//        listState = mLayoutManager.onSaveInstanceState();
//        mBundleRecyclerViewState.putParcelable(LIST_STATE_KEY, listState);
//
//        Log.d("mLog", "Saved: " + LIST_STATE_KEY + listState);
//
////        mBundleRecyclerViewState = new Bundle();
////        listState = recyclerView.getLayoutManager().onSaveInstanceState();
////        mBundleRecyclerViewState.putParcelable(LIST_STATE_KEY, listState);
////        Log.d("mLog", "Saved: " + LIST_STATE_KEY + listState);
//    }
}
