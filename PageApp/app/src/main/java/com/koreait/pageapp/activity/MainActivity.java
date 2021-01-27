package com.koreait.pageapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.koreait.pageapp.R;
import com.koreait.pageapp.fragement.BlueFragment;
import com.koreait.pageapp.fragement.RedFragment;
import com.koreait.pageapp.fragement.YellowFragment;


//서블릿 : 우리가 new? --> 시스템에 관리를 맡긴다.. --> 생명주기
//생명주기를 메서드를 제공하여, 개발자로 하여금 제어가 가능하도록...
public class MainActivity extends AppCompatActivity {

    String TAG=this.getClass().getName();

    //1. 화면을 구성할 프레그먼트를 준비해놓는다.
    Fragment[] fragments =new Fragment[3];
    //프레그먼트 메니저를 얻으려면, 현재 액티비티가 Fragment를 지원하는 액티비티여야한다
    //우리의 경우 AppCompatActivity이므로 이미 Fragment의 자식이다. 따라서 그냥 쓰면된다.
    int current;
    FragmentManager fragmentManager=this.getSupportFragmentManager(); //x붙은걸로 가져와야함, 프레그먼트 화면을 제어해주는 프레그먼트 트랜잭션을 생성해준다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FrameLayout ViewGroup이 존재해야 붙일 수 있으므로 setContentView 이후 부착
       // ViewGroup fragement_container =(ViewGroup) this.findViewById(R.id.fragment_container);

        fragments[0]=new RedFragment();
        fragments[1]=new BlueFragment();
        fragments[2]=new YellowFragment();
        //프레그먼트를 프로그래밍적으로 화면에 부착하려면, FragmentTransaction이 필요하고
        //FragmentTransaction은 FragmentManager를 통해서 얻을 수 있다.

        //디폴트로 보여주고 싶은 화면
       showView(2); //노란색 화면부터..
    }
    public void showPage(View view){
        Log.d(TAG, "당신이 클릭한 버튼은 "+view.getId());
        int index=0;
        switch (view.getId()){
            case R.id.bt_red:index=0;break;
            case R.id.bt_blue:index=1;break;
            case R.id.bt_yellow:index=2;break;
        }
        showView(index);
    }
    public void showView(int index){
            //화면 트랜잭션 시작
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //기존것 제거
            fragmentTransaction.remove(fragments[current]); //기존 인덱스
            fragmentTransaction.add(R.id.frame, fragments[index]);
            fragmentTransaction.commit();//트랜잭션 완료
            current = index;
        }
    }

