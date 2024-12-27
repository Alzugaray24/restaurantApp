// src/main/java/com/example/dtos/RestaurantDTO.java
package com.example.dtos;

public class RestaurantDTO {
    private String name;
    private String phone;
    private String address;
    private Integer available;

    public RestaurantDTO() {
    }

    public RestaurantDTO(String name, String phone, String address, Integer available) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", available=" + available +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}