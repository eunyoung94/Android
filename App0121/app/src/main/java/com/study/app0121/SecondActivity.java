package com.study.app0121;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //화면 구성에 사용할 뷰 또는 레이아웃 지정
        //xml에 버튼을 배치하는 방법
        //setContentView(R.layout.custom);
    /*    Button bt = new Button(this);
        bt.setText("나버튼2");
        setContentView(bt);*/
        //MyCustomButton bt =new MyCustomButton(this);
        //setContentView(bt);
        setContentView(R.layout.custom);
    }
}