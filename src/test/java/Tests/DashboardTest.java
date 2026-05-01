package Tests;

import Base.Base;
import Pages.LoginPage;
import Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends Base {

    @Test
    public void TC005_dashboardCarga() {
        System.out.println("Iniciando TC005");

        LoginPage login = new LoginPage(driver, wait);
        DashboardPage dashboard = new DashboardPage(driver, wait);

        login.login("Admin", "admin123");

        boolean result = dashboard.isWidgetsVisible();

        if (result) {
            System.out.println("TC005 PASS");
        } else {
            System.out.println("TC005 FAIL");
        }

        Assert.assertTrue(result);
    }

    @Test
    public void TC006_validarURL() {
        System.out.println("Iniciando TC006");

        LoginPage login = new LoginPage(driver, wait);
        DashboardPage dashboard = new DashboardPage(driver, wait);

        login.login("Admin", "admin123");

        boolean result = dashboard.isDashboardUrlCorrect();

        if (result) {
            System.out.println("TC006 PASS");
        } else {
            System.out.println("TC006 FAIL");
        }

        Assert.assertTrue(result);
    }
}