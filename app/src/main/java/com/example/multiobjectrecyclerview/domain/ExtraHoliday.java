package com.example.multiobjectrecyclerview.domain;

public class ExtraHoliday implements Items {

    private long date;
    private String name;

    public ExtraHoliday(long date, String name) {
        this.date = date;
        this.name = name;
    }

    public ExtraHoliday() {
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getType() {
        return Items.TYPE_EXTRAHOLIDAY;
    }
}
