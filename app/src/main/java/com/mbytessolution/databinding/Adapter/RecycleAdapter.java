package com.mbytessolution.databinding.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbytessolution.databinding.User;
import com.mbytessolution.databinding.databinding.SingleUserBinding;
import com.mbytessolution.databinding.view.TaskActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder> {

    private List<User> usersArrayList;
    private Context mContext;

    public RecycleAdapter(List<User> usersArrayList, Context mContext) {
        this.usersArrayList = usersArrayList;
        this.mContext = mContext;
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
        holder.bindView(user);

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

        public void bindView(User user) {
            singleUserBinding.textView5.setText(user.getName());
            singleUserBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), TaskActivity.class);
                    view.getContext().startActivity(intent);

                }
            });
        }
    }

}
