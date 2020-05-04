package page;

import common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static webdriverprovider.WebDriverProvider.getDriver;

public class CartPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(getDriver(), 5);
    Actions action = new Actions(getDriver());

    @FindBy(how = How.CSS, using = ".cart-remove.loading")
    private WebElement itemInCart;
    @FindBy(how = How.XPATH, using = "//span[@class='text text--bold text--extra-big']")
    private WebElement itemCurrentPrice;
    @FindBy(how = How.XPATH, using = "//div[@class='input-select__dropdown']//div[@class='simplebar-content']/div[@value='US']")
    private WebElement selectCountryForShipping;
    @FindBy(how = How.ID, using = "select-country")
    private WebElement chooseCountryForShippingDropdown;
    @FindBy(how = How.CSS, using = ".text.text--center.text--bold.discount__toggle")
    private WebElement discountButton;
    @FindBy(how = How.ID, using = "discount-code")
    private WebElement discountField;
    @FindBy(how = How.ID, using = "discount-apply")
    private WebElement discountApplyButton;
    @FindBy(how = How.ID, using = "cart-total")
    private WebElement cartTotalPrice;
    @FindBy(how = How.XPATH, using = "//span[@class='black-friday-text-regular']/strong[3]")
    private WebElement discountCode;

    public CartPage() {
        super();
    }

    public String getItemId() {
        return itemInCart.getAttribute("data-item-collection_id");
    }

    public String getItemPrice() {
        return itemCurrentPrice.getText();
    }


    public void selectCountryForShipping() {
        chooseCountryForShippingDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectCountryForShipping));
        action.moveToElement(selectCountryForShipping).click().build().perform();
        action.moveToElement(chooseCountryForShippingDropdown).perform();
        getDriver().navigate().refresh();
    }

    public void clickOnDiscountButton() {
        discountButton.click();
    }

    public void enterDiscountCodeAndPressApply() {
        discountField.sendKeys(discountCode.getText());
        discountApplyButton.click();
    }

    public String getCartTotalPrice() {
        return cartTotalPrice.getText();
    }
}
