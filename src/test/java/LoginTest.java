import org.testng.Assert;
//import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Dashboard;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        Dashboard dashboard = new Dashboard(driver);

        loginPage.login("standard_user", "secret_sauce");
        
      /*  boolean isDisplayed = inventoryPage.isInventoryDisplayed();

        Reporter.log(isDisplayed
            ? "Inventory page displayed after login"
            : "Inventory page NOT displayed after login", true);

        Assert.assertTrue(isDisplayed, "Inventory page should be displayed after login");
	*/
        Assert.assertTrue(dashboard.isDashboardDisplayed(), "Login failed!");
    }
}
