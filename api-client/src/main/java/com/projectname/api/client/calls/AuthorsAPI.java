package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.authors.common.CommonAuthorResponse;
import com.projectname.api.client.data.model.authors.common.CommonAuthorsRequest;
import com.projectname.api.client.data.model.common.EmptyResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class AuthorsAPI {

    public static CommonAuthorResponse createAuthor(CommonAuthorsRequest authorsRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(authorsRequest, ApiEndpoints.AUTHORS), CommonAuthorResponse.class);
    }

    public static CommonAuthorResponse updatedAuthor(CommonAuthorsRequest authorsRequest , Integer authorId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(authorsRequest, ApiEndpoints.AUTHOR(authorId)), CommonAuthorResponse.class);
    }

    public static CommonAuthorResponse[] getAuthorByBookId(Integer bookId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.AUTHOR_BY_BOOKID(bookId)), CommonAuthorResponse[].class);
    }

    public static CommonAuthorResponse getAuthorById(Integer authorId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.AUTHOR(authorId)), CommonAuthorResponse.class);
    }

    public static EmptyResponse deleteAuthor(Integer activityId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.AUTHOR(activityId)), EmptyResponse.class);
    }

    public static CommonAuthorResponse[] getAllAuthorResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.AUTHORS), CommonAuthorResponse[].class);
    }

}