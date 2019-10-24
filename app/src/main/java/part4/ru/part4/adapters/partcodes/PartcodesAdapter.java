package part4.ru.part4.adapters.partcodes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import part4.ru.part4.R;
import part4.ru.part4.model.partcodes.PartcodesResponse;

public class PartcodesAdapter extends RecyclerView.Adapter<PartcodesAdapter.ViewHolder>{
    private List<PartcodesResponse> partcodesList;
    private Context mContext;

    public PartcodesAdapter(List<PartcodesResponse> partcodesResponseList){
        this.partcodesList = partcodesResponseList;
    }

    @NonNull
    @Override
    public PartcodesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.partcodes_list, viewGroup, false);
        return new PartcodesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartcodesAdapter.ViewHolder viewHolder, int i) {
        viewHolder.detailNameTextView.setText(partcodesList.get(i).getDetailName());
        viewHolder.detailNameRuTextView.setText(partcodesList.get(i).getDetailNameRu());
        viewHolder.partcodeTextView.setText(partcodesList.get(i).getPartcode());
        viewHolder.modelNameTextView.setText(partcodesList.get(i).getModel());
        viewHolder.moduleNameTextView.setText(partcodesList.get(i).getModule());
    }

    @Override
    public int getItemCount() {
        return partcodesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView detailNameTextView,detailNameRuTextView, partcodeTextView, modelNameTextView, moduleNameTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            detailNameTextView = itemView.findViewById(R.id.detailNameTextView);
            detailNameRuTextView = itemView.findViewById(R.id.detailNameRuTextView);
            partcodeTextView = itemView.findViewById(R.id.partcodeTextView);
            modelNameTextView = itemView.findViewById(R.id.model_name);
            moduleNameTextView = itemView.findViewById(R.id.moduleNameTextView);
        }
    }

    public void setFilter(List<PartcodesResponse> filterItems) {
        partcodesList = new ArrayList<>();
        partcodesList.addAll(filterItems);
        notifyDataSetChanged();
    }
}
