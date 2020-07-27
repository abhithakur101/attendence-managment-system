package com.ams.request;

import com.ams.modal.Login;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public class LoginRequest {
    public Login login;
}
