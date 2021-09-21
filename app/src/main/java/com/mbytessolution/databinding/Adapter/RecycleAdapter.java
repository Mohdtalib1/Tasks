package com.mbytessolution.databinding.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbytessolution.databinding.User;
import com.mbytessolution.databinding.databinding.SingleUserBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder> {

    private ArrayList<User> usersArrayList;

    public RecycleAdapter(ArrayList<User> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleUserBinding singleUserBinding = SingleUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RecycleViewHolder(singleUserBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {

        User user = usersArrayList.get(position);
        holder.singleUserBinding.setUser(user);
        holder.singleUserBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public static class RecycleViewHolder extends RecyclerView.ViewHolder {

        SingleUserBinding singleUserBinding;

        public RecycleViewHolder(@NonNull SingleUserBinding singleUserBinding) {
            super(singleUserBinding.getRoot());
            this.singleUserBinding = singleUserBinding;
        }
    }

}
