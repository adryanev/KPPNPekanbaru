package com.circlenode.kppnpekanbaru;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import saschpe.android.customtabs.CustomTabsHelper;

public class AplikasiAdapter extends RecyclerView.Adapter<AplikasiAdapter.MyViewHolder> {

RecyclerView mRecyclerView;
    CustomItemClickListener listener;
    Context context;
    List<Aplikasi> aplikasiList;
    Utils utils;
    public AplikasiAdapter(Context context, List<Aplikasi> aplikasiList,CustomItemClickListener listener){
        this.context = context;
        this.aplikasiList = aplikasiList;
        utils = new Utils(context);
        this.listener = listener;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_web,parent,false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, myViewHolder.getLayoutPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        int productImageId = context.getResources().getIdentifier(
                aplikasiList.get(position).getGambarAplikasi(), "drawable", context.getPackageName());

        Picasso.with(context).load(productImageId).noFade().into(holder.circleImageView);
        holder.namaAplikasi.setText(aplikasiList.get(position).getNamaAplikasi());

    }

    @Override
    public int getItemCount() {
        return !aplikasiList.isEmpty()? aplikasiList.size():0 ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView circleImageView;
        TextView namaAplikasi;
        public MyViewHolder(View itemView) {
            super(itemView);
            circleImageView = (ImageView) itemView.findViewById(R.id.circleImageView);
            namaAplikasi = (TextView) itemView.findViewById(R.id.textView);

        }

    }
}
