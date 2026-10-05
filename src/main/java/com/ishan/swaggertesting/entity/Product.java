package com.ishan.swaggertesting.entity;

public class Product {

    private Long id;

    private String name;

    private double amount;

    public Product() {}

    public Product(Long id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
