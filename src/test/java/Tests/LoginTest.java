package Tests;

import Base.Base;
import Pages.LoginPage;
import Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    @Test
    public void TC001_loginExitoso() {
        System.out.println("Iniciando TC001");
        LoginPage login = new LoginPage(driver, wait);
        DashboardPage dashboard = new DashboardPage(driver, wait);
        login.login("Admin", "admin123");
        waitForUrlContains("dashboard");
        boolean result = dashboard.isDashboardVisible();
        if (result) {
            System.out.println("TC001 PASS");
        } else {
            System.out.println("TC001 FAIL");
        }
        Assert.assertTrue(result);
    }

    @Test
    public void TC002_passwordIncorrecto() {
        System.out.println("Iniciando TC002");
        LoginPage login = new LoginPage(driver, wait);
        login.login("Admin", "1234567");
        boolean result = login.getErrorMessage().contains("Invalid credentials");
        if (result) {
            System.out.println("TC002 PASS");
        } else {
            System.out.println("TC002 FAIL");
        }
        Assert.assertTrue(result);
    }

    @Test
    public void TC003_camposVacios() {
        System.out.println("Iniciando TC003");
        LoginPage login = new LoginPage(driver, wait);
        login.clickLogin();
        boolean result = login.isRequiredDisplayed();
        if (result) {
            System.out.println("TC003 PASS");
        } else {
            System.out.println("TC003 FAIL");
        }
        Assert.assertTrue(result);
    }

    @Test
    public void TC004_usuarioInexistente() {
        System.out.println("Iniciando TC004");
        LoginPage login = new LoginPage(driver, wait);
        login.login("carlosgamez", "admin123");
        boolean result = login.getErrorMessage().contains("Invalid credentials");
        if (result) {
            System.out.println("TC004 PASS");
        } else {
            System.out.println("TC004 FAIL");
        }
        Assert.assertTrue(result);
    }
}