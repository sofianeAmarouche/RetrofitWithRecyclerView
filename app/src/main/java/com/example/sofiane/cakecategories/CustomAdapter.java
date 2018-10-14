package com.example.sofiane.cakecategories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Sofiane on 10/12/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<RetroCakeDetail> dataList;
    private Context context;


    public CustomAdapter(List<RetroCakeDetail> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        CustomViewHolder holder =new CustomViewHolder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtDescription.setText(dataList.get(position).getDesc());
        Picasso.Builder builder = new Picasso.Builder(context);

        builder.downloader(new OkHttp3Downloader(context));

        builder.build().load(dataList.get(position).getImage())

                .placeholder((R.drawable.ic_launcher_background))

                .error(R.drawable.ic_launcher_background)

                .into(holder.cakeImage);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtDescription;
        private ImageView cakeImage;

        public CustomViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.cake_name);
            txtDescription = itemView.findViewById(R.id.cake_description);
            cakeImage = itemView.findViewById(R.id.cake_photo);
        }
    }
}
