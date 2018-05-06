package com.example.crash.parcial;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    private Context mContext;
    private List<Contact> mData;

    public RecyclerViewAdapter(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_contact,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {

        holder.contact_name.setText(mData.get(position).getName());
        holder.contact_image.setImageResource(mData.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,contact_activity.class);
                intent.putExtra("name",mData.get(position).getName());
                intent.putExtra("lastname",mData.get(position).getLastName());
                intent.putExtra("phone",mData.get(position).getPhone());
                intent.putExtra("email",mData.get(position).getEmail());
                intent.putExtra("address",mData.get(position).getAddress());
                intent.putExtra("image",mData.get(position).getImage());
                intent.putExtra("birthdate",mData.get(position).getBirthDate());
                intent.putExtra("id",mData.get(position).getId());

                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        TextView contact_name;
        ImageView contact_image;
        CardView cardView;

        public myViewHolder(View itemView) {
            super(itemView);

            contact_name = (TextView) itemView.findViewById(R.id.contact_name);
            contact_image = (ImageView) itemView.findViewById(R.id.contact_image);
            cardView = (CardView) itemView.findViewById(R.id.cardview);

        }
    }

    public void setFilter(ArrayList<Contact> newList) {

        mData = new ArrayList<>();
        mData.addAll(newList);
        notifyDataSetChanged();

    }

}
