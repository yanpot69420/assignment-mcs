package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> {
    Context context;
    ArrayList<Historys> historyTransaction;

    public  HistoryAdapter(Context context, ArrayList<Historys> historyTransaction){
        this.context = context;
        this.historyTransaction = historyTransaction;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.transact, parent, false);
        HistoryViewHolder viewHolder = new HistoryViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        Integer tvHimage = historyTransaction.get(position).productImage;
        String tvHid = historyTransaction.get(position).hsId;
        String tvHname = historyTransaction.get(position).productName;
        Integer tvHquant = historyTransaction.get(position).hsQuant;
        Integer tvHtprice = historyTransaction.get(position).hsTprice;
        String tvHdate = historyTransaction.get(position).hsDate;

        holder.trImage.setImageResource(tvHimage);
        holder.trId.setText(tvHid.toString());
        holder.trName.setText("Product: "+tvHname.toString());
        holder.trQuant.setText("Quantity: "+tvHquant.toString());
        holder.trTprice.setText("Total Price: Rp. "+tvHtprice.toString());
        holder.trDate.setText("Date: "+tvHdate.toString());
    }

    @Override
    public int getItemCount() {
        return this.historyTransaction.size();
    }
}
