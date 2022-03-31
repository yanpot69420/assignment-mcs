package com.example.assignment1;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductsViewHolder extends RecyclerView.ViewHolder {
    public TextView tvName, tvPrice;
    public RatingBar tvRating;
    public ImageView ivImage;
    public ProductsViewHolder(@NonNull View itemView, ProductsListener productsListener) {
        super(itemView);
        tvName = itemView.findViewById(R.id.pName);
        tvRating = itemView.findViewById(R.id.pRating);
        tvPrice = itemView.findViewById(R.id.pPrice);
        ivImage = itemView.findViewById(R.id.pImage);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (productsListener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        productsListener.onItemClick(position);
                    }
                }
            }
        });
    }

}
