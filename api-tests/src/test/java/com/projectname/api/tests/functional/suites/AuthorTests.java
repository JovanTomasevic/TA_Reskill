package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.AuthorsAPI;
import com.projectname.api.client.data.model.authors.common.CommonAuthorResponse;
import com.projectname.api.client.data.model.authors.common.CommonAuthorsRequest;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.AuthorProvider;
import com.projectname.api.tests.functional.asserts.AuthorAssert;
import com.projectname.api.tests.init.TestBase;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class AuthorTests extends TestBase {

    public static AuthorAssert authorAssert = new AuthorAssert();
    public static Integer authorId;
    public static Integer bookId;

    @Test(dataProvider = DataProviderNames.VERIFY_POST_AUTHOR, dataProviderClass = AuthorProvider.class)
    @Description("Verify author posted")
    public static void verifyAuthorPosted(String suffix, CommonAuthorsRequest authorsRequest) {

        CommonAuthorResponse actualResponse = AuthorsAPI.createAuthor(authorsRequest);

        authorId = actualResponse.getId();
        bookId = actualResponse.getIdBook();

        CommonAuthorResponse expectedResponse = CommonAuthorResponse.parseExpectedAuthorResponse(authorsRequest);

        authorAssert.assertAuthor(actualResponse, expectedResponse);


    }

    @Test(dataProvider = DataProviderNames.VERIFY_PUT_AUTHOR, dataProviderClass = AuthorProvider.class)
    @Description("Verify update author")
    public static void verifyUpdateActivity(String suffix, CommonAuthorsRequest authorsRequest) {

        CommonAuthorResponse actualResponse = AuthorsAPI.updatedAuthor(authorsRequest, authorId);

        CommonAuthorResponse expectedResponse = CommonAuthorResponse.parseExpectedAuthorResponse(authorsRequest);

        authorAssert.assertAuthor(actualResponse, expectedResponse);

    }

    @Test
    @Description("Verify getting author by book id")
    public static void verifyGettingAuthorByBookId() {

        CommonAuthorResponse[] commonAuthorResponses = AuthorsAPI.getAuthorByBookId(bookId);

        authorAssert.assertAuthorByBookId(commonAuthorResponses);

    }

    @Test
    @Description("Verify Author Deleted")
    public static void verifyDeleteAuthor() {

        AuthorsAPI.deleteAuthor(authorId);

        CommonAuthorResponse[] getAllAuthorResponse = AuthorsAPI.getAllAuthorResponse();

        authorAssert.assertAuthorDeleted(getAllAuthorResponse);

    }
}