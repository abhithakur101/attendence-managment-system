package com.ams.request;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public class EmpRequest {
    public String empMobile;

    public EmpRequest(String empMobile) {
        this.empMobile = empMobile;
    }

    public String getMobile() {
        return empMobile;
    }

    public void setMobile(String empMobile) {
        this.empMobile = empMobile;
    }
}
