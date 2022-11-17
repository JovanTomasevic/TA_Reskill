package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.activities.common.CommonActivitiesRequest;
import com.projectname.api.client.utils.Dates;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;


public class ActivityProvider {

    @DataProvider(name = DataProviderNames.VERIFY_POST_ACTIVITY)
    public static Object[][] verifyPostActivity() {
        return new Object[][]{
                {"Random", prepareRandomActivityRequest()},
                {"Specified", new CommonActivitiesRequest(5, "titleNeki", "2022-04-04T00:00:00", true)}
        };
    }

    public static CommonActivitiesRequest prepareRandomActivityRequest() {
        CommonActivitiesRequest commonActivitiesRequest = new CommonActivitiesRequest();
        commonActivitiesRequest.setId(RandomStringGenerator.createRandomWholeNumberInteger(0,1000));
        commonActivitiesRequest.setTitle(RandomStringGenerator.createRandomStringWithLen(6));
        commonActivitiesRequest.setDueDate(Dates.getRandomDateTime());
        commonActivitiesRequest.setCompleted(true);
        return commonActivitiesRequest;
    }

    @DataProvider(name = DataProviderNames.VERIFY_PUT_ACTIVITY)
    public static Object[][] verifyPutActivity() {
        return new Object[][]{
                {"Random PUT", prepareRandomActivityRequest()},
                {"Specified PUT", new CommonActivitiesRequest(7, "titlePUT", "2022-04-04T00:00:00", true)}
        };
    }
}