package com.wh.xyxwhl.web.model;


public class JsonObject {


    public JsonObject(Object data) {
        this.data = data;
    }

    public JsonObject(Object data, Object errCode) {
        this.data = data;
        this.errCode = errCode;
    }

    public JsonObject(Object data, Object errCode, Object maxPage) {
        this.data = data;
        this.errCode = errCode;
        this.maxPage = maxPage;
    }

    public JsonObject(Object data, Object errCode, String url) {
        this.data = data;
        this.errCode = errCode;
        this.url = url;
    }

    public JsonObject(Object data, Object errCode, Object maxPage, int total) {
        this.data = data;
        this.errCode = errCode;
        this.maxPage = maxPage;
        this.total = total;
    }

    // Setter,getters
    private Object data = "";
    private Object errCode = 0;
    private String url = "";
    private Object maxPage = 0;
    private int total = 0;
    private int count;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Object getErrCode() {
        return errCode;
    }
    public void setErrCode(Object errCode) {
        this.errCode = errCode;
    }
    public Object getMaxPage() {
        return maxPage;
    }
    public void setMaxPage(Object maxPage) {
        this.maxPage = maxPage;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
