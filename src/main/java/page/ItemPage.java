package page;


import common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ItemPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@class='link link--blue js-show-frames']")
    private WebElement finishAndAddFrame;
    @FindBy(how = How.XPATH, using = "//div[@class='customize-displate__row'][2]/label[2]")
    private WebElement selectSecondAvailableFrame;
    @FindBy(how = How.XPATH, using = "//button[@class='button button--primary button--full-width button--big']")
    private WebElement addToCart;

    public ItemPage() {
        super();
    }

    public void clickSelectSecondAvailableFrame() {
        selectSecondAvailableFrame.click();
    }

    public void clickAddToCardButton() {
        addToCart.click();
        new CartPage();
    }

    public String getItemPrice() {
        return addToCart.getText().substring(0, 3);
    }
}
