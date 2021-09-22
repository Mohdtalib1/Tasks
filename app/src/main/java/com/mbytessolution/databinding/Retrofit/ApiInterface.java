package com.mbytessolution.databinding.Retrofit;

import com.mbytessolution.databinding.HolidayModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("publicholidays/2017/AT")
    Call<List<HolidayModel>> getHolidays();
}
