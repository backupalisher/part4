package part4.ru.part4.adapters.models;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import part4.ru.part4.R;
import part4.ru.part4.SearchResultActivity;
import part4.ru.part4.model.models.ModelsResponse;

public class ModelsAdapter extends RecyclerView.Adapter<ModelsAdapter.ViewHolder> {
//    private static final String URL = "http://apin.part4.ru/image/models/";
    private List<ModelsResponse> modelsList;
//    private List<ModelsResponse> filterModelsList;
    private Context mContext;

    public ModelsAdapter(List<ModelsResponse> modelsResponseList) {
        this.modelsList = modelsResponseList;
    }

    @NonNull
    @Override
    public ModelsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.models_list, viewGroup, false);
        return new ModelsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelsAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.modelName.setText(modelsList.get(i).getName());
        viewHolder.modelsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, DeviceActivity.class);
                Intent intent = new Intent(mContext, SearchResultActivity.class);
                intent.putExtra("model_id", modelsList.get(i).getId());
                intent.putExtra("model_name", modelsList.get(i).getName());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (modelsList == null) {
            return 0;
        }
        return modelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout modelsLayout;
        TextView modelName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            modelsLayout = itemView.findViewById(R.id.modelsLayout);
            modelName = itemView.findViewById(R.id.modelNameTextView);
        }
    }

    public void setFilter(List<ModelsResponse> filterItems) {
        modelsList = new ArrayList<>();
        modelsList.addAll(filterItems);
        notifyDataSetChanged();
    }

//    public void filter(String text) {
//        filterModelsList.clear();
//        filterModelsList = new ArrayList<>();
//        if(text.isEmpty()){
//            filterModelsList.addAll(modelsList);
//        } else{
//            text = text.toLowerCase();
//            for(ModelsResponse item: modelsList){
//                if(item.getName().toLowerCase().contains(text)){
//                    filterModelsList.add(item);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }
}
