package com.circlenode.kppnpekanbaru;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AplikasiAdapter extends RecyclerView.Adapter<AplikasiAdapter.MyViewHolder> {


    Context context;
    List<Aplikasi> aplikasiList;
    public AplikasiAdapter(Context context, List<Aplikasi> aplikasiList){
        this.context = context;
        this.aplikasiList = aplikasiList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_web,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.namaAplikasi.setText(aplikasiList.get(position).getNamaAplikasi());
        holder.urlAplikasi.setText(aplikasiList.get(position).getUrlAplikasi());

    }

    @Override
    public int getItemCount() {
        return !aplikasiList.isEmpty()? aplikasiList.size():0 ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView circleImageView;
        TextView namaAplikasi,urlAplikasi;
        public MyViewHolder(View itemView) {
            super(itemView);
            circleImageView = (ImageView) itemView.findViewById(R.id.circleImageView);
            namaAplikasi = (TextView) itemView.findViewById(R.id.textView);
            urlAplikasi = (TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
