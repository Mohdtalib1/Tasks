package com.mbytessolution.databinding.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.mbytessolution.databinding.Adapter.HolidayAdapter;
import com.mbytessolution.databinding.HolidayModel;
import com.mbytessolution.databinding.R;
import com.mbytessolution.databinding.databinding.ActivityTaskBinding;
import com.mbytessolution.databinding.viewmodel.HolidayViewModel;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private HolidayAdapter holidayAdapter;
    private List<HolidayModel> holidayModelList = new ArrayList<>();
    private HolidayViewModel holidayViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityTaskBinding activityTaskBinding = DataBindingUtil.setContentView(this, R.layout.activity_task);

        activityTaskBinding.newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityTaskBinding.newsRecyclerView.setHasFixedSize(true);
        activityTaskBinding.newsRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        holidayAdapter = new HolidayAdapter(holidayModelList);
        activityTaskBinding.newsRecyclerView.setAdapter(holidayAdapter);

        holidayViewModel = new HolidayViewModel();
        holidayViewModel.getHolidays().observe(this, new Observer<List<HolidayModel>>() {
            @Override
            public void onChanged(List<HolidayModel> holidayModels) {
                if (holidayModels != null && !holidayModels.isEmpty()) {
                    holidayModelList.addAll(holidayModels);
                    holidayAdapter.notifyDataSetChanged();
                    activityTaskBinding.progressBar.setVisibility(View.GONE);
                }

            }
        });


    }
}