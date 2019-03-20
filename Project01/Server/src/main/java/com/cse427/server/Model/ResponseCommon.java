package com.cse427.server.model;

public class ResponseCommon<T> {

    private boolean IsResult;
    private String Message;
    private T Result;

    ResponseCommon(T model) {
        Result = model;
    }

    public ResponseCommon(boolean isResult, String message, T result) {
        IsResult = isResult;
        Message = message;
        Result = result;
    }

    public boolean isResult() {
        return IsResult;
    }

    public void setResult(boolean result) {
        IsResult = result;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getResult() {
        return Result;
    }

    public void setResult(T result) {
        Result = result;
    }
}
