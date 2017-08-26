package org.hww.main;

import org.hww.aop.configmethod.beans.Person3;
import org.hww.aop.notemethod.beans.Person4;
import org.hww.ioc.configmethod.beans.Person;
import org.hww.ioc.notemethod.beans.Person2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class Main {
    public static void main(String[] args) {

    }

    @Test
    public void testIoc1() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());
    }

    @Test
    public void testIoc2() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Person2 person2 = (Person2) context.getBean("person2");
        System.out.println(person2.toString());
    }

    @Test
    public void testAop1() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Person3 person3 = (Person3) context.getBean("person3");
        person3.add();
    }

    @Test
    public void testAop2() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Person4 person4 = (Person4) context.getBean("person4");
        person4.add();
    }


}
