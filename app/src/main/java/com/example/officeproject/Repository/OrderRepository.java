package com.example.officeproject.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.officeproject.Model.OrderListModel;
import com.example.officeproject.ServiiceApi.ApiInterface;
import com.example.officeproject.ServiiceApi.RetrofitInstance;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepository {

    public ApiInterface apiInterface;

    public OrderRepository() {

        // Initialize the API service
        apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

    }

    // Fetch data from the API and return LiveData
    public MutableLiveData<OrderListModel> getDataFromApi() {
        MutableLiveData<OrderListModel> data = new MutableLiveData<>();

        apiInterface.getAllOrder().enqueue(new Callback<OrderListModel>() {
            @Override
            public void onResponse(Call<OrderListModel> call, Response<OrderListModel> response) {


                if (response.isSuccessful()) {
                    data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<OrderListModel> call, Throwable t) {

                t.printStackTrace();
                data.setValue(null);

            }
        });
        return data;
    }

//    public void fetchResponse(final MutableLiveData<List<OrderListModel>> mld) {
//
//        final MutableLiveData<OrderListModel> ml = new MutableLiveData<>();
//
//        apiInterface.getAllOrder().enqueue(new Callback<List<OrderListModel>>() {
//            @Override
//            public void onResponse(Call<List<OrderListModel>> call, Response<List<OrderListModel>> response) {
//
//                mld.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<OrderListModel>> call, Throwable t) {
//
//            }
//        });
//    }
}




