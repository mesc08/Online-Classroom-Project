package com.online.classroom.payload;

public class Response {
    private String requestId;
    private String message;
    private Object data;

    public Response(String requestId, String message, Object data) {
        this.requestId = requestId;
        this.message = message;
        this.data = data;
    }

    public Response(String requestId, String message) {
        this.requestId = requestId;
        this.message = message;
    }
}
