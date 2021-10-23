package com.example.rewechat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class adaptervieww extends RecyclerView.Adapter <adaptervieww.MyViewHolder>{
    private View itemView;
    private Context context;
    private List<Map<String,Object>> data;
    private AdapterView.OnItemClickListener onItemClickListener;

    public adaptervieww(List<Map<String,Object>> data, Context context){
        this.context=context;
        this.data=data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(itemView);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView1.setText(data.get(position).get("PRODUCT").toString());
        holder.textView2.setText(data.get(position).get("PRICE").toString());
        holder.textView3.setText(data.get(position).get("CONFIGURATION").toString());
        holder.imageView.setImageResource(Integer.parseInt(data.get(position).get("PNG").toString()));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textview);
            textView2 = itemView.findViewById(R.id.textview1);
            textView3 = itemView.findViewById(R.id.textview2);
            imageView = itemView.findViewById(R.id.imageView5);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    switch(position) {
                        case 0:
                            Intent intent = new Intent(itemView.getContext(), greyson.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            Intent intent1=new Intent(itemView.getContext(),whydontwe.class);
                            context.startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2=new Intent(itemView.getContext(),bbno.class);
                            context.startActivity(intent2);
                            break;
                        case 3:
                            Intent intent3=new Intent(itemView.getContext(),girl.class);
                            context.startActivity(intent3);
                            break;
                        case 4:
                            Intent intent4=new Intent(itemView.getContext(),casper.class);
                            context.startActivity(intent4);
                            break;
                    }
                }
            });

        }
    }



}
