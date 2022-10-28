package com.projectname.api.client.data.model.activities.common;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CommonActivitiesRequest implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("dueDate")
    @Expose
    private String dueDate;
    @SerializedName("completed")
    @Expose
    private Boolean completed;
    private final static long serialVersionUID = 3878320710527640798L;

    public CommonActivitiesRequest() {
    }


    public CommonActivitiesRequest(Integer id, String title, String dueDate, Boolean completed) {
        super();
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}