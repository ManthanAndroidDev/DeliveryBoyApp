package com.example.officeproject.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.officeproject.Model.OrderListModel;
import com.example.officeproject.Repository.OrderRepository;

import java.util.List;

public class OrderViewModel extends ViewModel {

    private OrderRepository orderRepository;
    private MutableLiveData<OrderListModel> data;

    public OrderViewModel() {

        orderRepository = new OrderRepository();
        data = orderRepository.getDataFromApi();

    }

    public LiveData<OrderListModel> getData() {

        return data;
    }



}
