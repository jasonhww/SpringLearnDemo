package org.hww.ioc.notemethod.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * IOC——注解方式
 */
@Component("person2") //配置对象的创建
public class Person2 {

    @Resource(name = "father2")
    private Father2 father2;


    @Override
    public String toString() {
        return

                "father2:" + father2 + "\n";
    }

}
