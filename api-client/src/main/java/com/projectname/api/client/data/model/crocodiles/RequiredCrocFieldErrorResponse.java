package com.projectname.api.client.data.model.crocodiles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RequiredCrocFieldErrorResponse implements Serializable {

    @SerializedName("name")
    @Expose
    private List<String> name = null;
    @SerializedName("sex")
    @Expose
    private List<String> sex = null;
    @SerializedName("date_of_birth")
    @Expose
    private List<String> dateOfBirth = null;


    public RequiredCrocFieldErrorResponse() {
    }

    public static RequiredCrocFieldErrorResponse prepareErrorForName(List<String> name) {
        RequiredCrocFieldErrorResponse errorResponse = new RequiredCrocFieldErrorResponse();
        errorResponse.setName(name);
        return errorResponse;
    }

    public static RequiredCrocFieldErrorResponse prepareErrorForSex(List<String> sex) {
        RequiredCrocFieldErrorResponse errorResponse = new RequiredCrocFieldErrorResponse();
        errorResponse.setSex(sex);
        return errorResponse;
    }

    public static RequiredCrocFieldErrorResponse prepareErrorForDate(List<String> dateOfBirth) {
        RequiredCrocFieldErrorResponse errorResponse = new RequiredCrocFieldErrorResponse();
        errorResponse.setDateOfBirth(dateOfBirth);
        return errorResponse;
    }

    public RequiredCrocFieldErrorResponse(List<String> name, List<String> sex, List<String> dateOfBirth) {
        super();
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getSex() {
        return sex;
    }

    public void setSex(List<String> sex) {
        this.sex = sex;
    }

    public List<String> getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(List<String> dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
