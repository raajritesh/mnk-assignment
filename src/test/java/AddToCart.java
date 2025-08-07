import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Dashboard;
import pages.CartPage;

public class AddToCart extends BaseTest {

    @Test
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        Dashboard inventory = new Dashboard(driver);
        CartPage cart = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventory.isDashboardDisplayed(), "Inventory page failed.");
        
        String productName = inventory.getFirstItemName();
        Reporter.log("Selected product: " + productName, true);

        inventory.addFirstItemToCart();
        Reporter.log("Clicked Add to Cart for: " + productName, true);

        cart.openCart();
        String cartItem = cart.getCartItemName();
        Reporter.log("Item in cart: " + cartItem, true);

        Assert.assertEquals(cartItem, productName, "Cart product mismatch!");
    }
}
