package com.mbytessolution.databinding.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mbytessolution.databinding.HolidayModel;
import com.mbytessolution.databinding.databinding.SingleHolidayBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder> {

    private List<HolidayModel> holidayModelList;

    public HolidayAdapter(List<HolidayModel> holidayModelList) {
        this.holidayModelList = holidayModelList;
    }

    @NonNull
    @Override
    public HolidayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleHolidayBinding singleHolidayBinding = SingleHolidayBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HolidayViewHolder(singleHolidayBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HolidayViewHolder holder, int position) {

        HolidayModel holidayModel = holidayModelList.get(position);
        holder.singleHolidayBinding.setHoliday(holidayModel);

    }

    @Override
    public int getItemCount() {
        return holidayModelList.size();
    }

    public static class HolidayViewHolder extends RecyclerView.ViewHolder {

        SingleHolidayBinding singleHolidayBinding;

        public HolidayViewHolder(@NonNull SingleHolidayBinding singleHolidayBinding) {
            super(singleHolidayBinding.getRoot());
            this.singleHolidayBinding = singleHolidayBinding;
        }
    }
}
