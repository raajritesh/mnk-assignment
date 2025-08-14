package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private By cartIcon = By.className("shopping_cart_link");
    private By cartItemName = By.className("inventory_item_name");
    private By removeFromCart = By.id("remove-sauce-labs-backpack");
    
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public String getCartItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemName)).getText();
    }
    
    public void removeItemFromCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(removeFromCart)).click();
    }
}
