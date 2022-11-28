package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.environment.ConfigReader;
import com.projectname.e2e.tests.pages.common.NavigationBarPage;
import com.projectname.e2e.tests.pages.common.NavigationBarSubPage;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static com.projectname.api.client.utils.Allure.logStep;

public class LoginPage extends PageBase {

    public LoginPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if (!isDisplayed()) {
            NavigationBarPage navigationBarPage = new NavigationBarPage(driver, url, email, password);
            navigationBarPage.openLoginPage();
        }
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }


    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.testAutomationId("emailInput"), driver);
    }

    public DashboardPage login(String email, String password) {
        WebElement weGetEmailInput = getEmailInput();
        //you can directly send characters, but idea with click is to see mouse follow from one element to another, since that action is triggered on click
        weGetEmailInput.click();
        weGetEmailInput.sendKeys(email);
        WebElement weGetPasswordInput = getPasswordInput();
        weGetPasswordInput.click();
        weGetPasswordInput.sendKeys(password);
        getLoginButton().click();
        driver.waitForElementToBePresent(CustomBy.testAutomationId("dashboardButton"));
        return new DashboardPage(driver, "", email, password);
    }

    private WebElement getEmailInput() {
        try {
            return driver.findElement(CustomBy.id("inputEmail"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find email input field on Login Page", e);
        }
    }

    private WebElement getPasswordInput() {
        try {

            return driver.findElement(CustomBy.id("inputPassword"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find password input field on Login page", e);
        }
    }

    private WebElement getLoginButton() {
        try {
            return driver.findElement(CustomBy.id("login"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Log in button on Login page", e);
        }
    }


    public UserPage loginUser() {
        getEmailInput().click();
        getEmailInput().clear();
        getEmailInput().sendKeys(ConfigReader.getValue("USER"));

        getPasswordInput().click();
        getPasswordInput().clear();
        getPasswordInput().sendKeys(ConfigReader.getValue("USER_PSW"));

        getLoginButton().click();

        return new UserPage(driver, url, email, password);
    }
}
