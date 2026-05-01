package Tests;

import Base.Base;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitmentTest extends Base {

    @Test
    public void TC010_navegarRecruitment() {
        System.out.println("Iniciando TC010");

        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        RecruitmentPage rec = new RecruitmentPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToRecruitment();

        boolean result = rec.isRecruitmentLoaded();

        if (result) {
            System.out.println("TC010 PASS");
        } else {
            System.out.println("TC010 FAIL");
        }

        Assert.assertTrue(result);
    }

    @Test
    public void TC011_dropdownJobTitle() {
        System.out.println("Iniciando TC011");

        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        RecruitmentPage rec = new RecruitmentPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToRecruitment();
        rec.goToVacancies();

        rec.selectJobTitle();

        boolean result = rec.isJobTitleSelected();

        if (result) {
            System.out.println("TC011 PASS");
        } else {
            System.out.println("TC011 FAIL");
        }

        Assert.assertTrue(result);
    }

    @Test
    public void TC012_validarBotonAdd() {
        System.out.println("Iniciando TC012");

        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        RecruitmentPage rec = new RecruitmentPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToRecruitment();
        rec.goToVacancies();

        boolean result = rec.isAddButtonVisible();

        if (result) {
            System.out.println("TC012 PASS");
        } else {
            System.out.println("TC012 FAIL");
        }

        Assert.assertTrue(result);
    }
}