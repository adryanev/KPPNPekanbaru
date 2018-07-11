package com.circlenode.kppnpekanbaru;

import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import saschpe.android.customtabs.CustomTabsHelper;
import saschpe.android.customtabs.WebViewFallback;

public class MainActivity extends AppCompatActivity {

    Utils utils;
    RecyclerView recyclerView;
    AplikasiAdapter aplikasiAdapter;
    public List<Aplikasi> aplikasiList;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_main);
        utils = new Utils(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.rvAplikasi);
        final CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .setToolbarColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null))
                .setShowTitle(true)
                .setCloseButtonIcon(utils.getBitmapFromVectorDrawable(R.drawable.ic_arrow_back_black_24dp))
                .setStartAnimations(this, R.anim.slide_in_right, R.anim.slide_out_left)
                .setExitAnimations(this, R.anim.slide_in_left, R.anim.slide_out_right)
                .build();
        CustomTabsHelper.addKeepAliveExtra(this, customTabsIntent.intent);
        aplikasiList = AplikasiData.getAplikasiList();
        recyclerView.setHasFixedSize(true);
        Log.d(TAG, "onCreate: aplikasiList1 :" + aplikasiList.get(0).getNamaAplikasi());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        aplikasiAdapter = new AplikasiAdapter(this, aplikasiList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String urlAplikasi = aplikasiList.get(position).getUrlAplikasi();
                if (URLUtil.isValidUrl(urlAplikasi)) {
                    Log.d("MainActivity", "Data Aplikasi: " + urlAplikasi);
                    Log.d("MainActivity", "Url is valid: " + String.valueOf(URLUtil.isValidUrl(urlAplikasi)));
                    CustomTabsHelper.openCustomTab(
                            MainActivity.this, customTabsIntent,
                            Uri.parse(urlAplikasi),
                            new WebViewFallback());

                } else {
                    boolean isInstalled = Utils.isInstalled("com.circlenode.adryanekavandra.kppn",getPackageManager() );

                    if(isInstalled){
                        Intent intent = getPackageManager().getLaunchIntentForPackage(urlAplikasi);
                        if (intent != null) {
                            startActivity(intent);
                        }
                    }else{
                        try{
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.circlenode.adryanekavandra.kppn")));
                        }
                        catch (android.content.ActivityNotFoundException e){
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.circlenode.adryanekavandra.kppn")));
                        }
                    }

                }
            }

        });
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDividerItemDecoration);
        loadData();


    }

    private void loadData() {
        recyclerView.setAdapter(aplikasiAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Integer id = item.getItemId();

            switch (id){
                case R.id.kontak:
                    Intent i = new Intent(this,Kontak.class);
                    startActivity(i);
                    break;
                case R.id.tentang:
                    Intent j = new Intent(this, Tentang.class);
                    startActivity(j);
                    break;
            }
        return super.onOptionsItemSelected(item);
    }
}
