package com.projectname.api.client.data.model.coverphotos.common;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommonCoverPhotosResponse implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idBook")
    @Expose
    private Integer idBook;
    @SerializedName("url")
    @Expose
    private String url;
    private final static long serialVersionUID = 8943775142151358804L;

    public CommonCoverPhotosResponse() {
    }

    public CommonCoverPhotosResponse(Integer id, Integer idBook, String url) {
        super();
        this.id = id;
        this.idBook = idBook;
        this.url = url;
    }

    public static CommonCoverPhotosResponse parseExpectedCoverPhotosResponse(CommonCoverPhotosRequest coverPhotosRequest) {
        CommonCoverPhotosResponse commonCoverPhotosResponse = new CommonCoverPhotosResponse();
        commonCoverPhotosResponse.setId(coverPhotosRequest.getId());
        commonCoverPhotosResponse.setIdBook(coverPhotosRequest.getIdBook());
        commonCoverPhotosResponse.setUrl(coverPhotosRequest.getUrl());
        return commonCoverPhotosResponse;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}