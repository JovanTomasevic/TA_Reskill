package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.crocodiles.*;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class CrocodilesAPI {

    public static LoginResponse loginUser(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(loginRequest, ApiEndpoints.LOGIN_USER), LoginResponse.class);
    }

    public static CrocodileResponse createCrocodile(String accessToken, CrocodileRequest createCrocodile) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(createCrocodile, accessToken, ApiEndpoints.CREATE_CROCODILE), CrocodileResponse.class);
    }

    public static CrocodileResponse updateCrocodile(String accessToken, CrocodileRequest updateCrocodile, Integer id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(updateCrocodile,accessToken,ApiEndpoints.GET_MY_CROCODILE(id)), CrocodileResponse.class);
    }

    public static CrocodileErrorResponse getSingleCrocWithError(String accessToken, Integer id) {
        return GsonFunctions.parseErrorResponseToModel(RestAssuredFunctions.get(accessToken, ApiEndpoints.GET_MY_CROCODILE(id)), CrocodileErrorResponse.class);
    }

    public static CrocodileErrorResponse updateCrocWithDifferenUser(String accessToken, Integer id) {
        return GsonFunctions.parseErrorResponseToModel(RestAssuredFunctions.put(accessToken, ApiEndpoints.GET_MY_CROCODILE(id)), CrocodileErrorResponse.class);
    }

    public static CrocodileErrorResponse loginWithNonExistingUserError(LoginRequest loginRequest) {
        return GsonFunctions.parseErrorResponseToModel(RestAssuredFunctions.post(loginRequest, ApiEndpoints.LOGIN_USER),CrocodileErrorResponse.class);
    }
    public static RequiredCrocFieldErrorResponse createCrocodileWithRequiredFieldError(String accessToken, CrocodileRequest crocodileRequest) {
        return GsonFunctions.parseErrorResponseToModel(RestAssuredFunctions.post(crocodileRequest, accessToken, ApiEndpoints.CREATE_CROCODILE), RequiredCrocFieldErrorResponse.class);
    }

    public static RequiredCrocFieldErrorResponse updateCrocodileWithRequiredFieldError(String accessToken, CrocodileRequest crocodileRequest, Integer id) {
        return GsonFunctions.parseErrorResponseToModel(RestAssuredFunctions.put(crocodileRequest, accessToken, ApiEndpoints.GET_MY_CROCODILE(id)), RequiredCrocFieldErrorResponse.class);
    }

    public static CrocodileErrorResponse deleteCrocWithDifferentUser(String accessToken, Integer id) {
        return GsonFunctions.parseErrorResponseToModel(RestAssuredFunctions.delete(accessToken, ApiEndpoints.GET_MY_CROCODILE(id)), CrocodileErrorResponse.class);
    }

    public static RequiredUserRegisterFieldErrorResponse createUserWithRequiredFieldError(RegisterUserRequest registerUserRequest) {
        return GsonFunctions.parseErrorResponseToModel(RestAssuredFunctions.post(registerUserRequest, ApiEndpoints.REGISTER_USER), RequiredUserRegisterFieldErrorResponse.class);
    }
}
