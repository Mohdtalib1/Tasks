package com.mbytessolution.databinding.viewmodel;

import com.mbytessolution.databinding.HolidayModel;
import com.mbytessolution.databinding.Repository.HolidayRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HolidayViewModel extends ViewModel {

    private HolidayRepository holidayRepository;
    private MutableLiveData<List<HolidayModel>> mutableLiveData;

    public HolidayViewModel() {
        this.holidayRepository = new HolidayRepository();
    }

    public LiveData<List<HolidayModel>> getHolidays() {
        if (mutableLiveData == null) {
            mutableLiveData = holidayRepository.requestHolidays();
        }

        return mutableLiveData;
    }
}
