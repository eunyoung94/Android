package com.koreait.scaduleapp;

//각종 통화, 문자열 자리수 등등 공통 기능처리
public class FormatManager {
    //일의 자리수 앞에 0 붙이기
    public static String getNumberString(int num){
        String str = Integer.toString(num);
        if(num<10){//1의 자릿수 일 경우엔
            str = "0"+num;
        }
        return str;
    }
}
