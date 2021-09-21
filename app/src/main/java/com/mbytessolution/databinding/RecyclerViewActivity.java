package com.mbytessolution.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mbytessolution.databinding.Adapter.RecycleAdapter;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        RecycleAdapter recycleAdapter = new RecycleAdapter(getUsersList());
        recyclerView.setAdapter(recycleAdapter);


    }

    private ArrayList<User> getUsersList() {
        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User("John doe", "3skfejhrt63ryejf", 20, true));
        userArrayList.add(new User("Mike wilson", "3skfejhrt63ryejf", 25, true));
        userArrayList.add(new User("Marry jane", "3skfejhrt63ryejf", 23, false));
        userArrayList.add(new User("James Smith", "3skfejhrt63ryejf", 28, true));

        return userArrayList;
    }
}