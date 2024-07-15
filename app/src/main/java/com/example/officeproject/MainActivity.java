package com.example.officeproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.officeproject.Adapter.RecyclerAdapter;
import com.example.officeproject.Model.DeliveryDetailsModel;
import com.example.officeproject.Model.OrderListModel;
import com.example.officeproject.ViewModel.DeliveryDetailsViewModel;
import com.example.officeproject.ViewModel.OrderViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OrderViewModel viewModel;

    TextView textView;
    DeliveryDetailsViewModel deliveryDetailsViewModel;
    //
    List<DeliveryDetailsModel> detailsModels;
    RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        textView = findViewById(R.id.count_of_item);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(OrderViewModel.class);



        viewModel.getData().observe(this, new Observer<OrderListModel>() {
            @Override
            public void onChanged(OrderListModel orderListModels) {

                if (orderListModels != null) {

//                    if (!orderListModels.isEmpty()) {

                    adapter.setDataList(orderListModels.getOrder());
//                    }
                }
            }

        });

        deliveryDetailsViewModel = new ViewModelProvider(this).get(DeliveryDetailsViewModel.class);

        deliveryDetailsViewModel.getAllOrders.observe(this, new Observer<List<DeliveryDetailsModel>>() {
            @Override
            public void onChanged(List<DeliveryDetailsModel> deliveryDetailsModels) {

                System.out.println("jzbjkh fbkhfbaskjfbaskbadjkvbdkvjbdvljkdvb" + deliveryDetailsModels);
                adapter.setDatabaseList(deliveryDetailsModels);
            }
        });
    }
}