package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.pages.common.NavigationBarPage;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.By;

public class DemoPage extends PageBase {
    public DemoPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if(!isDisplayed()) {
            NavigationBarPage navigationBarPage = new NavigationBarPage(driver, url, email, password);
            if(navigationBarPage.isDisplayed()) {
                navigationBarPage.openDemoPage();
            }
        }
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isPresent(CustomBy.xpath("//section[1]/div/div/div[2]/div/div/div[1]"), driver);
    }


}
