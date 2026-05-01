package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    // Click con espera
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    // Escribir con espera
    public void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    // Obtener texto con espera
    public String getText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    // Validar visibilidad
    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Obtener URL actual
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Espera
    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Espera para URL
    public void waitForUrlContains(String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }

    // Seleccionar opcion de dropdown
    public void selectOption(By option) {
        wait.until(ExpectedConditions.elementToBeClickable(option));
        driver.findElement(option).click();
    }

    // Buscar
    public void search(By input, String text, By button) {
        type(input, text);
        click(button);
    }
}