package com.projectname.e2e.tests.suites;

import com.projectname.e2e.tests.pages.*;
import com.projectname.e2e.tests.pages.common.IntegrationDropdownPage;
import com.projectname.e2e.tests.pages.common.NavigationBarPage;
import com.projectname.e2e.tests.suites.common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBarTests extends TestBase {


    @Test()
    public void verifyDemoButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        DemoPage demoPage = navigationBarPage.openDemoPage();

        Assert.assertTrue(demoPage.isDisplayed());
    }

    @Test
    public void verifyFlightsButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        FlightsPage flightsPage = navigationBarPage.openFlightsPage();

        Assert.assertTrue(flightsPage.isDisplayed());
    }

    @Test
    public void verifyHotelsButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        HotelsPage hotelsPage = navigationBarPage.openHotelsPage();

        Assert.assertTrue(hotelsPage.isDisplayed());
    }

    @Test
    public void verifyCarsButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        CarsPage carsPage = navigationBarPage.openCarsPage();

        Assert.assertTrue(carsPage.isDisplayed());
    }

    @Test
    public void verifyIntegrationDropdownButtonIsWorking() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        IntegrationDropdownPage integrationDropdownPage = navigationBarPage.openIntegrationsDropdownPage();

        Assert.assertTrue(integrationDropdownPage.isDisplayed());
    }

    @Test
    public void verifyKiwiIsPresentOnFlights() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        IntegrationDropdownPage integrationDropdownPage = navigationBarPage.openIntegrationsDropdownPage();

        FlightsOnIntegrationPage flightsOnIntegrationPage = integrationDropdownPage.openFlightsOnIntegrationPage();

        Assert.assertTrue(flightsOnIntegrationPage.isDisplayed());
    }
}

