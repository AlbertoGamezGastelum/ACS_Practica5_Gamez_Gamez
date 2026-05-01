package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends Base {

    By dashboardTitle = By.xpath("//h6[text()='Dashboard']");
    By timeAtWork = By.xpath("//p[text()='Time at Work']");
    By quickLaunch = By.xpath("//p[text()='Quick Launch']");

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isDashboardVisible() {
        waitForElement(dashboardTitle);
        return isDisplayed(dashboardTitle);
    }

    public boolean isWidgetsVisible() {
        waitForElement(timeAtWork);
        waitForElement(quickLaunch);
        return isDisplayed(timeAtWork) && isDisplayed(quickLaunch);
    }

    public boolean isDashboardUrlCorrect() {
        waitForUrlContains("dashboard");
        return getCurrentUrl().contains("dashboard");
    }
}