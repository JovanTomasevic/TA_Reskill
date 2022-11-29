package com.projectname.e2e.tests.pages.common;

import com.projectname.e2e.tests.pages.FlightsOnIntegrationPage;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class IntegrationDropdownPage extends PageBase {
    public IntegrationDropdownPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isPresent(CustomBy.xpath("//*[@class='jfHeader-subMenu integrations']"), driver);
    }

    private WebElement getFlightsOnIntegrationDropdown() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"menuToggle-3\"]/button"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find flights button on Integration dropdown page", e);
        }
    }

    private WebElement getKiwiOnFlights() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"menuContent-3\"]/ul/li[2]/a"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Kiwi on flights on Integration Dropdown", e);
        }
    }

    public FlightsOnIntegrationPage openFlightsOnIntegrationPage() {
        getFlightsOnIntegrationDropdown().click();
        return new FlightsOnIntegrationPage(driver, url, email, password);
    }

}
