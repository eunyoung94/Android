package com.koreait.viewfragment;

import android.R.color;
import android.R.layout;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//ctrl + shift + o를 눌러주면 아래 함수들이 선언이 된다
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
//

public class MainActivity extends Activity {
    LinearLayout back; // 배경화면 id 선언
    EditText na; // 변수 선언
    Button re, gr, bl, ye, cy; // 입력이 완료되면 ctrl + shift + o를 눌러준다.
    View.OnClickListener cl; // 클릭 이벤트 함수 cl 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 화면의 요소들과 main.java의 변수들을 id 값으로 연결해 준다.
        back = (LinearLayout) findViewById(R.id.back);
        back.setBackgroundColor(Color.BLACK);

        na = (EditText) findViewById(R.id.name);

        re = (Button) findViewById(R.id.red);
        re.setBackgroundColor(Color.RED); // 처음 시작했을 때 버튼 색상을 바뀌도록 지정
        // 그 이유는 onCreate는 반드시 한번 수행되야 하는 기능이므로 여기에 지정해서 배경 색상을 지정해 준다.

        gr = (Button) findViewById(R.id.green);
        gr.setBackgroundColor(Color.GREEN);

        bl = (Button) findViewById(R.id.blue);
        bl.setBackgroundColor(Color.BLUE);

        ye = (Button) findViewById(R.id.yellow);
        ye.setBackgroundColor(Color.YELLOW);

        cy = (Button) findViewById(R.id.cyan);
        cy.setBackgroundColor(Color.CYAN);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) { // v로 반별을 진행한다.
                switch (v.getId()) {      // v가 눌리면 id로 판별해 낸다
                    case R.id.red:            // red 버튼이 눌리면
                        na.setBackgroundColor(Color.RED);  // 에디트 텍스트 영역을 빨간색으로 변경한다.
                        back.setBackgroundColor(Color.RED); // 배경화면 영역의 색상을 빨간색으로 변경
                        break;
                    case R.id.green :
                        na.setBackgroundColor(Color.GREEN);
                        back.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.blue :
                        na.setBackgroundColor(Color.BLUE);
                        back.setBackgroundColor(Color.BLUE);
                        break;
                    case R.id.yellow :
                        na.setBackgroundColor(Color.YELLOW);
                        back.setBackgroundColor(Color.YELLOW);
                        break;
                    case R.id.cyan :
                        na.setBackgroundColor(Color.CYAN);
                        back.setBackgroundColor(Color.CYAN);
                        break;
                }
            }
        };
        re.setOnClickListener(cl); // 버튼이 눌리면 cl이 구동되도록 선언
        gr.setOnClickListener(cl);
        bl.setOnClickListener(cl);
        ye.setOnClickListener(cl);
        cy.setOnClickListener(cl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
      //  if (id == R.id.action_settings) {
            return true;
        }
       // return super.onOptionsItemSelected(item);
    }
