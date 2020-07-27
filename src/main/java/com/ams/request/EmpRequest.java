package com.ams.request;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
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
