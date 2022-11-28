package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.data.model.RegisterUserRequest;
import com.projectname.e2e.tests.pages.common.NavigationBarPage;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SignupPage extends PageBase {
    public SignupPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if(!isDisplayed()) {
            NavigationBarPage navigationBarPage = new NavigationBarPage(driver, url, email, password);
            navigationBarPage.openSignupPage();
        }
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"containerNewUserSignup\"]/div[1]/div/h3"), driver);
    }

    private WebElement getInputFirstNameField() {
        try {
            return driver.findElement(CustomBy.id("inputFirstName"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find input first name field on Signup page", e);
        }
    }

    private WebElement getLastNameField() {
        try {
            return driver.findElement(CustomBy.id("inputLastName"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find last name field on Signup page", e);
        }
    }

    private WebElement getEmailField() {
        try {
            return driver.findElement(CustomBy.id("inputEmail"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find email field on Signup page", e);
        }
    }

    private WebElement getCountryNumberButton() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"containerNewUserSignup\"]/div[1]/div/div/div[4]/div/div/div/div/div[2]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find country number button field on Signup page", e);
        }
    }

    private List<WebElement> getCountriesListNumberButton() {
        try {
            return driver.findElements(CustomBy.className("country-name"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find countries list on Signup page", e);
        }
    }

    private WebElement getCountryFromTheListOfCountries(String country) {
        getCountryNumberButton().click();
        List<WebElement> countries = getCountriesListNumberButton();
        for(WebElement countryElement : countries) {
            if (countryElement.getText().equals(country)) {
                return countryElement;
            }
        }
        throw new AssertionError("Could not find country in the list of countries on Signup page");
    }

    private WebElement getInputPhoneField() {
        try {
            return driver.findElement(CustomBy.id("inputPhone"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address field on Signup page", e);
        }
    }

    private WebElement getStreetAddressField() {
        try {
            return driver.findElement(CustomBy.id("inputAddress1"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address field on Signup page", e);
        }
    }

    private WebElement getStreetAddress2Field() {
        try {
            return driver.findElement(CustomBy.id("inputAddress2"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Signup page", e);
        }
    }

    private WebElement getCityField() {
        try {
            return driver.findElement(CustomBy.id("inputCity"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Signup page", e);
        }
    }

    private WebElement getStateField() {
        try {
            return driver.findElement(CustomBy.id("stateinput"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Signup page", e);
        }
    }

    private WebElement getPostcodeField() {
        try {
            return driver.findElement(CustomBy.id("inputPostcode"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Signup page", e);
        }
    }

    private WebElement getCountryField() {
        try {
            return driver.findElement(CustomBy.id("inputCountry"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find country field on Signup page", e);
        }
    }

    private void selectCountry(String country) {
        Select countries = new Select(getCountryField());
        countries.selectByValue(country);
    }

    private WebElement getMobileField() {
        try {
            return driver.findElement(CustomBy.id("customfield2"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find not a robot checkbox on Signup page", e);
        }
    }

    private WebElement getPasswordButton() {
        try {
            return driver.findElement(CustomBy.id("inputNewPassword1"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find input password field on Signup page", e);
        }
    }

    private WebElement getConfirmPasswordButton() {
        try {
            return driver.findElement(CustomBy.id("inputNewPassword2"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find confirm password field on Signup page", e);
        }
    }

    private WebElement getMailingListSwitch() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"frmCheckout\"]/div[3]/div/div/div/span[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find mailing list switch on Signup page", e);
        }
    }

    private WebElement getRegisterButton() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"frmCheckout\"]/p/input"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find not a robot checkbox on Signup page", e);
        }
    }

    public UserPage registerNewUser(RegisterUserRequest userRequest) {
        getInputFirstNameField().click();
        getInputFirstNameField().clear();
        getInputFirstNameField().sendKeys(userRequest.getFirstName());

        getLastNameField().click();
        getLastNameField().clear();
        getLastNameField().sendKeys(userRequest.getLastName());

        getEmailField().click();
        getEmailField().clear();
        getEmailField().sendKeys(userRequest.getEmail());

        getCountryFromTheListOfCountries(userRequest.getCountry().getCountryNumberSelect()).click();

        getInputPhoneField().click();
        getInputPhoneField().clear();
        getInputPhoneField().sendKeys(userRequest.getPhoneNumber());

        getStreetAddressField().click();
        getStreetAddressField().clear();
        getStreetAddressField().sendKeys(userRequest.getAddress());

        getStreetAddress2Field().click();
        getStreetAddress2Field().clear();
        getStreetAddress2Field().sendKeys(userRequest.getAddress2());

        getCityField().click();
        getCityField().clear();
        getCityField().sendKeys(userRequest.getCity());

        getStateField().click();
        getStateField().clear();
        getStateField().sendKeys(userRequest.getState());

        getPostcodeField().click();
        getPostcodeField().clear();
        getPostcodeField().sendKeys(userRequest.getPostalCode());

        selectCountry(userRequest.getCountry().getTwoLetterCountry());

        getMobileField().click();
        getMobileField().clear();
        getMobileField().sendKeys(userRequest.getMobile());

        getPasswordButton().click();
        getPasswordButton().clear();
        getPasswordButton().sendKeys(userRequest.getPassword());

        getConfirmPasswordButton().click();
        getConfirmPasswordButton().clear();
        getConfirmPasswordButton().sendKeys(userRequest.getPassword());

        getMailingListSwitch().click();
        getRegisterButton().click();

        return new UserPage(driver, url, email, password);
    }
}
