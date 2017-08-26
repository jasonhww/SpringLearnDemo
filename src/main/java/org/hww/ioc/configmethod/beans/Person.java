package org.hww.ioc.configmethod.beans;

import org.hww.ioc.configmethod.beans.Father;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * IOC——xml配置方式
 */
public class Person {
    private String userName;
    private int age;
    private Father father;
    private String[] arrays;
    private List<String> lists;
    private Map<String, String> maps;
    private Properties properties;

    public Person() {
    }

    public Person(String userName) {
        this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public void setArrays(String[] arrays) {
        this.arrays = arrays;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "userName:" + userName + "\n"
                + "age:" + age + "\n"
                + "father:" + father + "\n"
                + "arrays:" + arrays[0] + arrays[1] + arrays[2] + "\n"
                + "lists:" + lists.toString() + "\n"
                + "maps:" + maps.toString() + "\n"
                + "properties:" + properties.toString() + "\n";
    }
}
