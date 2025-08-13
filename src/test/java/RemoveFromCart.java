import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Dashboard;
import pages.CartPage;


public class RemoveFromCart extends BaseTest{
	
	@Test
	public void removeProductFromCart() {
	LoginPage loginPage = new LoginPage(driver);
    Dashboard dashboard = new Dashboard(driver);
    CartPage cart = new CartPage(driver);
    
    
    loginPage.login("standard_user", "secret_sauce");
    Assert.assertTrue(dashboard.isDashboardDisplayed(), "Inventory page failed.");
    
    String product1Name = dashboard.getFirstItemName();
    Reporter.log("Selected product: " + product1Name, true);
    
    String product2Name = dashboard.getSecondItemName();
    Reporter.log("Selected product2: " + product2Name, true);
   
    dashboard.addFirstItemToCart();
    Reporter.log("Clicked Add to Cart for: " + product1Name, true);
    
    dashboard.addSecondItemToCart();
    Reporter.log("Clicked Add to Cart for: " + product2Name, true);
    
    cart.openCart();
    
    cart.removeItemFromCart();
    Reporter.log("Clicked Remove: " + product1Name, true);
    

}
}