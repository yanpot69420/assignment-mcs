package com.example.assignment1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DetailActivity extends AppCompatActivity {
    TextView tvQuant;
    Button btnDec, btnInc, btnBuy;
    Integer number=0;
    TextView tvPdName, tvPdPrice;
    ImageView ivPdImage;
    RatingBar rbPdRating;
    Historys buyDetail = new Historys();
    Products meja = new Products();
    Products kursi = new Products();
    Products lemari = new Products();
    Integer refImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        String detail = getIntent().getStringExtra("detail");
        meja = HomeActivity.dataProduct.get(0);
        kursi = HomeActivity.dataProduct.get(1);
        lemari = HomeActivity.dataProduct.get(2);
        switch (detail){
            case "meja":
                tvPdName.setText(meja.productName);
                ivPdImage.setImageResource(meja.productImage);
                tvPdPrice.setText(meja.productPrice.toString());
                rbPdRating.setRating(meja.productRating);
                refImage = R.drawable.meja;
                break;
            case "kursi":
                tvPdName.setText(kursi.productName);
                ivPdImage.setImageResource(kursi.productImage);
                tvPdPrice.setText(kursi.productPrice.toString());
                rbPdRating.setRating(kursi.productRating);
                refImage = R.drawable.kursi;
                break;
            case "lemari":
                tvPdName.setText(lemari.productName);
                ivPdImage.setImageResource(lemari.productImage);
                tvPdPrice.setText(lemari.productPrice.toString());
                rbPdRating.setRating(lemari.productRating);
                refImage = R.drawable.lemari;
                break;
        }

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number>0)
                    number--;
                tvQuant.setText(number.toString());
            }
        });
        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                tvQuant.setText(number.toString());
            }
        });
        String dtGen = genId();
        String dtName = tvPdName.getText().toString();
        Integer dtPrice = Integer.valueOf(tvPdPrice.getText().toString());
        Integer dtImage = refImage;
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number==0)
                    Toast.makeText(DetailActivity.this, "Quantity must be greater than 0", Toast.LENGTH_SHORT).show();
                else {
                    Integer quantity = number;
                    buyDetail = new Historys(dtImage, dtGen, dtName, quantity, quantity*dtPrice, HomeActivity.currentDate);
                    AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
                    builder.setMessage("Press Yes to buy this item")
                            .setCancelable(true)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    LoginActivity.userData.get(HomeActivity.userIndex).userTransaction.add(new Historys(buyDetail));
                                    Toast.makeText(DetailActivity.this, "Detail added to transaction", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            })
                            .show();
                }
            }
        });
    }

    void initView() {
        tvQuant = findViewById(R.id.tvQty);
        btnDec = findViewById(R.id.btnDec);
        btnInc = findViewById(R.id.btnInc);
        btnBuy = findViewById(R.id.btnPur);
        tvPdName = findViewById(R.id.tvPdName);
        ivPdImage = findViewById(R.id.ivPdImage);
        tvPdPrice = findViewById(R.id.tvPdPrice);
        rbPdRating = findViewById(R.id.rbPdRating);
    }

    String genId(){
        Random rand = new Random();
        String id = "TR" + rand.nextInt(9) + "" + rand.nextInt(9)+""+ rand.nextInt(9);
        return id;
    }
}