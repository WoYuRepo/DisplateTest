package page;

import common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProceedToCartPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//a[@class='button button--primary']")
    private WebElement proceedToCart;

    public ProceedToCartPage() {
        super();
    }

    public void clickProceedToCart() {
        proceedToCart.click();
        new CartPage();
    }
}
