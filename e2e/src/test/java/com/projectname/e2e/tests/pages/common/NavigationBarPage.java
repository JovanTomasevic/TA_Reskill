package com.projectname.e2e.tests.pages.common;

import com.projectname.e2e.tests.pages.CarsPage;
import com.projectname.e2e.tests.pages.DemoPage;
import com.projectname.e2e.tests.pages.FlightsPage;
import com.projectname.e2e.tests.pages.HotelsPage;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBarPage extends PageBase {
    public NavigationBarPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.id("PHPTRAVELS"), driver);
    }

    private WebElement getDemoBtn() {
        try {
            return driver.findElement(CustomBy.xpath("//section/div/div[1]/div/div/a[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find demo button on Navigation bar page", e);
        }
    }

    public DemoPage openDemoPage() {
        getDemoBtn().click();
        return new DemoPage(driver, url, email, password);
    }

    private WebElement getFeaturesBtn() {
        try {
            return driver.findElement(CustomBy.xpath("//ul/li[3]/div/ul/li[2]/a/span"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find features button on Navigation bar page", e);
        }
    }

    private WebElement getIntegrationsDropdownBtn() {
        try {
            return driver.findElement(CustomBy.xpath("//div/div[3]/ul/li[4]/a"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find integrations button on Navigation bar page", e);
        }
    }

    private WebElement getFlightsBtn() {
        getFeaturesBtn().click();
        try {
            return driver.findElement(CustomBy.xpath("//ul/li[3]/div/ul/li[4]/a/span"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find flights button on Navigation bar page", e);
        }
    }

    private WebElement getHotelsBtn() {
        getFeaturesBtn().click();
        try {
            return driver.findElement(CustomBy.xpath("//ul/li[3]/div/ul/li[3]/a/span"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find hotels button on Navigation bar page", e);
        }
    }

    private WebElement getCarsBtn() {
        getFeaturesBtn().click();
        try {
            return driver.findElement(CustomBy.xpath("//ul/li[3]/div/ul/li[6]/a/span"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find cars button on Navigation bar page", e);
        }
    }

    public FlightsPage openFlightsPage() {
        getFlightsBtn().click();
        return new FlightsPage(driver, url, email, password);
    }

    public HotelsPage openHotelsPage() {
        getHotelsBtn().click();
        return new HotelsPage(driver, url, email, password);
    }

    public CarsPage openCarsPage() {
        getCarsBtn().click();
        return new CarsPage(driver, url, email, password);
    }

    public IntegrationDropdownPage openIntegrationsDropdownPage() {
        getIntegrationsDropdownBtn().click();
        return new IntegrationDropdownPage(driver, url, email, password);
    }
}
