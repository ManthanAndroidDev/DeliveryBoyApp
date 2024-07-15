package com.example.officeproject.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.officeproject.Model.DeliveryDetailsModel;

import java.util.List;

@Dao
public interface DeliveryDao {

    @Insert
    void insertDetails(DeliveryDetailsModel deliveryDetailsModel);

    @Query("SELECT * FROM UserDeliveryDetails")
    LiveData<List<DeliveryDetailsModel>> getsAllOrders();
}
