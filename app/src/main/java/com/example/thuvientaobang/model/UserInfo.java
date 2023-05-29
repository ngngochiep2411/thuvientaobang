package com.example.thuvientaobang.model;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

@SmartTable
public class UserInfo {

    @SmartColumn
    String rank;

    @SmartColumn
    String name;

    @SmartColumn
    String age;

    @SmartColumn
    String address;

    @SmartColumn
    String phone;

    @SmartColumn
    String email;

    @SmartColumn
    String password;

    @SmartColumn
    String height;

    public UserInfo(String rank, String name, String age, String address, String phone, String email, String password, String height) {
        this.rank = rank;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.height = height;
    }
}
