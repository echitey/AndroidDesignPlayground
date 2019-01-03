package com.echitey.designcheatsheet.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.echitey.designcheatsheet.R;
import com.echitey.designcheatsheet.model.DashModel;

import java.util.ArrayList;

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.ViewHolder> {

    private ArrayList<DashModel> dashModelArrayList;

    public DashAdapter(ArrayList<DashModel> dashModelArrayList){
        this.dashModelArrayList = dashModelArrayList;
    }

    @NonNull
    @Override
    public DashAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashAdapter.ViewHolder holder, int position) {

        String menu_header = dashModelArrayList.get(position).getHead();
        holder.setHead(menu_header);

        String sub_header = dashModelArrayList.get(position).getSub();
        holder.setSubHead(sub_header);

        int image = dashModelArrayList.get(position).getImage();
        holder.setImage(image);
    }

    @Override
    public int getItemCount() {
        return dashModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView head, sub;
        ImageView img;
        View myView;

        public ViewHolder(View view) {
            super(view);
            myView = view;
        }

        public void setHead(String h){
            head = myView.findViewById(R.id.header);
            head.setText(h);
        }

        public void setSubHead(String s){
            sub = myView.findViewById(R.id.sub_header);
            sub.setText(s);
        }

        public void setImage(int i){
            img = myView.findViewById(R.id.dashImage);
            img.setImageResource(i);
        }
    }
}
