package com.example.officeproject.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.officeproject.DoneDelivery;
import com.example.officeproject.Model.DeliveryDetailsModel;
import com.example.officeproject.Repository.DeliveryDetailsRepository;

import java.util.List;

public class DeliveryDetailsViewModel extends AndroidViewModel {

    DeliveryDetailsRepository repository;

    public LiveData<List<DeliveryDetailsModel>> getAllOrders;

    public DeliveryDetailsViewModel(Application application) {
        super(application);

        repository = new DeliveryDetailsRepository(application);
        getAllOrders = repository.getAllOrder;
    }

    public void insertDetails(DeliveryDetailsModel deliveryDetailsModel) {
        repository.insertDetails(deliveryDetailsModel);
    }
}
