package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.BookAPI;
import com.projectname.api.client.data.model.books.common.CommonBookRequest;
import com.projectname.api.client.data.model.books.common.CommonBookResponse;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.BookProvider;
import com.projectname.api.tests.functional.asserts.BookAssert;
import com.projectname.api.tests.init.TestBase;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class BookTests extends TestBase {

    public static BookAssert bookAssert = new BookAssert();
    public static Integer bookId;

    @Test(priority = 1, dataProvider = DataProviderNames.VERIFY_POST_BOOK, dataProviderClass = BookProvider.class)
    @Description("Verify book posted")
    public static void verifyBookPosted(String suffix, CommonBookRequest bookRequest) {

        CommonBookResponse actualResponse = BookAPI.createBook(bookRequest);

        bookId = actualResponse.getId();

        CommonBookResponse expectedResponse = CommonBookResponse.parseExpectedBookResponse(bookRequest);

        bookAssert.assertBook(actualResponse, expectedResponse);
    }

    @Test(priority = 2, dataProvider = DataProviderNames.VERIFY_PUT_BOOK, dataProviderClass = BookProvider.class)
    @Description("Verify update book")
    public static void verifyUpdateActivity(String suffix, CommonBookRequest bookRequest) {

        CommonBookResponse actualResponse = BookAPI.updatedBook(bookRequest,bookId);

        CommonBookResponse expectedResponse = CommonBookResponse.parseExpectedBookResponse(bookRequest);

        bookAssert.assertBook(actualResponse,expectedResponse);

    }

    @Test(priority = 3)
    @Description("Verify delete book")
    public static void verifyBookDeleted() {
        BookAPI.deleteBook(bookId);

        CommonBookResponse[] getAllBooksResponse = BookAPI.getAllBookResponse();

        bookAssert.assertBookDeleted(getAllBooksResponse);
    }
}