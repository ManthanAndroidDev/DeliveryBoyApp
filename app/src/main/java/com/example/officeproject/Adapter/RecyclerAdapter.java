package com.example.officeproject.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.officeproject.Model.DeliveryDetailsModel;
import com.example.officeproject.Model.OrderListModel;
import com.example.officeproject.R;
import com.example.officeproject.ViewModel.DeliveryDetailsViewModel;
import com.example.officeproject.sendOrder;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<OrderListModel.orderlist> dataList;
    List<DeliveryDetailsModel> deliveryDetailsModels;
//    DeliveryDetailsViewModel deliveryDetailsViewModel;
//    Context context;

    public RecyclerAdapter(List<OrderListModel.orderlist> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list, parent, false);
        return new RecyclerViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

//        holder.bind(dataList.get(position));
        OrderListModel.orderlist orderListModel = dataList.get(position);

        holder.OrderNo.setText(orderListModel.getOrder_no());
        holder.CustomerName.setText(orderListModel.getCustomer_name());
        holder.Address.setText(orderListModel.getAddress());
        holder.DeliveryCost.setText(orderListModel.getDelivery_cost());
        holder.Latitude.setText("" + orderListModel.getLatitude());
        holder.Longitude.setText("" + orderListModel.getLongitude());

//        for (DeliveryDetailsModel deliveryDetailsModel:deliveryDetailsModels){
//
//            if (orderListModel.getOrder_no().equals(deliveryDetailsModel.getOrderID()){
//
//
//            }
//
//        }

        for (DeliveryDetailsModel deliveryDetailsModel : deliveryDetailsModels) {


            if (orderListModel.getOrder_no().equals(deliveryDetailsModel.getOrderID())) {

                holder.cardView.setCardBackgroundColor(R.color.green);
            }
        }
    }


    public void setDatabaseList(List<DeliveryDetailsModel> deliveryDetailsModels) {

        this.deliveryDetailsModels = deliveryDetailsModels;
        notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        if (this.dataList != null)
            return this.dataList.size();
        else
            return 0;
    }

    public void setDataList(List<OrderListModel.orderlist> dataList) {

        this.dataList = dataList;
        notifyDataSetChanged();

    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView OrderId, OrderNo, CustomerName, Latitude, Longitude, Address, DeliveryCost;

        CardView cardView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

//            OrderId = itemView.findViewById(R.id.txt_order_id);
            OrderNo = itemView.findViewById(R.id.txt_order_no);
            CustomerName = itemView.findViewById(R.id.txt_customer_name);
            Latitude = itemView.findViewById(R.id.txt_latitude);
            Longitude = itemView.findViewById(R.id.txt_longitude);
            Address = itemView.findViewById(R.id.txt_address);
            DeliveryCost = itemView.findViewById(R.id.txt_delivery_cost);

            cardView = itemView.findViewById(R.id.indicator);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(v.getContext(), "hello", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(v.getContext(), sendOrder.class);
                    intent.putExtra("oderNum", OrderNo.getText().toString());
                    intent.putExtra("customerName", CustomerName.getText().toString());
                    intent.putExtra("address", Address.getText().toString());
                    intent.putExtra("cost", DeliveryCost.getText().toString());
                    intent.putExtra("lati", Latitude.getText().toString());
                    intent.putExtra("longi", Longitude.getText().toString());
                    v.getContext().startActivity(intent);

//                    Intent intent = new Intent(v.getContext(), sendOrder.class);
//                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
