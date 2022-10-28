package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.coverphotos.common.CommonCoverPhotosResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.projectname.api.tests.functional.suites.CoverPhotosTests.*;

public class CoverPhotosAssert {

    private SoftAssert softAssert;

    public CoverPhotosAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertCoverPhoto(CommonCoverPhotosResponse actualResponse, CommonCoverPhotosResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Author is not posted");
        }
        softAssert.assertEquals(actualResponse.getId(), expectedResponse.getId(), "ID didn't match");
        softAssert.assertEquals(actualResponse.getIdBook(), expectedResponse.getIdBook(), "Book ID didn't match");
        softAssert.assertEquals(actualResponse.getUrl(), expectedResponse.getUrl(), "Url didn't match");
        softAssert.assertAll();
    }

    public void assertCoverPhotoByBookId(CommonCoverPhotosResponse[] commonCoverPhotosResponses) {
        if (commonCoverPhotosResponses == null) {
            Assert.fail("Author is not connected to book id");
        }
        for (int i = 0; i < commonCoverPhotosResponses.length; i++) {
            Assert.assertEquals(commonCoverPhotosResponses[i].getId(), coverPhotoId, "Cover Photo is not connected to the book");
        }
        softAssert.assertAll();
    }

    public void assertCoverPhotoDeleted(CommonCoverPhotosResponse[] getAllCoverPhotos) {
        for(int i = 0; i < getAllCoverPhotos.length; i++){
            Assert.assertNotEquals(getAllCoverPhotos[i].getId(), coverPhotoId, "Cover Photo is NOT deleted");
        }
        softAssert.assertAll();
    }
}