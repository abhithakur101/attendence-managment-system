package com.ams.request;

public class EmpRequest {
    public String empMobile;


    public EmpRequest(String mobile) {
        this.empMobile = mobile;
    }

    public String getMobile() {
        return empMobile;
    }

    public void setMobile(String mobile) {
        this.empMobile = mobile;
    }
}
