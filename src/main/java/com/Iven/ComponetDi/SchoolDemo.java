package com.Iven.ComponetDi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("schoolD")
public class SchoolDemo {
    @Value("航空航天大学")
    private String name;
    @Value("北京的海淀区")
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
