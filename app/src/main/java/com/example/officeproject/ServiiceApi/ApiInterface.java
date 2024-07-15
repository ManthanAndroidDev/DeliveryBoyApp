package com.example.officeproject.ServiiceApi;

import com.example.officeproject.Model.OrderListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("orderlist.php")
//    @GET("/photos")
    Call<OrderListModel> getAllOrder();

}


