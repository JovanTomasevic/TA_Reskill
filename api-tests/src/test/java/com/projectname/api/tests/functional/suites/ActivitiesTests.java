package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.ActivitiesAPI;
import com.projectname.api.client.data.model.activities.common.CommonActivitiesRequest;
import com.projectname.api.client.data.model.activities.common.CommonActivitiesResponse;
import com.projectname.api.client.data.model.activities.GetAllActivitiesResponse;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.ActivityProvider;
import com.projectname.api.tests.functional.asserts.ActivitesAssert;
import com.projectname.api.tests.init.TestBase;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class ActivitiesTests extends TestBase {

    public static ActivitesAssert activitesAssert = new ActivitesAssert();
    public static Integer activityId;


    @Test(dataProvider = DataProviderNames.VERIFY_POST_ACTIVITY, dataProviderClass = ActivityProvider.class)
    @Description("Verify activity posted")
    public static void verifyActivityPosted(String suffix, CommonActivitiesRequest activityRequest) {

        CommonActivitiesResponse actualResponse = ActivitiesAPI.createActivity(activityRequest);

        activityId = actualResponse.getId();

        CommonActivitiesResponse expectedResponse = CommonActivitiesResponse.parseExpectedActivitiesResponse(activityRequest);

        activitesAssert.assertActivity(actualResponse, expectedResponse);
    }

    @Test(dataProvider = DataProviderNames.VERIFY_PUT_ACTIVITY, dataProviderClass = ActivityProvider.class)
    @Description("Verify update activity")
    public static void verifyUpdateActivity(String suffix, CommonActivitiesRequest activityRequest) {

        CommonActivitiesResponse actualResponse = ActivitiesAPI.updatedActivity(activityRequest, activityId);

        CommonActivitiesResponse expectedResponse = CommonActivitiesResponse.parseExpectedActivitiesResponse(activityRequest);

        activitesAssert.assertActivity(actualResponse, expectedResponse);

    }

    @Test
    @Description("Verify Activity Deleted")
    public static void verifyDeleteActivity() {

        ActivitiesAPI.deleteActivity(activityId);

        GetAllActivitiesResponse[] getAllActivitiesResponse = ActivitiesAPI.getAllActivitiesResponse();

        activitesAssert.assertActivityDeleted(getAllActivitiesResponse);

    }

}