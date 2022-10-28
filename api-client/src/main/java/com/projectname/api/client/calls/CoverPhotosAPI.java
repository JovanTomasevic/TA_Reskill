package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.common.EmptyResponse;
import com.projectname.api.client.data.model.coverphotos.common.CommonCoverPhotosRequest;
import com.projectname.api.client.data.model.coverphotos.common.CommonCoverPhotosResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class CoverPhotosAPI {

    public static CommonCoverPhotosResponse createCoverPhoto(CommonCoverPhotosRequest coverPhotoRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(coverPhotoRequest, ApiEndpoints.COVER_PHOTOS), CommonCoverPhotosResponse.class);
    }

    public static CommonCoverPhotosResponse updatedCoverPhoto(CommonCoverPhotosRequest coverPhotoRequest, Integer coverPhotoId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(coverPhotoRequest, ApiEndpoints.COVER_PHOTO(coverPhotoId)), CommonCoverPhotosResponse.class);
    }

    public static CommonCoverPhotosResponse[] getCoverPhotoByBookId(Integer bookId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.COVER_PHOTO_BY_BOOKID(bookId)), CommonCoverPhotosResponse[].class);
    }

    public static EmptyResponse deleteCoverPhoto(Integer coverPhotoId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.COVER_PHOTO(coverPhotoId)), EmptyResponse.class);
    }

    public static CommonCoverPhotosResponse[] getAllCoverPhotoResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.COVER_PHOTOS), CommonCoverPhotosResponse[].class);
    }

}