package com.koreait.boardapp;

//Vo는 다른 객체에 전달시, 혹은 전달받ㅇㄴ 데이터를 처리하기 위해
//Parcelable인터페이스를 구현해야함

import android.os.Parcel;
import android.os.Parcelable;

public class Board implements Parcelable {
    private int board_id;
    private String title;
    private String writer;
    private String content;
    private  String regdate;
    private int hit;

    //멤버변수를 쪼개기
    @Override
    public int describeContents() {

        return 0;
    }

    //멤버변수를 쪼개기(데이터 전송직전에 직렬화 시킨다)
    //전송하기 위한 준비작업
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(board_id);
        dest.writeString(title);
        dest.writeString(writer);
        dest.writeString(content);
        dest.writeString(regdate);
        dest.writeInt(hit);
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }


}
