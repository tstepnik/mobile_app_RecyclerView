package com.example.multiobjectrecyclerview.domain;

public class Note implements Items {

    private long date;
    private String text;

    public Note(long date, String text) {
        this.date = date;
        this.text = text;
    }

    public Note() {
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getType() {
        return Items.TYPE_NOTE;
    }
}
