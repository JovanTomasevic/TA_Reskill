package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.books.common.CommonBookRequest;
import com.projectname.api.client.data.model.books.common.CommonBookResponse;
import com.projectname.api.client.data.model.common.EmptyResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class BookAPI {

    public static CommonBookResponse createBook(CommonBookRequest bookRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(bookRequest, ApiEndpoints.BOOKS), CommonBookResponse.class);
    }

    public static CommonBookResponse updatedBook(CommonBookRequest bookRequest , Integer bookId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(bookRequest, ApiEndpoints.BOOK(bookId)), CommonBookResponse.class);
    }

    public static EmptyResponse deleteBook(Integer bookId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.BOOK(bookId)), EmptyResponse.class);
    }

    public static CommonBookResponse[] getAllBookResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.BOOKS), CommonBookResponse[].class);
    }
}