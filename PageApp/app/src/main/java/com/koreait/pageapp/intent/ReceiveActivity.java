package com.koreait.pageapp.intent;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.koreait.pageapp.R;

public class ReceiveActivity extends AppCompatActivity {
    EditText t_id,t_pass,t_name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        t_id=(EditText) findViewById(R.id.t_id);
        t_pass=(EditText) findViewById(R.id.t_pass);
        t_name=(EditText) findViewById(R.id.t_name);

        Intent intent = this.getIntent(); //전달받은 기존 인텐트를 참조 포워딩 받듯이..
        Bundle bundle=intent.getBundleExtra("data");
        Member member=(Member) bundle.getParcelable("member");

        //텍스트박스에 채우기
        t_id.setText(member.getId());
        t_pass.setText(member.getPass());
        t_name.setText(member.getName());
    }



    public void close(View view){
        this.finish();
    }
}