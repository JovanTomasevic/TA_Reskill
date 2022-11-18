package com.projectname.api.client.data.model.crocodiles;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequiredUserRegisterFieldErrorResponse implements Serializable {

    @SerializedName("username")
    @Expose
    private List<String> username = null;
    @SerializedName("first_name")
    @Expose
    private List<String> firstName = null;
    @SerializedName("last_name")
    @Expose
    private List<String> lastName = null;
    @SerializedName("email")
    @Expose
    private List<String> email = null;
    @SerializedName("password")
    @Expose
    private List<String> password = null;

    public RequiredUserRegisterFieldErrorResponse() {
    }

    public static RequiredUserRegisterFieldErrorResponse prepareErrorForUsername(List<String> username) {
        RequiredUserRegisterFieldErrorResponse errorResponse = new RequiredUserRegisterFieldErrorResponse();
        errorResponse.setUsername(username);
        return errorResponse;
    }

    public static RequiredUserRegisterFieldErrorResponse prepareErrorForFirstName(List<String> firstName) {
        RequiredUserRegisterFieldErrorResponse errorResponse = new RequiredUserRegisterFieldErrorResponse();
        errorResponse.setFirstName(firstName);
        return errorResponse;
    }

    public static RequiredUserRegisterFieldErrorResponse prepareErrorForLastName(List<String> lastName) {
        RequiredUserRegisterFieldErrorResponse errorResponse = new RequiredUserRegisterFieldErrorResponse();
        errorResponse.setLastName(lastName);
        return errorResponse;
    }

    public static RequiredUserRegisterFieldErrorResponse prepareErrorForEmail(List<String> email) {
        RequiredUserRegisterFieldErrorResponse errorResponse = new RequiredUserRegisterFieldErrorResponse();
        errorResponse.setEmail(email);
        return errorResponse;
    }

    public static RequiredUserRegisterFieldErrorResponse prepareErrorForPassword(List<String> password) {
        RequiredUserRegisterFieldErrorResponse errorResponse = new RequiredUserRegisterFieldErrorResponse();
        errorResponse.setPassword(password);
        return errorResponse;
    }


    public RequiredUserRegisterFieldErrorResponse(List<String> username, List<String> firstName, List<String> lastName, List<String> email, List<String> password) {
        super();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }

    public List<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(List<String> firstName) {
        this.firstName = firstName;
    }

    public List<String> getLastName() {
        return lastName;
    }

    public void setLastName(List<String> lastName) {
        this.lastName = lastName;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getPassword() {
        return password;
    }

    public void setPassword(List<String> password) {
        this.password = password;
    }
}
