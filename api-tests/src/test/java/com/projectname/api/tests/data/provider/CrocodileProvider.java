package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.crocodiles.*;
import com.projectname.api.client.utils.Dates;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.constants.ErrorMessages;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class CrocodileProvider {

    @DataProvider(name = DataProviderNames.VERIFY_CROC_REQUIRED_FIELD)
    public static Object[][] verifyCannotCreateCrocWithoutRequiredField() {
        return new Object[][]{
                {"whenNameIsNull", new CrocodileRequest(null, RandomStringGenerator.getRandomSex(), Dates.getRandomDate()), RequiredCrocFieldErrorResponse.prepareErrorForName(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))},
                {"whenSexIsNull", new CrocodileRequest(RandomStringGenerator.createRandomStringWithLen(6), null, Dates.getRandomDate()), RequiredCrocFieldErrorResponse.prepareErrorForSex(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))},
                {"whenDateIsNull", new CrocodileRequest(RandomStringGenerator.createRandomStringWithLen(6), RandomStringGenerator.getRandomSex(), null), RequiredCrocFieldErrorResponse.prepareErrorForDate(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))}
        };
    }

    @DataProvider(name = DataProviderNames.VERIFY_USER_REGISTER_REQUIRED_FIELD)
    public static Object[][] verifyCannotCreateUserWithoutRequiredField() {
        return new Object[][]{
                {"whenUserNameIsNull", new RegisterUserRequest(null, RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomEmailWithPrefixLen(12), RandomStringGenerator.createRandomStringAlphanumericWithLen(6)), RequiredUserRegisterFieldErrorResponse.prepareErrorForUsername(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))},
                {"whenFirstNameIsNull", new RegisterUserRequest(RandomStringGenerator.createRandomStringAlphanumericWithLen(6), null, RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomEmailWithPrefixLen(12), RandomStringGenerator.createRandomStringAlphanumericWithLen(6)), RequiredUserRegisterFieldErrorResponse.prepareErrorForFirstName(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))},
                {"whenLastNameIsNull", new RegisterUserRequest(RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6), null, RandomStringGenerator.createRandomEmailWithPrefixLen(12), RandomStringGenerator.createRandomStringAlphanumericWithLen(6)), RequiredUserRegisterFieldErrorResponse.prepareErrorForLastName(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))},
                {"whenEmailIsNull", new RegisterUserRequest(RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6), null, RandomStringGenerator.createRandomStringAlphanumericWithLen(6)), RequiredUserRegisterFieldErrorResponse.prepareErrorForEmail(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))},
                {"whenPasswordIsNull", new RegisterUserRequest(RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomEmailWithPrefixLen(12), null), RequiredUserRegisterFieldErrorResponse.prepareErrorForPassword(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED))},
                {"whenEmailIsWrongFormat", new RegisterUserRequest(RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6)), RequiredUserRegisterFieldErrorResponse.prepareErrorForEmail(Arrays.asList(ErrorMessages.EMAIL_WRONG_FORMAT))},
        };
    }


    public static CrocodileRequest prepareCrocodileRequest() {
        CrocodileRequest createCrocodile = new CrocodileRequest(RandomStringGenerator.createRandomStringWithLen(6), RandomStringGenerator.getRandomSex(), Dates.getRandomDate());
        return createCrocodile;
    }

    public static RequiredCrocFieldErrorResponse prepareErrorMessageForSex() {
        RequiredCrocFieldErrorResponse errorResponse = new RequiredCrocFieldErrorResponse();
        errorResponse.setSex(Arrays.asList(ErrorMessages.FIELD_IS_REQUIRED));
        return errorResponse;
    }


    public static LoginRequest prepareLoginRequest() {
        LoginRequest loginRequest = new LoginRequest(RandomStringGenerator.createRandomStringAlphabeticWithLen(6), RandomStringGenerator.createRandomStringAlphanumericWithLen(6));
        return loginRequest;
    }
}


