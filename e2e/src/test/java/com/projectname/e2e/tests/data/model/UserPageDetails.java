package com.projectname.e2e.tests.data.model;

public class UserPageDetails {

    private String companyName;
    private String firstAndLastName;
    private String address1;
    private String address2;
    private String cityStatePostalCode;
    private String country;

    public UserPageDetails() {

    }

    public static UserPageDetails parseExpectedUserDetails(RegisterUserRequest userRequest) {
        UserPageDetails userPageDetails = new UserPageDetails();
        userPageDetails.setCompanyName(userRequest.getCompanyName());
        userPageDetails.setFirstAndLastName(userRequest.getFirstName() + " " + userRequest.getLastName());
        userPageDetails.setAddress1(userRequest.getAddress());
        userPageDetails.setAddress2(userRequest.getAddress2());
        userPageDetails.setCityStatePostalCode(userRequest.getCity() + ", " + userRequest.getState() + ", " + userRequest.getPostalCode());
        userPageDetails.setCountry(userRequest.getCountry().getCountryName());

        return userPageDetails;
    }

    public static UserPageDetails parseExpectedUpdatedUserDetails(RegisterUserRequest userRequest) {
        UserPageDetails userPageDetails = new UserPageDetails();
        userPageDetails.setCompanyName(userRequest.getCompanyName());
        userPageDetails.setFirstAndLastName(userRequest.getFirstName() + " " + userRequest.getLastName());
        userPageDetails.setAddress1(userRequest.getAddress());
        userPageDetails.setAddress2(userRequest.getAddress2());
        userPageDetails.setCityStatePostalCode(userRequest.getCity() + ", " + userRequest.getState() + ", " + userRequest.getPostalCode());


        return userPageDetails;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public void setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCityStatePostalCode() {
        return cityStatePostalCode;
    }

    public void setCityStatePostalCode(String cityStatePostalCode) {
        this.cityStatePostalCode = cityStatePostalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
