package com.example.freefood.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freefood.R;
import com.example.freefood.classes.DataProduct;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class AdapterHistoryAdapter extends RecyclerView.Adapter<AdapterHistoryAdapter.ViewHolder>{

    Context context;
    ArrayList<DataProduct> products;



    public AdapterHistoryAdapter(Context context, ArrayList<DataProduct> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHistoryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        DataProduct product = products.get(position);

        holder.textViewProteins.setText(String.valueOf(product.getProteins()) + " бел");
        holder.textViewFats.setText(String.valueOf(product.getFats()) + " жир");
        holder.textViewCarb.setText(String.valueOf(product.getCarb()) + " углевод");
        holder.textViewCal.setText(String.valueOf(product.getCal()) + " кал");
        holder.textViewGram.setText(String.valueOf(product.getGram()) + " грамм");
    }
    @Override
    public int getItemCount() {
        return products.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewProteins, textViewFats, textViewCarb, textViewCal, textViewGram;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProteins = itemView.findViewById(R.id.textViewProteins);
            textViewFats = itemView.findViewById(R.id.textViewFats);
            textViewCarb = itemView.findViewById(R.id.textViewCarb);
            textViewCal = itemView.findViewById(R.id.textViewCal);
            textViewGram = itemView.findViewById(R.id.textViewGram);
        }
    }
}
