package com.example.ewallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.ViewHolder>
{
    List<Model> list1;
    Context context;

    public CustomeAdapter(List<Model> list1, Context context)
    {
        this.list1 = list1;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.ViewHolder holder, int position)
    {
        Model model = list1.get(position);
        holder.trType.setText(model.getType());
        holder.trAccount.setText(model.getAccount());
        holder.trAmount.setText(model.getAmount());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView trType, trAccount, trAmount;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            trType = itemView.findViewById(R.id.trType);
            trAccount = itemView.findViewById(R.id.trAccount);
            trAmount = itemView.findViewById(R.id.trAmount);
        }
    }
}