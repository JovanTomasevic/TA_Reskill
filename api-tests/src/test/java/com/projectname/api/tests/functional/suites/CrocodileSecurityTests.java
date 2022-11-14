package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.CrocodilesAPI;
import com.projectname.api.client.data.model.crocodiles.*;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.constants.ErrorMessages;
import com.projectname.api.tests.data.provider.CrocodileProvider;
import com.projectname.api.tests.environment.ConfigSetup;
import com.projectname.api.tests.functional.asserts.CommonErrorAssert;
import com.projectname.api.tests.init.TestBase;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CrocodileSecurityTests extends TestBase {

    CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
    String accessTokenMainUser;
    String accessTokenSecondUser;

    Integer crocId;

    @BeforeClass
    public void prepareDataForTest() {
        RestAssured.baseURI = ConfigSetup.getCrocBaseUrl();
        accessTokenMainUser = CrocodilesAPI.loginUser(new LoginRequest(ConfigSetup.getMainUser(), ConfigSetup.getPass())).getAccess();
        accessTokenSecondUser = CrocodilesAPI.loginUser(new LoginRequest(ConfigSetup.getSecondUser(), ConfigSetup.getPass())).getAccess();
        crocId = CrocodilesAPI.createCrocodile(accessTokenMainUser, CrocodileProvider.prepareCrocodileRequest()).getId();
    }

    @Test
    public void verifyCannotLoginWithNonExistingUser() {

        CrocodileErrorResponse actualError = CrocodilesAPI.loginWithNonExistingUserError(CrocodileProvider.prepareLoginRequest());
        commonErrorAssert.assertCrocodileErrorResponse(actualError, new CrocodileErrorResponse(ErrorMessages.NO_ACTIVE_ACCOUNT));

    }

    @Test
    public void verifyCannotDeleteCrocodileFromAnotherUser() {

        CrocodileErrorResponse actualError = CrocodilesAPI.deleteCrocWithDifferentUser(accessTokenSecondUser, crocId);

        commonErrorAssert.assertCrocodileErrorResponse(actualError, new CrocodileErrorResponse(ErrorMessages.NOT_FOUND));
    }

    @Test
    public void verifyCannotGetCrocodileFromAnotherUser() {

        CrocodileErrorResponse actualError = CrocodilesAPI.getSingleCrocWithError(accessTokenSecondUser, crocId);

        commonErrorAssert.assertCrocodileErrorResponse(actualError, new CrocodileErrorResponse(ErrorMessages.NOT_FOUND));
    }

    @Test
    public void verifyCannotUpdateCrocodileFromAnotherUser() {

        CrocodileErrorResponse actualError = CrocodilesAPI.updateCrocWithDifferenUser(accessTokenSecondUser, crocId);

        commonErrorAssert.assertCrocodileErrorResponse(actualError, new CrocodileErrorResponse(ErrorMessages.NOT_FOUND));
    }

    @Test(dataProvider = DataProviderNames.VERIFY_CROC_REQUIRED_FIELD, dataProviderClass = CrocodileProvider.class)
    public void verifyCannotCreateCrocodileWithoutRequiredFields(String suffix, CrocodileRequest crocodileRequest, RequiredCrocFieldErrorResponse expectedError) {
        RequiredCrocFieldErrorResponse actualError = CrocodilesAPI.createCrocodileWithRequiredFieldError(accessTokenMainUser, crocodileRequest);

        commonErrorAssert.assertRequiredFieldErrors(actualError, expectedError);
    }

    @Test(dataProvider = DataProviderNames.VERIFY_CROC_REQUIRED_FIELD, dataProviderClass = CrocodileProvider.class)
    public void verifyCannotUpdateCrocodileWithoutRequiredFields(String suffix, CrocodileRequest crocodileRequest, RequiredCrocFieldErrorResponse expectedError) {
        RequiredCrocFieldErrorResponse actualError = CrocodilesAPI.updateCrocodileWithRequiredFieldError(accessTokenMainUser, crocodileRequest, crocId);

        commonErrorAssert.assertRequiredFieldErrors(actualError, expectedError);
    }

    @Test(dataProvider = DataProviderNames.VERIFY_USER_REGISTER_REQUIRED_FIELD, dataProviderClass = CrocodileProvider.class)
    public void verifyCannotCreateUserWithoutRequiredFields(String suffix, RegisterUserRequest registerUserRequest, RequiredUserRegisterFieldErrorResponse expectedError) {
        RequiredUserRegisterFieldErrorResponse actualError = CrocodilesAPI.createUserWithRequiredFieldError(registerUserRequest);

        commonErrorAssert.assertUserRequiredFieldErrors(actualError, expectedError);
    }


}
