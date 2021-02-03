package com.koreait.websocketclient;

import lombok.Data;

@Data
public class SocketMessage {
    String requestCode;
    int resultCode;
    String msg;
    String data;
}
