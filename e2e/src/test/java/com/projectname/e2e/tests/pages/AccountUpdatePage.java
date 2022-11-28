package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.data.model.RegisterUserRequest;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class AccountUpdatePage extends PageBase {
    public AccountUpdatePage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        //  if (!isDisplayed()) {
        UserPage userPage = new UserPage(driver, url, email, password);
        userPage.openAccountUpdatePage();
        //  }
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[3]/a"), driver);
    }

    private WebElement getInputFirstNameField() {
        try {
            return driver.findElement(CustomBy.id("inputFirstName"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find input first name field on Account Update Page", e);
        }
    }

    private WebElement getLastNameField() {
        try {
            return driver.findElement(CustomBy.id("inputLastName"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find last name field on Account Update Page", e);
        }
    }

    private WebElement getStreetAddressField() {
        try {
            return driver.findElement(CustomBy.id("inputAddress1"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address field on Account Update Page", e);
        }
    }

    private WebElement getStreetAddress2Field() {
        try {
            return driver.findElement(CustomBy.id("inputAddress2"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Account Update Page", e);
        }
    }

    private WebElement getEmailField() {
        try {
            return driver.findElement(CustomBy.id("inputEmail"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find email field on Account Update Page", e);
        }
    }

    private WebElement getCityField() {
        try {
            return driver.findElement(CustomBy.id("inputCity"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Account Update Page", e);
        }
    }

    private WebElement getStateField() {
        try {
            return driver.findElement(CustomBy.id("stateinput"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Account Update Page", e);
        }
    }

    private WebElement getPostcodeField() {
        try {
            return driver.findElement(CustomBy.id("inputPostcode"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Account Update Page", e);
        }
    }

    private WebElement getCompanyField() {
        try {
            return driver.findElement(CustomBy.id("inputCompanyName"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 field on Account Update Page", e);
        }
    }

    private WebElement getPaymentMethodDropdown() {
        try {
            return driver.findElement(CustomBy.id("inputPaymentMethod"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find payment method dropdown on Account Update Page", e);
        }
    }

    private WebElement getMobileField() {
        try {
            return driver.findElement(CustomBy.id("customfield2"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find not a robot checkbox on Account Update Page", e);
        }
    }

    private WebElement getInputPhoneField() {
        try {
            return driver.findElement(CustomBy.id("inputPhone"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find street address field on Account Update Page", e);
        }
    }

    private WebElement getGeneralEmailsCheckbox() {
        try {
            return driver.findElement(CustomBy.id("generalEmails"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find general email checkbox on Account Update Page", e);
        }
    }

    private WebElement getInvoiceEmailsCheckbox() {
        try {
            return driver.findElement(CustomBy.id("invoiceEmails"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find invoice email checkbox on Account Update Page", e);
        }
    }

    private WebElement getSupportEmailsCheckbox() {
        try {
            return driver.findElement(CustomBy.id("supportEmails"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find support email checkbox on Account Update Page", e);
        }
    }

    private WebElement getProductEmailsCheckbox() {
        try {
            return driver.findElement(CustomBy.id("productEmails"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find product email checkbox on Account Update Page", e);
        }
    }

    private WebElement getDomainEmailsCheckbox() {
        try {
            return driver.findElement(CustomBy.id("domainEmails"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find domain email checkbox on Account Update Page", e);
        }
    }

    private WebElement getAffiliateEmailsCheckbox() {
        try {
            return driver.findElement(CustomBy.id("affiliateEmails"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find affiliate email checkbox on Account Update Page", e);
        }
    }

    private WebElement getSaveChangesBtn() {
        try {
            return driver.findElement(CustomBy.xpath("//div/div[1]/div[2]/form/div[4]/input[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Save Changes button on Account Update Page", e);
        }
    }

    private WebElement getClientAreaBtn() {
        try {
            return driver.findElement(CustomBy.xpath("//nav/div/ol/li[2]/a"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find client area button on Account Update Page");
        }
    }

    public UserPage openUserPage() {
        getClientAreaBtn().click();
        return new UserPage(driver, url, email, password);
    }

    public AccountUpdatePage updateUser(RegisterUserRequest userRequest) {
        getInputFirstNameField().click();
        getInputFirstNameField().clear();
        getInputFirstNameField().sendKeys(userRequest.getFirstName());

        getLastNameField().click();
        getLastNameField().clear();
        getLastNameField().sendKeys(userRequest.getLastName());

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

        getSaveChangesBtn().click();

        return new AccountUpdatePage(driver, url, email, password);
    }
}


