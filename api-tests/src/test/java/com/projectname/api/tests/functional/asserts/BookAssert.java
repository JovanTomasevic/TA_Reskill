package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.calls.ActivitiesAPI;
import com.projectname.api.client.data.model.books.common.CommonBookResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.projectname.api.tests.functional.suites.BookTests.*;

public class BookAssert {

    private SoftAssert softAssert;

    public BookAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertBook(CommonBookResponse actualResponse, CommonBookResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Book is not posted");
        }
        softAssert.assertEquals(actualResponse.getId(), expectedResponse.getId(), "ID didn't match");
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "Title didn't match");
        softAssert.assertEquals(actualResponse.getDescription(), expectedResponse.getDescription(), "Description didn't match");
        softAssert.assertEquals(actualResponse.getPageCount(), expectedResponse.getPageCount(), "Page count didn't match");
        softAssert.assertEquals(actualResponse.getExcerpt(), expectedResponse.getExcerpt(), "Excerpt didn't match");
        softAssert.assertEquals(actualResponse.getPublishDate(), expectedResponse.getPublishDate().substring(0, actualResponse.getPublishDate().length()), "Publish Date didn't match");
        softAssert.assertAll();
    }

    public boolean isBookExistInList(CommonBookResponse[] getAllBooks) {
        for (int i = 0; i < getAllBooks.length; i++) {

            if (getAllBooks[i].getId() == bookId) {
                return true;
            }
        }
        return false;
    }

}