package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity implements ProductsListener{
    TextView tvUsername;
    RecyclerView rvProducts;
    static ArrayList<Products> dataProduct = new ArrayList<>();
    static Calendar calendar = Calendar.getInstance();
    static String currentDate;
    static Integer userIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        userIndex = getIndex();
        initProduct(dataProduct);
        initView();
        ProductsAdapter productsAdapter = new ProductsAdapter(HomeActivity.this, dataProduct, HomeActivity.this);
        rvProducts.setAdapter(productsAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvProducts.setLayoutManager(manager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.head_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.redirect:
                Intent redirect = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(redirect);
                break;
            case R.id.history:
                Intent history = new Intent(HomeActivity.this, HistoryActivity.class);
                startActivity(history);
                break;
            case R.id.profile:
                Intent profile = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(profile);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void initView() {
        tvUsername = findViewById(R.id.tvUsername);
        rvProducts = findViewById(R.id.listView);
    }

    void initProduct(ArrayList<Products> dataProduct){
        dataProduct.add(new Products("Meja Persegi", 4, 500000, R.drawable.meja, ""));
        dataProduct.add(new Products("Kursi Biasa", 5, 350000, R.drawable.kursi, ""));
        dataProduct.add(new Products("Lemari Arsip", 4, 1150000, R.drawable.lemari, ""));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent;
        switch (position){
            case 0:
                intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra("detail", "meja");
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra("detail", "kursi");
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra("detail", "lemari");
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvUsername.setText(LoginActivity.userLog.userName);
    }

    Integer getIndex(){
        for (int i = 0; i < LoginActivity.userData.size(); i++) {
            if(LoginActivity.userLog.userEmail.equals(LoginActivity.userData.get(i).userEmail))
                return i;
        }
        return -1;
    }
}