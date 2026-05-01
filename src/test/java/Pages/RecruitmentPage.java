package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage extends Base {

    By vacanciesTab = By.xpath("//a[contains(text(),'Vacancies')]");
    By selectedJobTitle = By.xpath("//label[text()='Job Title']/following::div[1]//div[contains(@class,'oxd-select-text')]");
    By jobTitleDropdown = By.xpath("//label[text()='Job Title']/following::div[1]");
    By firstOption = By.xpath("(//div[@role='option'])[1]");
    By addButton = By.xpath("//button[contains(.,'Add')]");

    public RecruitmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isRecruitmentLoaded() {
        waitForUrlContains("recruitment");
        return getCurrentUrl().contains("recruitment");
    }

    public void goToVacancies() {
        click(vacanciesTab);
    }

    public void selectJobTitle() {
        click(jobTitleDropdown);
        click(firstOption);
    }

    public boolean isJobTitleSelected() {
        waitForElement(selectedJobTitle);
        return !getText(selectedJobTitle).isEmpty();
    }

    public boolean isAddButtonVisible() {
        waitForElement(addButton);
        return isDisplayed(addButton);
    }
}