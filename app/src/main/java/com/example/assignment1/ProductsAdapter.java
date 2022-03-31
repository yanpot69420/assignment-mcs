package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProductsAdapter  extends RecyclerView.Adapter<ProductsViewHolder> {
    ProductsListener productsListener;
    Context context;
    ArrayList<Products> dataProducts;
    public ProductsAdapter(Context context, ArrayList<Products> dataProducts,  ProductsListener productsListener){
        this.context = context;
        this.dataProducts = dataProducts;
        this.productsListener = productsListener;
    }


    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        ProductsViewHolder viewHolder = new ProductsViewHolder(itemView, productsListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {

        String tvPname = dataProducts.get(position).productName;
        Integer tvPimage = dataProducts.get(position).productImage;
        Integer tvPrating = dataProducts.get(position).productRating;
        Integer tvPprice = dataProducts.get(position).productPrice;

        holder.tvName.setText(tvPname);
        holder.ivImage.setImageResource(tvPimage);
        holder.tvRating.setRating(tvPrating);
        holder.tvPrice.setText("Rp. "+tvPprice.toString());
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
