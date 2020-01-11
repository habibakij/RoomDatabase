package com.example.customroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Task implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "task")
    private String task;

    @ColumnInfo(name = "desc")
    private String desc;

    @ColumnInfo(name = "useby")
    private String useby;

    @ColumnInfo(name = "finished")
    private boolean finished;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUseby() {
        return useby;
    }

    public void setUseby(String useby) {
        this.useby = useby;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
