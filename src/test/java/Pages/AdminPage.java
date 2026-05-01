package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends Base {

    By userTable = By.xpath("//div[@class='oxd-table-body']");
    By userRoleDropdown = By.xpath("//label[text()='User Role']/following::div[1]");
    By adminOption = By.xpath("//div[@role='option']//span[text()='Admin']");
    By selectedUserRole = By.xpath("//label[text()='User Role']/following::div[1]//div[contains(@class,'oxd-select-text')]");

    public AdminPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selectUserRoleAdmin() {
        click(userRoleDropdown);
        waitForElement(adminOption);
        click(adminOption);
    }

    public boolean isUserRoleSelected() {
        waitForElement(selectedUserRole);
        return getText(selectedUserRole).equalsIgnoreCase("Admin");
    }

    public boolean isUserTableVisible() {
        waitForElement(userTable);
        return isDisplayed(userTable);
    }
}