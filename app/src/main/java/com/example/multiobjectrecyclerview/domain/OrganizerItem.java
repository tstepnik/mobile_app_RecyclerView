package com.example.multiobjectrecyclerview.domain;

public class OrganizerItem implements Items {

    private long dateTime;
    private String text;

    public OrganizerItem(long dateTime, String text) {
        this.dateTime = dateTime;
        this.text = text;
    }

    public OrganizerItem(){}

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getType() {
        return Items.TYPE_ORGINIZERITEM;
    }
}
