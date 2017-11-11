package com.aj.ajhouse.pojo.po;

public class AjCity {
    private Integer id;

    private String name;

    private Integer reginId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getReginId() {
        return reginId;
    }

    public void setReginId(Integer reginId) {
        this.reginId = reginId;
    }
}