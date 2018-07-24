package com.example.sreenureddy.srinuretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.sreenureddy.srinuretrofit.modelClasses.Category;

import java.util.List;

public class RaghuAdapter extends RecyclerView.Adapter<RaghuAdapter.RaghuViewHolder> {

    Context context;
  List<Category> categoryList;
    public RaghuAdapter(Context context,List<Category> categoryList)
    {
        this.context=context;
        this.categoryList=categoryList;
    }
    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }
    @Override
    public RaghuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_adapter,parent,false);
        return new RaghuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RaghuViewHolder holder, int position) {
        holder.tvMovieName.setText("Categeroy Name :  "+categoryList.get(position).catName);
       // Glide.with(context).load(categoryList.get(position).image).into(holder.image);
        //Loading image from url into imageView
        Glide.with(context)
                .load(categoryList.get(position).image)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class RaghuViewHolder extends RecyclerView.ViewHolder {

        TextView tvMovieName;
       ImageView image;

        public RaghuViewHolder(View itemView) {
            super(itemView);
            tvMovieName = (TextView) itemView.findViewById(R.id.title_movie);
            image = (ImageView)itemView.findViewById(R.id.image);

        }
    }
}
