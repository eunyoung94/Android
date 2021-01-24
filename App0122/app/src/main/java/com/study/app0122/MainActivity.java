package com.study.app0122;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//이 메서드 자체가 이미 inflation 기능이 들어있다!!
        LinearLayout wrapper = (LinearLayout)this.findViewById(R.id.wrapper);
        //inflation이란? xml에서 정의해놓은 태그들을 실제 안드로이드 객체로 인스턴스화 시키는 과정..
        //Layout 리소스파일을 팝콘처럼 튀겨버리겠다.
        LayoutInflater layoutInflater= this.getLayoutInflater();
        layoutInflater.inflate(R.layout.profile_item,wrapper);
        layoutInflater.inflate(R.layout.profile_item,wrapper);
        layoutInflater.inflate(R.layout.profile_item,wrapper);
        }
    }

