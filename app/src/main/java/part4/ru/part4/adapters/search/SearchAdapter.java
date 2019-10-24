package part4.ru.part4.adapters.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import part4.ru.part4.R;
import part4.ru.part4.model.search.SearchResponse;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<SearchResponse> searchResponses;
    private Context context;

    public SearchAdapter(List<SearchResponse> searchResponses) {
        this.searchResponses = searchResponses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.search_list, viewGroup, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nameTextView.setText(searchResponses.get(i).getName());
        viewHolder.codeTextView.setText(searchResponses.get(i).getCode());
        viewHolder.modelNameTextView.setText(searchResponses.get(i).getModelName());
    }

    @Override
    public int getItemCount() {
        return searchResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView codeTextView;
        TextView modelNameTextView;
        LinearLayout searchLinearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            codeTextView = itemView.findViewById(R.id.codeTextView);
            modelNameTextView = itemView.findViewById(R.id.modelNameTextView);
            searchLinearLayout = itemView.findViewById(R.id.search_layout);
        }
    }
}
