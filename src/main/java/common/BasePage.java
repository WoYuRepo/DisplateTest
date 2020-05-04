package common;

import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static webdriverprovider.WebDriverProvider.getDriver;

public class BasePage {

    static final long IMPLICIT_WAIT_TIME = 10;
    static final long PAGE_LOAD_TIME = 30;

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        String loc = "src\\main\\resources\\properties.properties";
        FileInputStream fis = new FileInputStream(loc);
        properties.load(fis);
        return properties;
    }
}
