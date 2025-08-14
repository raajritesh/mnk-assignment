package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard extends BasePage {

    private By title = By.className("app_logo");
    private By firstAddToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By firstItemName = By.id("shopping_cart_container");
   // private By firstItemName = By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]");
    private By secondAddToCartBtn = By.name("add-to-cart-sauce-labs-bike-light");
    private By secondItemName = By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]");		
    		
    public Dashboard(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).isDisplayed();
    }
    
    public String getFirstItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemName)).getText();
    }

    public void addFirstItemToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartBtn)).click();
    }  
    
    public String getSecondItemName() {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(secondItemName)).getText();
    }
    public void addSecondItemToCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(secondAddToCartBtn)).click();
    }
        
}
