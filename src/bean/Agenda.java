package bean;


import util.Utils;

import java.io.Serializable;
import java.util.Date;


public class Agenda implements Serializable {
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DATE = "date";
    public static final String IOP = "top";

    private int id;
    private String title;
    private String content;
    private String startDate = Utils.getFormatDate(new Date());


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + content + '\'' +
                ", startDate=" + startDate +
                '}';
    }


}
