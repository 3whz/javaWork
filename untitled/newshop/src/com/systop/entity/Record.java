package com.systop.entity;

public class Record {
    private int r_id;
    private  String u_name;
    private  String p_name;
    private  String time;
    private  int p_many;

    public Record() {
    }

    public Record(int r_id, String u_name, String p_name, String time, int p_many) {
        this.r_id = r_id;
        this.u_name = u_name;
        this.p_name = p_name;
        this.time = time;
        this.p_many = p_many;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getP_many() {
        return p_many;
    }

    public void setP_many(int p_many) {
        this.p_many = p_many;
    }
}
