package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.data.model.UserPageDetails;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class UserPage extends PageBase {
    public UserPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if (!isDisplayed()) {
            AccountUpdatePage accountUpdatePage = new AccountUpdatePage(driver, url, email, password);
            accountUpdatePage.openUserPage();
        }
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[3]/a"), driver);
    }

    private WebElement getFirstAndLastName() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/em"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find employee first and last on User page", e);
        }
    }

    private WebElement getCompanyName() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/strong"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find company name on User page", e);
        }
    }

    private WebElement getAddress1() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/br[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find employee address 1 on User page", e);
        }
    }

    private WebElement getAddress2() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/br[3]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find employee address 2 on User page", e);
        }
    }

    private WebElement getCityStateAndPostcode() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/br[4]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find employee city, state and postal code on User page", e);
        }
    }

    private WebElement getCountry() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/br[5]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find employee country on User page", e);
        }
    }

    private WebElement getEmployeeCard() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find employee card on User page", e);
        }
    }

    private WebElement getUpdateBtn() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[3]/a"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find update button on User page", e);
        }
    }

    public AccountUpdatePage openAccountUpdatePage() {
        getUpdateBtn().click();
        return new AccountUpdatePage(driver, url, email, password);
    }

    public UserPageDetails getActualUserDetails() {
        UserPageDetails userPageDetails = new UserPageDetails();

        userPageDetails.setFirstAndLastName(getFirstAndLastName().getText());
        userPageDetails.setAddress1(getEmployeeCard().getText());
        userPageDetails.setAddress2(getAddress2().getText());
        userPageDetails.setCityStatePostalCode(getCityStateAndPostcode().getText());
        userPageDetails.setCountry(getCountry().getText());

        return userPageDetails;
    }
}
