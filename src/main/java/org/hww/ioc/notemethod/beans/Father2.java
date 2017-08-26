package org.hww.ioc.notemethod.beans;

import org.springframework.stereotype.Component;

@Component(value = "father2")
public class Father2 {
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
