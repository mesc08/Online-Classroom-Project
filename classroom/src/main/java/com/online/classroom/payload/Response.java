package com.online.classroom.payload;

public class Response {
    private String Requestid;
    private String Message;
    private Object data;


    public Response(String requestid, String message, Object data) {
        Requestid = requestid;
        Message = message;
        this.data = data;
    }

    public Response(String requestid, String message) {
        Requestid = requestid;
        Message = message;
    }
}
