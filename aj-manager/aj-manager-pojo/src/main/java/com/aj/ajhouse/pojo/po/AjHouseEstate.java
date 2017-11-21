package com.aj.ajhouse.pojo.po;

public class AjHouseEstate {
    private Integer id;

    private String esName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEsName() {
        return esName;
    }

    public void setEsName(String esName) {
        this.esName = esName == null ? null : esName.trim();
    }
}