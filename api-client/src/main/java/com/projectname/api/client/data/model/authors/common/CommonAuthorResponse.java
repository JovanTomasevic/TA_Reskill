package com.projectname.api.client.data.model.authors.common;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CommonAuthorResponse implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idBook")
    @Expose
    private Integer idBook;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    private final static long serialVersionUID = 2714328759890701807L;

    public CommonAuthorResponse() {
    }

    public CommonAuthorResponse(Integer id, Integer idBook, String firstName, String lastName) {
        super();
        this.id = id;
        this.idBook = idBook;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static CommonAuthorResponse parseExpectedAuthorResponse(CommonAuthorsRequest authorsRequest) {
        CommonAuthorResponse commonAuthorResponse = new CommonAuthorResponse();
        commonAuthorResponse.setId(authorsRequest.getId());
        commonAuthorResponse.setIdBook(authorsRequest.getIdBook());
        commonAuthorResponse.setFirstName(authorsRequest.getFirstName());
        commonAuthorResponse.setLastName(authorsRequest.getLastName());
        return commonAuthorResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}