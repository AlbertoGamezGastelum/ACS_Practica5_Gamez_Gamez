package Tests;

import Base.Base;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PIMTest extends Base {

    @Test
    public void TC007_navegarPIM() {
        System.out.println("Iniciando TC007");

        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        PIMPage pim = new PIMPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToPIM();

        boolean result = pim.isEmployeeTableVisible();

        if (result) {
            System.out.println("TC007 PASS");
        } else {
            System.out.println("TC007 FAIL");
        }

        Assert.assertTrue(result);
    }

    @Test
    public void TC008_busquedaEmpleado() {
        System.out.println("Iniciando TC008");

        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        PIMPage pim = new PIMPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToPIM();

        pim.searchEmployee("John");

        boolean result = pim.areSearchResultsVisible();

        if (result) {
            System.out.println("TC008 PASS");
        } else {
            System.out.println("TC008 FAIL");
        }

        Assert.assertTrue(result);
    }

    @Test
    public void TC009_dropdownEmploymentStatus() {
        System.out.println("Iniciando TC009");

        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        PIMPage pim = new PIMPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToPIM();

        pim.selectEmploymentStatus();

        boolean result = pim.isEmploymentStatusSelected();

        if (result) {
            System.out.println("TC009 PASS");
        } else {
            System.out.println("TC009 FAIL");
        }

        Assert.assertTrue(result);
    }
}