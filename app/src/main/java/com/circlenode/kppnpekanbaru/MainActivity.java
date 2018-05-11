package com.circlenode.kppnpekanbaru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AplikasiAdapter aplikasiAdapter;
    public List<Aplikasi> aplikasiList;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rvAplikasi);
        aplikasiList = AplikasiData.getAplikasiList();
        Log.d(TAG, "onCreate: aplikasiList1 :" +aplikasiList.get(0).getNamaAplikasi());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        aplikasiAdapter = new AplikasiAdapter(this,aplikasiList);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDividerItemDecoration);
        loadData();


    }

    private void loadData() {
        recyclerView.setAdapter(aplikasiAdapter);

    }
}
