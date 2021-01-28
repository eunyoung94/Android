package com.koreait.actionbarapp.chat;

import android.os.Bundle;
import android.os.Message;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
서버로부터 전송되어온 메세지를 무한 루프로 청취해야하므로 , 메인쓰레드로 하면 에러가 나니, 별도의 쓰레드가 필요하다
* */
public class ChatThread extends Thread{
    Socket socket;
    BufferedReader buffr;
    BufferedWriter buffw;
    boolean flag =true; //쓰레드 가동여부를 결정하는 변수 , 이 쓰레드를 죽이고싶다면 false로 준다 .
    ChatFragment chatFragment;

    public ChatThread(Socket socket,ChatFragment chatFragment) {
        this.socket=socket;
        this.chatFragment=chatFragment;

        try {
            buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //메세지 청취 (입력)
    public void listen() {
        String msg =null;
        try {
            msg=buffr.readLine();
            Message message = new Message();
            Bundle bundle= new Bundle();
            bundle.putString("msg",msg);
            message.setData(bundle);
            chatFragment.handler.sendMessage(message);
            //textview로그에 남기기 , 디자인에 대한 접근은 개발자 정의 쓰레드에서 진행할 수 없다  , 즉 금기사항이다.
            // chatFragment.t_log.append(msg+"\n"); //디자인 제어
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //메세지 전송 (출력)
    public void send(String msg) {
        try {
            buffw.write(msg+"\n");
            buffw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while(flag) {
            listen();
        }
    }
}
