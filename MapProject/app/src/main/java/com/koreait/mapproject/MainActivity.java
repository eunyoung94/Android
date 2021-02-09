package com.koreait.mapproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    SupportMapFragment mapFragment;
    GoogleMap googleMap;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        handler=new Handler(Looper.getMainLooper()){
            //쓰레드로 반영하고 싶은 UI를..
            public void handleMessage(@NonNull Message message) {
                MarkerOptions options =(MarkerOptions)message.getData().get("options");
                googleMap.addMarker(options); //맵에 옵션 추가
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(options.getPosition())); //카메라 시점은 지정한 위치로 이동하는것
            }
        };
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap= googleMap;
        // Add a marker in Sydney and move the camera
        Thread thread = new Thread(){
            public void run() {
               setMarker();
            }
        };
       thread.start();
    }

    public void setMarker(){
        LatLng pos = new LatLng(37.5287107376037, 127.08465224676117);
        MarkerOptions options= new MarkerOptions();
        options.position(pos);

        URL url=null;
        Bitmap bitmap=null;
        try {
            url=new URL("https://cdn0.iconfinder.com/data/icons/small-n-flat/24/678111-map-marker-256.png");
            bitmap= BitmapFactory.decodeStream(url.openStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        BitmapDescriptor bitmapDescriptor= BitmapDescriptorFactory.fromBitmap(bitmap);
        options.icon(bitmapDescriptor);

        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putParcelable("options",options);
        message.setData(bundle);
        handler.sendMessage(message);        //핸들러에게 부탁
    }
}