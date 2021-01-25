package com.koreait.boardapp;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*보여질 데이터가 단순한 텍스트 뿐이라면, ArrayAdapter를 사용하면 된다..
 * 하지만 ListView의 각 아이템에 들어갈 데이터 형태는 대부분 복잡하고 복합적으로
 * 이루어져 잇기 때문에, 개발자가 정의한 UI를 반영하려면 어댑터를 재정의하면 된다..
 *  참고) 안드로이드의 Adapter는 자바 Swing의 TableModel과 그 역할이 같다!!
 * */
public class BoardAdapter extends BaseAdapter {
    String TAG=this.getClass().getName();
    MainActivity mainActivity;
    List<String> data = new ArrayList<String>();

    public BoardAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        data.add("사과");
        data.add("바나나");
        data.add("딸기");
        data.add("오렌지");
        data.add("파인애플");
        data.add("멜론");
        data.add("레몬");
        data.add("오렌지");
    }

    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*
     아래의 getView메서드는 getCount() 메서드의 반환값 만큼 호출한다.
     호출하면서, 리스트뷰의 각 칸(아이템)을 차지하게 될 View를 반환해간다!!!
     파라미터1) position은 getCount()  만큼 getView메서드가 호출될때 자동증가 되는 값
     파라미터2) old view
    */
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView란? 리스트뷰의 각 아이템을 차지하는 뷰가 새롭게 태어날때는 convertView(기존 뷰)값이 존재하지 않는다.
        //하지만 일단 태어나고, 화면에서 가려진 후 다시 등장할때는 새로운 아이템이 아니라 기존의 아이템이므로, 자신이
        //부여받았단 뷰주소가 covertView에 실려져 있다..
        //따라서 개발자는 화면에 가려졌다가 다시 보여지는 아이템들에 대해서는 굳이 새로운 뷰률 new하지 말고,
        //기존에 아잍쳄 본인이 가지고 잇었던 기존뷰( old view)를 재사용하는것이 메모리 효율상 좋다..
        View view=null;
        if(convertView==null) { //학생증 발급이 필요한 애들은...즉 새롭게 태어난 애들..
            TextView tv = new TextView(mainActivity);
            tv.setText(data.get(position));
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 300);
            tv.setLayoutParams(params);
            view=tv;
        }else{//이미 학생증 발급받은 애는...지가 가지고 있었던 학생증 아이디 대입..
            view=convertView;
        }
        Log.d(TAG, data.get(position)+"의 뷰는 "+view);
        //Log.d(TAG, data.get(position)+"의 convertView 는 "+convertView);

        return view;
    }
}