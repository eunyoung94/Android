package com.study.boardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = this.findViewById(R.id.listView);

        //뷰는 MVC에서 View 즉, 디자인에 해당되므로, 실제 데이터를 처리 및 관리하는
        //객체 모델이며, 이 모델과 디자인인 View,를 연결해주는 역할을 Controller가한다.
        //JTable에서 TableModel이 있듯, 안드로이드에서는 Adapter가 지원된다.
        List<String> data = new ArrayList<String>();
        data.add("사과");
        data.add("바나나");
        data.add("딸기");
        data.add("오렌지");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1); //배열이나 리스트 등 아이템이 단일한 경우 최적화되있음
        listView.setAdapter(adapter);
    }
}