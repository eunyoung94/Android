package com.koreait.actionbarapp.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koreait.actionbarapp.MainActivity;
import com.koreait.actionbarapp.R;


import org.w3c.dom.Text;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends BaseAdapter {
    // 리소스에 있는 자원을 이용함..
    // 네트워크 http요청 ? socket? -->웹서버 구축
    // 기술학습 순서 : 안드로이드보다 앞서서 순수한 자바로 !
    ArrayList<Gallery> galleryList = new ArrayList<Gallery>();
    LayoutInflater layoutInflater;
    MainActivity mainActivity;

    public GalleryAdapter(MainActivity mainActivity){
        this.mainActivity=mainActivity; //인플레이터를 얻기 위해 가져옴
        layoutInflater=mainActivity.getLayoutInflater(); //인플레이터를 얻기
    }

    @Override
    public int getCount() {
        return galleryList.size(); //임시적으로
    }

    @Override
    public Object getItem(int position) {
        return galleryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;//이 메서드에서 최종 반환할 뷰

        if(convertView==null) {//레이아웃 뷰가 존재하지 않는다면, 인플레이션 시킴
            //false의 의미 : 지정한 parent에 부착하지 않고, 인플레이션 대상 xml의 최상위를 반환
           view=layoutInflater.inflate(R.layout.item_gallery,parent,false);


        }else { //이미 존재한다면, 기존 뷰 그대로 사용
            view=convertView;
        }
        //리스트에 들어있는 position번째 Gallery 추출
        Gallery gallery = galleryList.get(position);
        ImageView img = view.findViewById(R.id.img);
        TextView t_title= view.findViewById(R.id.t_title);

        img.setImageBitmap(gallery.getBitmap());
        t_title.setText(gallery.getTitle());

        img.setOnClickListener(e->{
            Toast.makeText(mainActivity,gallery.getGallery_id()+"선택했어?",Toast.LENGTH_SHORT).show();

        });

        return view;
    }

}
