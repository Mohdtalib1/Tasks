package com.mbytessolution.databinding.Repository;

import com.mbytessolution.databinding.HolidayModel;
import com.mbytessolution.databinding.Retrofit.ApiInterface;
import com.mbytessolution.databinding.Retrofit.RetrofitUtility;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidayRepository {

    public MutableLiveData<List<HolidayModel>> requestHolidays() {

        final MutableLiveData<List<HolidayModel>> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = RetrofitUtility.getRetrofitClient().create(ApiInterface.class);

        apiInterface.getHolidays().enqueue(new Callback<List<HolidayModel>>() {
            @Override
            public void onResponse(Call<List<HolidayModel>> call, Response<List<HolidayModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<HolidayModel>> call, Throwable t) {
            }
        });

        return mutableLiveData;
    }
}
