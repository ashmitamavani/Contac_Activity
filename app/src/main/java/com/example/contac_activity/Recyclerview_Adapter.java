package com.example.contac_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.Holder> {
    Show_Contact_Activity showContactActivity;
    ArrayList<Model_List> contactList;
    public Recyclerview_Adapter(Show_Contact_Activity showContactActivity, ArrayList<Model_List> contactList) {
        this.showContactActivity=showContactActivity;
        this.contactList=contactList;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(showContactActivity).inflate(R.layout.recyclerview_item_file,parent,false);
        Holder holder=new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.Holder holder, int position) {
        holder.item_name.setText(""+contactList.get(position).getName());
        holder.item_number.setText(""+contactList.get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView item_name,item_number;
        public Holder(@NonNull View itemView) {
            super(itemView);
            item_name=itemView.findViewById(R.id.item_name);
            item_number=itemView.findViewById(R.id.item_number);
        }
    }
}
