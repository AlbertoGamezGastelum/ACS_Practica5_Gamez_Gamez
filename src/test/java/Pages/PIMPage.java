package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage extends Base {

    By employeeTable = By.xpath("//div[@class='oxd-table-body']");
    By selectedEmploymentStatus = By.xpath("//label[contains(text(),'Employment Status')]/following::div[1]//div[contains(@class,'oxd-select-text')]");
    By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    By searchButton = By.xpath("//button[@type='submit']");
    By resultTable = By.xpath("//div[contains(text(),'')]");
    By employmentStatusDropdown = By.xpath("//label[text()='Employment Status']/following::div[1]");
    By fullTimeOption = By.xpath("//div[@role='option']//span[text()='Full-Time Permanent']");

    public PIMPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isEmployeeTableVisible() {
        waitForElement(employeeTable);
        return isDisplayed(employeeTable);
    }

    public void searchEmployee(String name) {
        type(employeeNameInput, name);
        click(searchButton);
    }

    public boolean areSearchResultsVisible() {
        waitForElement(resultTable);
        return isDisplayed(resultTable);
    }

    public void selectEmploymentStatus() {
        click(employmentStatusDropdown);
        waitForElement(fullTimeOption);
        click(fullTimeOption);
    }

    public boolean isEmploymentStatusSelected() {
        waitForElement(selectedEmploymentStatus);
        return getText(selectedEmploymentStatus).contains("Full-Time Permanent");
    }
}