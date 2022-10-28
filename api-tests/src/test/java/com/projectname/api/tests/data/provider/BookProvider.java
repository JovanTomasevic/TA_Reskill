package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.books.common.CommonBookRequest;
import com.projectname.api.client.utils.Dates;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;

public class BookProvider {

    @DataProvider(name = DataProviderNames.VERIFY_POST_BOOK)
    public static Object[][] verifyPostBook() {
        return new Object[][]{
                {"Random", prepareRandomBookRequest()},
                {"Specified", new CommonBookRequest(10, "TitleNeki", "Description", 112, "Excerpt", "2022-04-04T00:00:00")}
        };
    }

    public static CommonBookRequest prepareRandomBookRequest() {
        CommonBookRequest commonBookRequest = new CommonBookRequest();
        commonBookRequest.setId(RandomStringGenerator.createRandomWholeNumberInteger(0,1000));
        commonBookRequest.setTitle(RandomStringGenerator.createRandomStringWithLen(10));
        commonBookRequest.setDescription(RandomStringGenerator.createRandomStringWithLen(50));
        commonBookRequest.setPageCount(RandomStringGenerator.createRandomWholeNumberInteger(0,1000));
        commonBookRequest.setExcerpt(RandomStringGenerator.createRandomStringWithLen(10));
        commonBookRequest.setPublishDate(Dates.getRandomDateTime());
        return commonBookRequest;
    }

    @DataProvider(name = DataProviderNames.VERIFY_PUT_BOOK)
    public static Object[][] verifyPutBook() {
        return new Object[][]{
                {"Random PUT", prepareRandomBookRequest()},
                {"Specified PUT", new CommonBookRequest(16, "TitleNekiSpecified", "DescriptionSpecified", 212, "ExcerptSpecified", "2022-07-07T00:00:00")}
        };
    }
}
