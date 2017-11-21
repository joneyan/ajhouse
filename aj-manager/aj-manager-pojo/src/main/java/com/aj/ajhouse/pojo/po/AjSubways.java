package com.aj.ajhouse.pojo.po;

public class AjSubways {
    private Integer id;

    private String line;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line == null ? null : line.trim();
    }
}