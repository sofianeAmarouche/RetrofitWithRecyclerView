package com.example.sofiane.cakecategories;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import network.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        GetCakeDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetCakeDataService.class);
        Call<List<RetroCakeDetail>> call = service.getAllCakeDetails();
        call.enqueue(new Callback<List<RetroCakeDetail>>() {
            @Override
            public void onResponse(Call<List<RetroCakeDetail>> call, Response<List<RetroCakeDetail>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroCakeDetail>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  void generateDataList(List<RetroCakeDetail> cakeList){
        recyclerView =(RecyclerView) findViewById(R.id.recycler_view);
        adapter = new CustomAdapter(cakeList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }
}
