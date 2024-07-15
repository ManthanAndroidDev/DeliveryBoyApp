package com.example.officeproject.Model;

import java.util.List;

public class OrderListModel {

    private List<orderlist> orderlist;

    public List<orderlist> getOrder() {
        return orderlist;
    }

    public void setOrder(List<orderlist> order) {
        this.orderlist = order;
    }

    public static class orderlist {

        private int order_id;
        private String order_no;
        private String customer_name;
        private Float latitude;
        private double longitude;
        private String address;
        private String delivery_cost;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public Float getLatitude() {
            return latitude;
        }

        public void setLatitude(Float latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDelivery_cost() {
            return delivery_cost;
        }

        public void setDelivery_cost(String delivery_cost) {
            this.delivery_cost = delivery_cost;
        }
    }
}
