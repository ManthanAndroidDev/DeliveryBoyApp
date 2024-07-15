package com.example.officeproject;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class sendOrder extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationProviderClient;
    LocationRequest locationRequest;
    LocationCallback locationCallback;
    String Text_latitude_user, Text_longitude_user, text_OrderNoPage;
    TextView OrderNoPage, CustomerNamePage, Latitude, Longitude, AddressPage, DeliveryCostPage, getButton, boyAddress, boyCity, boyCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);

        OrderNoPage = findViewById(R.id.txt_order_no_page);
        CustomerNamePage = findViewById(R.id.txt_customer_name_page);
        AddressPage = findViewById(R.id.txt_address_page);
        DeliveryCostPage = findViewById(R.id.txt_delivery_cost_page);

        Latitude = findViewById(R.id.lati);
        Longitude = findViewById(R.id.longi);
        boyAddress = findViewById(R.id.Adda);
        boyCity = findViewById(R.id.cit);
        boyCountry = findViewById(R.id.coun);

        getButton = findViewById(R.id.get_button);

        text_OrderNoPage = getIntent().getStringExtra("oderNum");
        String text_CustomerNamePage = getIntent().getStringExtra("customerName");
        String text_AddressPage = getIntent().getStringExtra("address");
        String text_DeliveryCostPage = getIntent().getStringExtra("cost");
        Text_latitude_user = getIntent().getStringExtra("lati");
        Text_longitude_user = getIntent().getStringExtra("longi");

        OrderNoPage.setText(text_OrderNoPage);
        CustomerNamePage.setText("CUSTOMER NAME: " + text_CustomerNamePage);
        AddressPage.setText("ADDRESS: " + text_AddressPage);
        DeliveryCostPage.setText("Rs.: " + text_DeliveryCostPage);

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                startActivity(new Intent(DeliveryPage.this, DoneDelivery.class));
                // method to get the location
                getLastLocation();

            }
        });


        locationRequest = LocationRequest.create();
        locationRequest.setInterval(60000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {

                if (locationResult == null) {

                    return;
                }
                for (Location location : locationResult.getLocations()) {

                    if (location != null) {
                        // UI Update.
                    }
                }
            }
        };

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

    }

    private void getLastLocation() {

        // get current updated location.
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if (location != null) {
                            Geocoder geocoder = new Geocoder(sendOrder.this, Locale.getDefault());
                            List<Address> addresses = null;
                            try {
                                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                                double lat = location.getLatitude();
                                double lon = location.getLongitude();
                                Latitude.setText("latitude: " + addresses.get(0).getLatitude());
                                Longitude.setText("longitude: " + addresses.get(0).getLatitude());
                                Latitude.setText("" + lat);
                                Longitude.setText("" + lon);
                                Location locationA = new Location("point A");
                                locationA.setLatitude(Double.parseDouble(Text_latitude_user));
                                locationA.setLongitude(Double.parseDouble(Text_longitude_user));

                                Location locationB = new Location("point B");

                                locationB.setLatitude(Double.parseDouble(Latitude.getText().toString()));
                                locationB.setLongitude(Double.parseDouble(Longitude.getText().toString()));

                                float distance = locationA.distanceTo(locationB);

                                Intent intent = new Intent(sendOrder.this, DoneDelivery.class);
                                intent.putExtra("deliveryFor", OrderNoPage.getText().toString());
                                startActivity(intent);

                                // I know the location is to far from here that why i commented this when you use actually that that un comment this.
//                                if (distance > 50) {
//                                    boyCountry.setText("distance is more than 50 meter ,distance is " + distance + "meter.");
//                                    startActivity(new Intent(sendOrder.this, MainActivity.class));
//                                    finish();
//                                }

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });
    }

    private void startLocationUpdates() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());

    }

    @Override
    protected void onResume() {
        super.onResume();
        startLocationUpdates();
    }
}