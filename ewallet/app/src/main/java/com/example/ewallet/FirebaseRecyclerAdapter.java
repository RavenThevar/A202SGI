package com.example.ewallet;

import com.google.firebase.database.DatabaseReference;

abstract class FirebaseRecyclerAdapter<T, T1> {
    public FirebaseRecyclerAdapter(Class<T> modelClass, int custom_list_item, Class<CustomeAdapter> customeAdapterClass, DatabaseReference reff) {
    }

    protected abstract void populateViewHolder(CustomeAdapter.ViewHolder viewHolder, Model model, int position);
}
