import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.CartPage;
import page.DisplateMainPage;
import page.ItemPage;
import page.ProceedToCartPage;

import java.io.IOException;

public class TestClass extends BaseTest {

    DisplateMainPage homePage = new DisplateMainPage();
    ItemPage itemPage = new ItemPage();
    ProceedToCartPage proceedToCartPage = new ProceedToCartPage();
    CartPage cartPage = new CartPage();

    @Test
    public void verifyIfFirstItemFromBestsellingofferIsAddedToCart() throws IOException {
        homePage.openMainPage();
        String expectedItemId = homePage.storeItemCollectionId();
        homePage.clickFistBestsellingItem();
        itemPage.clickSelectSecondAvailableFrame();
        itemPage.clickAddToCardButton();
        proceedToCartPage.clickProceedToCart();

        String actualItemId = cartPage.getItemId();

        Assert.assertEquals(expectedItemId, actualItemId);
    }

    @Test
    public void verifyIfPriceOfAddedItemIsCorrect() throws IOException {
        homePage.openMainPage();
        homePage.clickFistBestsellingItem();
        itemPage.clickSelectSecondAvailableFrame();
        String expectedItemPrice = itemPage.getItemPrice();
        itemPage.clickAddToCardButton();
        proceedToCartPage.clickProceedToCart();

        String actualItemPrice = cartPage.getItemPrice();

        Assert.assertEquals(expectedItemPrice, actualItemPrice);
    }

    @Test
    public void verifyIfPriceAfterDiscountIsCorrect() throws IOException {
        homePage.openMainPage();
        homePage.clickFistBestsellingItem();
        itemPage.clickSelectSecondAvailableFrame();
        String expectedItemPrice = itemPage.getItemPrice();
        itemPage.clickAddToCardButton();
        proceedToCartPage.clickProceedToCart();
        cartPage.selectCountryForShipping();
        cartPage.clickOnDiscountButton();
        cartPage.enterDiscountCodeAndPressApply();

        String actualCartTotalPrice = cartPage.getCartTotalPrice();

        Assert.assertEquals(expectedItemPrice, actualCartTotalPrice);
    }
}
