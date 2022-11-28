package com.projectname.e2e.tests.suites;

import com.projectname.e2e.tests.asserts.PhpTravelAssert;
import com.projectname.e2e.tests.data.model.RegisterUserRequest;
import com.projectname.e2e.tests.data.model.UserPageDetails;
import com.projectname.e2e.tests.data.provider.phptravels.PhpTravelsProvider;
import com.projectname.e2e.tests.pages.AccountUpdatePage;
import com.projectname.e2e.tests.pages.LoginPage;
import com.projectname.e2e.tests.pages.SignupPage;
import com.projectname.e2e.tests.pages.UserPage;
import com.projectname.e2e.tests.pages.common.NavigationBarPage;
import com.projectname.e2e.tests.suites.common.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignupTests extends TestBase {

    PhpTravelAssert phpTravelAssert = new PhpTravelAssert();


    @Test
    public void verifyUserIsRegistered() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");
        navigationBarPage.show();

        SignupPage signupPage = new SignupPage(getDriver(), "", "", "");
        signupPage.show();

        RegisterUserRequest userRequest = PhpTravelsProvider.prepareRegisterUserRequest();

        UserPage userPage = signupPage.registerNewUser(userRequest);

        UserPageDetails actualUserDetails = userPage.getActualUserDetails();

        UserPageDetails expectedUserDetails = UserPageDetails.parseExpectedUserDetails(userRequest);

        phpTravelAssert.assertUserDataOnUserPage(actualUserDetails, expectedUserDetails);

    }

    @Test
    public void verifyUserDataUpdated() {
        LoginPage loginPage =new LoginPage(getDriver(), "", "", "");
        loginPage.show();

        loginPage.loginUser();

        AccountUpdatePage accountUpdatePage = new AccountUpdatePage(getDriver(),"","","");
        accountUpdatePage.show();

        RegisterUserRequest userRequest = PhpTravelsProvider.prepareUpdateUserRequest();

        accountUpdatePage.updateUser(userRequest);


        UserPage userPage = new UserPage(getDriver(), "","","");
        userPage.show();

        UserPageDetails actualUserDetails = userPage.getActualUserDetails();

        UserPageDetails expectedUserDetails = UserPageDetails.parseExpectedUpdatedUserDetails(userRequest);

        phpTravelAssert.assertUpdatedUserDataOnUserPage(actualUserDetails, expectedUserDetails);
    }
}
