package common;

import org.junit.After;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

import static webdriverprovider.WebDriverProvider.closeDriver;
import static webdriverprovider.WebDriverProvider.getDriver;

public class BaseTest extends BasePage {

    @Before
    public void setUp() {
        getDriver().manage()
                .window()
                .maximize();
        getDriver().manage()
                .timeouts()
                .implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS)
                .pageLoadTimeout(PAGE_LOAD_TIME, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        closeDriver();
    }
}
