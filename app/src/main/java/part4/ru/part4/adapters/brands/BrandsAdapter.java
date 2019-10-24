package part4.ru.part4.adapters.brands;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import part4.ru.part4.R;
import part4.ru.part4.model.brands.BrandsResponse;
import part4.ru.part4.ui.ModelsActivity;

public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.ViewHolder> {
    private static final String URL = "http://part4.ru/image/brands/";
    private List<BrandsResponse> brandsResponseList;
    private Context mContext;
    private static final int[] brand_icons = {R.drawable.brother, R.drawable.canon,
            R.drawable.epson, R.drawable.hp, R.drawable.kyocera, R.drawable.lexmark,
            R.drawable.oki, R.drawable.panasonic, R.drawable.ricoh, R.drawable.riso,
            R.drawable.samsung, R.drawable.sharp, R.drawable.toshiba, R.drawable.xerox, R.drawable.konica};

    public BrandsAdapter(List<BrandsResponse> brandsResponseList) {
        this.brandsResponseList = brandsResponseList;
    }

    @NonNull
    @Override
    public BrandsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.brands_list, viewGroup, false);
        return new BrandsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandsAdapter.ViewHolder viewHolder, int i) {
        final int index = i;
        Log.d("mLog", String.valueOf(brandsResponseList.get(index).getId()));
        Picasso.with(mContext)
//                .load(URL + brandsResponseList.get(index).getId())
                .load(brand_icons[i])
                .error(R.drawable.default_avatar)
                .placeholder(R.drawable.progress_animation)
//                .transform(new CircularTransformation(0))
                .into(viewHolder.brandIcon);
//        viewHolder.brandName.setText(brandsResponseList.get(i).getName());
        viewHolder.brandLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ModelsActivity.class);
                intent.putExtra("brand_id", brandsResponseList.get(index).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (brandsResponseList == null) {
            return 0;
        }
        return brandsResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView brandIcon;
//        TextView brandName;
        LinearLayout brandLinearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            brandIcon = itemView.findViewById(R.id.brandIconImageView);
//            brandName = itemView.findViewById(R.id.brandNameTextView);
            brandLinearLayout = itemView.findViewById(R.id.brand_layout);
        }
    }
}
