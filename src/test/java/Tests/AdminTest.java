package Tests;

import Base.Base;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends Base {

    @Test
    public void TC013_navegarAdmin() {
        System.out.println("Iniciando TC013");

        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        AdminPage admin = new AdminPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToAdmin();

        boolean result = admin.isUserTableVisible();

        if (result) {
            System.out.println("TC013 PASS");
        } else {
            System.out.println("TC013 FAIL");
        }

        Assert.assertTrue(result);
    }

    @Test
    public void TC014_dropdownUserRole() {
        System.out.println("Iniciando TC014");

        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        AdminPage admin = new AdminPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToAdmin();

        admin.selectUserRoleAdmin();

        boolean result = admin.isUserRoleSelected();

        if (result) {
            System.out.println("TC014 PASS");
        } else {
            System.out.println("TC014 FAIL");
        }

        Assert.assertTrue(result);
    }
}