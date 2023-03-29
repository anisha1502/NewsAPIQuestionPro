package com.newsData.newsDataAPI.entity;
import java.util.ArrayList;

public class items {
    private Integer id;
    private boolean deleted;
    private String type;
    private String by;
    private String time	;
    private String text;
    private boolean dead;
    private Integer parent;
    private String poll;
    private ArrayList<Integer>  kids;
    private String url;
    private int score;
    private String title;
    private String parts;
    private int descendants;

    public items() {
    }

    public items(Integer id, boolean deleted, String type, String by, String time, String text, boolean dead, Integer parent, String poll, ArrayList<Integer> kids, String url, int score, String title, String parts, int descendants) {
        this.id = id;
        this.deleted = deleted;
        this.type = type;
        this.by = by;
        this.time = time;
        this.text = text;
        this.dead = dead;
        this.parent = parent;
        this.poll = poll;
        this.kids = kids;
        this.url = url;
        this.score = score;
        this.title = title;
        this.parts = parts;
        this.descendants = descendants;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getPoll() {
        return poll;
    }

    public void setPoll(String poll) {
        this.poll = poll;
    }

    public ArrayList<Integer> getKids() {
        return kids;
    }

    public void setKids(ArrayList<Integer> kids) {
        this.kids = kids;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public int getDescendants() {
        return descendants;
    }

    public void setDescendants(int descendants) {
        this.descendants = descendants;
    }

    @Override
    public String toString() {
        return "items{" +
                "id=" + id +
                ", deleted=" + deleted +
                ", type='" + type + '\'' +
                ", by='" + by + '\'' +
                ", time='" + time + '\'' +
                ", text='" + text + '\'' +
                ", dead=" + dead +
                ", parent=" + parent +
                ", poll='" + poll + '\'' +
                ", kids=" + kids +
                ", url='" + url + '\'' +
                ", score=" + score +
                ", title='" + title + '\'' +
                ", parts='" + parts + '\'' +
                ", descendants=" + descendants +
                '}';
    }
}
