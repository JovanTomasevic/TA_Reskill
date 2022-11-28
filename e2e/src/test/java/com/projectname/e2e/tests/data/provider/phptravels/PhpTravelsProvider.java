package com.projectname.e2e.tests.data.provider.phptravels;

import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.e2e.tests.data.enums.Country;
import com.projectname.e2e.tests.data.model.RegisterUserRequest;

public class PhpTravelsProvider {

    public static RegisterUserRequest prepareRegisterUserRequest() {
        RegisterUserRequest userRequest = new RegisterUserRequest();

        userRequest.setFirstName(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setLastName(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setEmail(RandomStringGenerator.createRandomEmailWithPrefixLen(8));
        userRequest.setPhoneNumber(RandomStringGenerator.createRandomStringNumericWithLen(7));
        userRequest.setAddress(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setAddress2(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setCity(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setState(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setPostalCode(RandomStringGenerator.createRandomStringNumericWithLen(6));
        userRequest.setCountry(Country.getRandomCountry());
        userRequest.setPassword(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setMobile(RandomStringGenerator.createRandomStringNumericWithLen(7));

        return userRequest;
    }

    public static RegisterUserRequest prepareUpdateUserRequest() {
        RegisterUserRequest userRequest = new RegisterUserRequest();

        userRequest.setFirstName(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setLastName(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setAddress(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setAddress2(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setCity(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setState(RandomStringGenerator.createRandomStringAlphabeticWithLen(8));
        userRequest.setPostalCode(RandomStringGenerator.createRandomStringNumericWithLen(6));

        return userRequest;
    }
}
