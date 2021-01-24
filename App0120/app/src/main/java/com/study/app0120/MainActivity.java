package com.study.app0120;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private  String TAG = this.getClass().getName();
    WebConnector web;
    //액티비티가 초기화될때 할 작업을 onCreate()에서 처리해야한다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView 화면을 구성할 컴포넌트를 생성 및 배치
        setContentView(R.layout.login_form);//화면 담당자가 로그인폼을 메인으로 쓰겠다고 선언하는것!
    }
    //이벤트 메서드 정의
    public void regist(View view){
        //안드로이드도 Log4j를 도입
        //태그의 역할? 로그에 출력되는 메세지간 구분을 위한 태그, 이 태그가 구분되어야 수많은 로그중 개발자가 원하는 로그를 걸러낼 수 있다.
        Log.d(TAG,"나눌렀어?");
        //간접적으로 요청시도
        web = new WebConnector();
        web.start();
    }
}