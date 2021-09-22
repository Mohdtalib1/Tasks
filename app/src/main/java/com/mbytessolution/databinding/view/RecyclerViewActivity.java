package com.mbytessolution.databinding.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import com.mbytessolution.databinding.Adapter.RecycleAdapter;
import com.mbytessolution.databinding.User;
import com.mbytessolution.databinding.databinding.ActivityRecyclerViewBinding;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecycleAdapter recycleAdapter;
    ActivityRecyclerViewBinding activityRecyclerViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityRecyclerViewBinding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(activityRecyclerViewBinding.getRoot());

        activityRecyclerViewBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityRecyclerViewBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recycleAdapter = new RecycleAdapter(getUser(), RecyclerViewActivity.this);
        activityRecyclerViewBinding.recyclerView.setAdapter(recycleAdapter);


    }

    private List<User> getUser() {

        List<User> userList = new ArrayList<>();
        userList.add(new User("John Doe", "30irfucyrt2u"));
        userList.add(new User("Mike wilson", "30irfucyrt2u"));
        userList.add(new User("Aby gail", "30irfucyrt2u"));
        userList.add(new User("james smith", "30irfucyrt2u"));

        return userList;

    }
}