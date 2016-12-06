package com.derrick.vo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Dre on 2016/11/30.
 */
@XmlRootElement(name = "hello")
public class HelloVO {

    public HelloVO() {
    }

    private String name;

    private String greetings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreetings() {
        return greetings;
    }

    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }

    public HelloVO(String name, String greetings) {
        this.name = name;
        this.greetings = greetings;
    }
}
