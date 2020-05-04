package page;

import common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

import static webdriverprovider.WebDriverProvider.getDriver;

public class DisplateMainPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//h3[contains(text(),'bestselling')]/.. //div[@class='slick-slide slick-active slick-current']/div/div")
    private WebElement firstBestsellingItem;

    public DisplateMainPage() {
        super();
    }

    public void openMainPage() throws IOException {
        getDriver().get(loadProperties().getProperty("Main_URL"));
    }

    public String storeItemCollectionId() {
        return firstBestsellingItem.getAttribute("data-item-collection-id");
    }

    public void clickFistBestsellingItem() {
        firstBestsellingItem.click();
        new ItemPage();
    }
}
