package com.example.assignment1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;

public class HistoryViewHolder extends RecyclerView.ViewHolder {
    public TextView trId, trName, trQuant, trTprice;
    public ImageView trImage;
    public TextView trDate;
    public HistoryViewHolder(@NonNull View itemView) {
        super(itemView);

        trImage = itemView.findViewById(R.id.trImage);
        trId = itemView.findViewById(R.id.trID);
        trName = itemView.findViewById(R.id.trName);
        trQuant = itemView.findViewById(R.id.trQuant);
        trTprice = itemView.findViewById(R.id.trTprice);
        trDate = itemView.findViewById(R.id.trDate);
    }
}
