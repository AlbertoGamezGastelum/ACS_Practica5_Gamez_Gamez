package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideMenuPage extends Base {

    By pimMenu = By.xpath("//span[text()='PIM']");
    By recruitmentMenu = By.xpath("//span[text()='Recruitment']");
    By adminMenu = By.xpath("//span[text()='Admin']");

    public SideMenuPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToPIM() {
        click(pimMenu);
    }

    public void goToRecruitment() {
        click(recruitmentMenu);
    }

    public void goToAdmin() {
        click(adminMenu);
    }
}