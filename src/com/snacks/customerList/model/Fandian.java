package com.snacks.customerList.model;

import org.springframework.stereotype.Service;

/**
 * Created by Jerry Wang on 16/7/30.
 */
public class Fandian {

    private String resource_id;

    private String title;

    private String address;

    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public String getResource_id() {
        return resource_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
