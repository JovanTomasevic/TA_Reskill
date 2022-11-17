package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.authors.common.CommonAuthorsRequest;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;


public class AuthorProvider {

    @DataProvider(name = DataProviderNames.VERIFY_POST_AUTHOR)
    public static Object[][] verifyPostAuthor() {
        return new Object[][]{
                {"Random", prepareRandomAuthorsRequest()},
                {"Specified", new CommonAuthorsRequest(5, 17, "firstName", "lastName")}
        };
    }

    public static CommonAuthorsRequest prepareRandomAuthorsRequest() {
        CommonAuthorsRequest commonAuthorsRequest = new CommonAuthorsRequest();
        commonAuthorsRequest.setId(RandomStringGenerator.createRandomWholeNumberInteger(0,1000));
        commonAuthorsRequest.setIdBook(RandomStringGenerator.createRandomWholeNumberInteger(0,1000));
        commonAuthorsRequest.setFirstName(RandomStringGenerator.createRandomStringWithLen(7));
        commonAuthorsRequest.setLastName(RandomStringGenerator.createRandomStringWithLen(7));
        return commonAuthorsRequest;
    }

    @DataProvider(name = DataProviderNames.VERIFY_PUT_AUTHOR)
    public static Object[][] verifyPutAuthor() {
        return new Object[][]{
                {"Random PUT", prepareRandomAuthorsRequest()},
                {"Specified PUT", new CommonAuthorsRequest(7, 17, "putFirstName", "putLastName")}
        };
    }
}