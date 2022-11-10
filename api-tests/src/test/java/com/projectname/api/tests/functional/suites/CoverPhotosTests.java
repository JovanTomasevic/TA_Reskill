package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.CoverPhotosAPI;
import com.projectname.api.client.data.model.coverphotos.common.CommonCoverPhotosRequest;
import com.projectname.api.client.data.model.coverphotos.common.CommonCoverPhotosResponse;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.CoverPhotoProvider;
import com.projectname.api.tests.functional.asserts.CoverPhotosAssert;
import com.projectname.api.tests.init.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CoverPhotosTests extends TestBase {

    public static CoverPhotosAssert coverPhotosAssert = new CoverPhotosAssert();

    CommonCoverPhotosRequest commonCoverPhotosRequest;
    public static Integer coverPhotoId;
    public static Integer bookId;

    @BeforeClass
    public void prepareTestData() {
        commonCoverPhotosRequest = CoverPhotoProvider.prepareRandomCoverPhotoRequest();
        coverPhotoId = CoverPhotosAPI.createCoverPhoto(commonCoverPhotosRequest).getId();
        bookId = CoverPhotosAPI.createCoverPhoto(commonCoverPhotosRequest).getIdBook();

    }

    @Test(dataProvider = DataProviderNames.VERIFY_POST_COVER_PHOTO, dataProviderClass = CoverPhotoProvider.class)
    @Description("Verify cover photo posted")
    public static void verifyCoverPhotoPosted(String suffix, CommonCoverPhotosRequest coverPhotoRequest) {

        CommonCoverPhotosResponse actualResponse = CoverPhotosAPI.createCoverPhoto(coverPhotoRequest);


        CommonCoverPhotosResponse expectedResponse = CommonCoverPhotosResponse.parseExpectedCoverPhotosResponse(coverPhotoRequest);

        coverPhotosAssert.assertCoverPhoto(actualResponse, expectedResponse);

    }

    @Test(dataProvider = DataProviderNames.VERIFY_PUT_COVER_PHOTO, dataProviderClass = CoverPhotoProvider.class)
    @Description("Verify update cover photo")
    public static void verifyUpdateCoverPhoto(String suffix, CommonCoverPhotosRequest coverPhotoRequest) {

        CommonCoverPhotosResponse actualResponse = CoverPhotosAPI.updatedCoverPhoto(coverPhotoRequest, coverPhotoId);

        CommonCoverPhotosResponse expectedResponse = CommonCoverPhotosResponse.parseExpectedCoverPhotosResponse(coverPhotoRequest);

        coverPhotosAssert.assertCoverPhoto(actualResponse, expectedResponse);

    }

    @Test
    @Description("Verify getting cover photo by book id")
    public static void verifyGettingCoverPhotoByBookId() {

        CommonCoverPhotosResponse[] commonCoverPhotosResponse = CoverPhotosAPI.getCoverPhotoByBookId(bookId);

        coverPhotosAssert.assertCoverPhotoByBookId(commonCoverPhotosResponse);

    }

    @Test
    @Description("Verify Author Deleted")
    public static void verifyDeleteCoverPhoto() {

        CoverPhotosAPI.deleteCoverPhoto(coverPhotoId);

        Assert.assertTrue(coverPhotosAssert.isCoverPhotoExistInList(CoverPhotosAPI.getAllCoverPhotoResponse()));

    }

}