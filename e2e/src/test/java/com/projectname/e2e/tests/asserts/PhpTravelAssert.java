package com.projectname.e2e.tests.asserts;

import com.projectname.e2e.tests.data.model.UserPageDetails;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PhpTravelAssert {

    private SoftAssert softAssert;

    public PhpTravelAssert() {
        softAssert = new SoftAssert();
    }

    public void assertUserDataOnUserPage(UserPageDetails actualDetails, UserPageDetails expectedDetails) {
        if (actualDetails == null) {
            Assert.fail("Actual details are null");
        }

    //    this.softAssert.assertEquals(actualDetails.getCompanyName(), expectedDetails.getCompanyName(), "Company name did not match");
        this.softAssert.assertEquals(actualDetails.getFirstAndLastName(), expectedDetails.getFirstAndLastName(), "Name didn't match");
//        this.softAssert.assertEquals(actualDetails.getAddress1(), expectedDetails.getAddress1(), "Address 1 didn't match");
//        this.softAssert.assertEquals(actualDetails.getAddress2(), expectedDetails.getAddress2(), "Address 2 didn't match");
//        this.softAssert.assertEquals(actualDetails.getCityStatePostalCode(), expectedDetails.getCityStatePostalCode(), "City didn't match");
//        this.softAssert.assertEquals(actualDetails.getCountry(), expectedDetails.getCountry(), "country didn't match");

        this.softAssert.assertEquals(actualDetails.getAddress1(), expectedDetails.getFirstAndLastName() + "\n" + expectedDetails.getAddress1() + "\n"
               + expectedDetails.getAddress2() + "\n" + expectedDetails.getCityStatePostalCode() + "\n" + expectedDetails.getCountry(), "Didn't match");
        this.softAssert.assertAll();
    }

    public void assertUpdatedUserDataOnUserPage(UserPageDetails actualDetails, UserPageDetails expectedDetails) {
        if (actualDetails == null) {
            Assert.fail("Actual details are null");
        }
        this.softAssert.assertEquals(actualDetails.getCompanyName(), expectedDetails.getCompanyName(), "Company name did not match");
        this.softAssert.assertEquals(actualDetails.getFirstAndLastName(), expectedDetails.getFirstAndLastName(), "Name didn't match");
//        this.softAssert.assertEquals(actualDetails.getAddress1(), expectedDetails.getAddress1(), "Address 1 didn't match");
//        this.softAssert.assertEquals(actualDetails.getAddress2(), expectedDetails.getAddress2(), "Address 2 didn't match");
//        this.softAssert.assertEquals(actualDetails.getCityStatePostalCode(), expectedDetails.getCityStatePostalCode(), "City didn't match");
//        this.softAssert.assertEquals(actualDetails.getCountry(), expectedDetails.getCountry(), "country didn't match");

        //  this.softAssert.assertEquals(actualDetails.getAddress1(), expectedDetails.getFirstAndLastName() + "\n" + expectedDetails.getAddress1() + "\n"
        //      + expectedDetails.getAddress2() + "\n" + expectedDetails.getCityStatePostalCode() + "\n" + expectedDetails.getCountry(), "Didn't match");
        this.softAssert.assertAll();
    }
}
