package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.activities.common.CommonActivitiesRequest;
import com.projectname.api.client.data.model.activities.common.CommonActivitiesResponse;
import com.projectname.api.client.data.model.activities.GetAllActivitiesResponse;
import com.projectname.api.client.data.model.common.EmptyResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class ActivitiesAPI {

    public static GetAllActivitiesResponse[] getAllActivitiesResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.ACTIVITIES), GetAllActivitiesResponse[].class);
    }

    public static CommonActivitiesResponse createActivity(CommonActivitiesRequest activitiesRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(activitiesRequest, ApiEndpoints.ACTIVITIES), CommonActivitiesResponse.class);
    }

    public static CommonActivitiesResponse updatedActivity(CommonActivitiesRequest activitiesRequest ,Integer activityId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(activitiesRequest, ApiEndpoints.ACTIVITY(activityId)), CommonActivitiesResponse.class);
    }

    public static EmptyResponse deleteActivity(Integer activityId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.ACTIVITY(activityId)), EmptyResponse.class);
    }
}