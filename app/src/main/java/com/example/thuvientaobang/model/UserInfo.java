package com.example.thuvientaobang.model;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

@SmartTable(name = "userfInfo")
public class UserInfo {
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

    @SmartColumn(id = 0, name = "Thứ\nhạng",fixed = true,autoCount = true)
    private String rank;

    @SmartColumn(id = 1, name = "Họ tên",fixed = true)
    private String name;

    @SmartColumn(id = 2, name = "Tuổi")
    private String age;

    @SmartColumn(id = 3, name = "Địa chỉ")
    private String address;

    @SmartColumn(id = 4, name = "Số điện thoại")
    private String phone;

    @SmartColumn(id = 5, name = "Email")
    private String email;

    @SmartColumn(id = 6, name = "Mật khẩu")
    private String password;

    @SmartColumn(id = 7, name = "Chiều cao")
    private String height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
