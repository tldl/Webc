package bean;


import util.Utils;

import java.io.Serializable;
import java.util.Date;


public class Agenda implements Serializable {
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DATE = "date";
    public static final String PROGRESS = "progress";
    public static final String IOP = "top";

    private int id;
    private String title;
    private String content;
    private String startDate = Utils.getFormatDate(new Date());

    private Date endDate;
    private int progress;
    private String category;
    private String top;


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


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTop() {
        return top;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setTop(String top) {
        this.top = top;
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
