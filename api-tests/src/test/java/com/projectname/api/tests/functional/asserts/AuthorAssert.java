package com.projectname.api.tests.functional.asserts;


import com.projectname.api.client.data.model.authors.common.CommonAuthorResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import static com.projectname.api.tests.functional.suites.AuthorTests.*;

public class AuthorAssert {

    private SoftAssert softAssert;

    public AuthorAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertAuthor(CommonAuthorResponse actualResponse, CommonAuthorResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Author is not posted");
        }
        softAssert.assertEquals(actualResponse.getId(), expectedResponse.getId(), "ID didn't match");
        softAssert.assertEquals(actualResponse.getIdBook(), expectedResponse.getIdBook(), "Book ID didn't match");
        softAssert.assertEquals(actualResponse.getFirstName(), expectedResponse.getFirstName(), "First name didn't match");
        softAssert.assertEquals(actualResponse.getLastName(), expectedResponse.getLastName(), "Last name didn't match");
        softAssert.assertAll();
    }

    public void assertAuthorByBookId(CommonAuthorResponse[] commonAuthorResponses) {
        if (commonAuthorResponses == null) {
            Assert.fail("Author is not connected to book id");
        }
        for (int i = 0; i < commonAuthorResponses.length; i++) {
            Assert.assertEquals(commonAuthorResponses[i].getId(), authorId, "Author is not connected to the book");
        }
        softAssert.assertAll();
    }

    public void assertAuthorDeleted(CommonAuthorResponse[] getAllAuthors) {
        for(int i = 0; i < getAllAuthors.length; i++){
            Assert.assertNotEquals(getAllAuthors[i].getId(), authorId, "Author is NOT deleted");
        }
        softAssert.assertAll();
    }
}