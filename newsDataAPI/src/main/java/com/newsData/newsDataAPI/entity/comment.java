package com.newsData.newsDataAPI.entity;
public class comment {
    private String text;
    private String by;

    private int descendents;

    private int count;

    public comment() {
    }

    public comment(String text, String by, int descendents, int count) {
        this.text = text;
        this.by = by;
        this.descendents = descendents;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDescendents() {
        return descendents;
    }

    public void setDescendents(int descendents) {
        this.descendents = descendents;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    @Override
    public String toString() {
        return "comment{" +
                "text='" + text + '\'' +
                ", by='" + by + '\'' +
                '}';
    }
}
