package com.koreait.actionbarapp.chat;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.koreait.actionbarapp.R;

import java.io.IOException;
import java.net.Socket;

public class ChatFragment extends Fragment {
    EditText t_ip,t_port;
    Thread thread;//네트워크 접속을 위한 쓰레드 (메인쓰레드는 접속, 대기, 루프 등에 빠지게 해서는 안된다.)
    Socket socket;
    TextView t_log;
    EditText t_input;
    Button bt_send;
    ChatThread chatThread;
    Handler handler;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_chat,container,false);
        t_ip=(EditText)view.findViewById(R.id.t_ip);
        t_port=(EditText)view.findViewById(R.id.t_port);
        t_log=(TextView) view.findViewById(R.id.t_log);
        t_input=(EditText)view.findViewById(R.id.t_input);
        bt_send=(Button)view.findViewById(R.id.bt_send);

        //버튼을 얻어와 이벤트를 연결하자
        Button bt_connect =(Button) view.findViewById(R.id.bt_connect);
        bt_connect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                connectServer();
            }
        });
        bt_send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                send();
            }
        });
        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message message) {
                //쓰레드가 부탁한 UI제어를 여기서 대신해준다!
                Bundle bundle=message.getData();
                String msg =bundle.getString("msg"); //가져온 메세지
                t_log.append(msg+"\n");

            }
        };
        return view;
    }
    //채팅 서버에 접속
    public void connectServer(){
        String ip=t_ip.getText().toString();
        int port=Integer.parseInt(t_port.getText().toString());

        thread = new Thread(){
            public void run(){
                try {
                    socket = new Socket(ip,port); //네트워크 접속 시도하러 출발 (이때 연결됨)
                    chatThread = new ChatThread(socket,ChatFragment.this);
                    chatThread.start(); //청취시작
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    //메세지 보내기
    public void send(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                chatThread.send(t_input.getText().toString());
                //핸들러를 이용해서 로그남기기()
                Message message = new Message();
                Bundle bundle= new Bundle();
                bundle.putString("msg",t_input.getText().toString());
                message.setData(bundle);
                handler.sendMessage(message);
            }
        };
        thread.start();
    }
}