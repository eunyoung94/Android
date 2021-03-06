package com.koreait.pageapp.intent;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.koreait.pageapp.R;

//다른 액티비티에 의해 호출될 액티비티, 이 액티비티는 자신을 호출한 액티비티에 데이터를 돌려보낼 수 있다.
//
public class ResultActivity extends AppCompatActivity {
    EditText t_id,t_pass,t_name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t_id=(EditText) findViewById(R.id.t_id);
        t_pass=(EditText) findViewById(R.id.t_pass);
        t_name=(EditText) findViewById(R.id.t_name);

        //보낸자가 전송한 데이터
        Intent intent = getIntent();

    }

    //나를 호출한 액티비티에 데이터를 전달하자 주로 결과전달시 사용된다
    public void close(View view){ //닫기를 눌렀을때!
        send(); //보내는 메서드
    }
    public void send(){
        //보낼 데이터 구성하기
        Intent intent = new Intent(); //명시하지 않는 이유? 우리가 원하는건 새롭게 생성된 액티비티가 아니기 때문
        //즉 기존 액티비티와 소통해야한다.
        Member member = new Member(); //memberVO 안에 넣어주기!
        member.setId(t_id.getText().toString());
        member.setPass(t_pass.getText().toString());
        member.setName(t_name.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putParcelable("member",member);
        intent.putExtra("data",bundle);

        //RESULT_OK 상수는 이미 액티비티가 보유한 상수로서 , 성공의 의미를 담고 있다.
        //마치 http통신에서 서버코드처럼..(200)
        setResult(this.RESULT_OK,intent); //나를 호출한 액티비티에 결과 전달하기 전달 후 죽음..
        //나를 호출한 액티비티가 누군지 시스템이 알고 있다. 따라서 이 메서드만 호출하면 된다.
        finish();
    }
}
