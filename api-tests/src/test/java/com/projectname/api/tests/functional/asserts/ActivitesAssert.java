package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.activities.common.CommonActivitiesResponse;
import com.projectname.api.client.data.model.activities.GetAllActivitiesResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.projectname.api.tests.functional.suites.ActivitiesTests.*;

public class ActivitesAssert {

    private SoftAssert softAssert;

    public ActivitesAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertActivity(CommonActivitiesResponse actualResponse, CommonActivitiesResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Activity is not posted");
        }
        softAssert.assertEquals(actualResponse.getId(), expectedResponse.getId(), "ID didn't match");
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "Title didn't match");
        softAssert.assertEquals(actualResponse.getDueDate(), expectedResponse.getDueDate().substring(0, actualResponse.getDueDate().length()), "DueDate didn't match");
        softAssert.assertEquals(actualResponse.getCompleted(), expectedResponse.getCompleted(), "Completed didn't match");
        softAssert.assertAll();
    }

    public boolean isActivityExistInList(GetAllActivitiesResponse[] getAllActivitiesResponse) {
        for (int i = 0; i < getAllActivitiesResponse.length; i++) {
            if (getAllActivitiesResponse[i].getId() == activityId) {
                return true;
            }
        }
        return false;
    }
}