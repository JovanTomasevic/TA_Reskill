package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.authors.common.CommonAuthorsRequest;
import com.projectname.api.client.data.model.coverphotos.common.CommonCoverPhotosRequest;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;

public class CoverPhotoProvider {

    @DataProvider(name = DataProviderNames.VERIFY_POST_COVER_PHOTO)
    public static Object[][] verifyPostCoverPhoto() {
        return new Object[][]{
                {"Random", prepareRandomCoverPhotoRequest()},
                {"Specified", new CommonCoverPhotosRequest(4, 12, "https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 5&w=250&h=350")}
        };
    }

    @DataProvider(name = DataProviderNames.VERIFY_PUT_COVER_PHOTO)
    public static Object[][] verifyPutCoverPhoto() {
        return new Object[][]{
                {"Random PUT", prepareRandomCoverPhotoRequest()},
                {"Specified PUT", new CommonCoverPhotosRequest(54, 142, "https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 34fd")}
        };
    }

    public static CommonCoverPhotosRequest prepareRandomCoverPhotoRequest() {
        CommonCoverPhotosRequest commonCoverPhotosRequest = new CommonCoverPhotosRequest();
        commonCoverPhotosRequest.setId(RandomStringGenerator.createRandomWholeNumberInteger(0, 1000));
        commonCoverPhotosRequest.setIdBook(RandomStringGenerator.createRandomWholeNumberInteger(0, 1000));
        commonCoverPhotosRequest.setUrl("https://placeholdit.imgix.net" + RandomStringGenerator.createRandomStringWithLen(7));
        return commonCoverPhotosRequest;
    }
}