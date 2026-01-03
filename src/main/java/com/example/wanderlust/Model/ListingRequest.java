package com.example.wanderlust.Model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public class ListingRequest {

    @NotBlank(message = "Name is Mandatory")
    private String name;
    @NotBlank(message = "description is Mandatory")
    private  String description;
    @Positive
    private  float price;
    @NotBlank(message = "Country is Mandatory")
    private  String country;
    @NotBlank(message = "Location is Mandatory")
    private  String location;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
    }





}
