package com.example.officeproject.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.officeproject.Dao.DeliveryDao;
import com.example.officeproject.Database.DatabaseHelper;
import com.example.officeproject.Model.DeliveryDetailsModel;

import java.util.List;

public class DeliveryDetailsRepository {

    private DeliveryDao deliveryDao;

    public LiveData<List<DeliveryDetailsModel>> getAllOrder;

    public DeliveryDetailsRepository(Application application) {

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(application);
        deliveryDao = databaseHelper.deliveryDao();
        getAllOrder = deliveryDao.getsAllOrders();

    }

    public void insertDetails(DeliveryDetailsModel deliveryDetailsModel) {

        deliveryDao.insertDetails(deliveryDetailsModel);


    }
}
