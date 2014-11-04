package bean;


import util.GetDate;

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
    private String note;
    private Date startDate;

    private Date endDate;
    private int progress;
    private String category;
    private String top;


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", startDate=" + GetDate.getDatetimeString(startDate) +
                '}';
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }


    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
