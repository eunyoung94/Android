package com.koreait.scaduleapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class IntroActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);
    }
    //메인 엑티비티 호출
    public void goMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent); //지정한 엑티비티 호출
    }
}
