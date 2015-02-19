package worlds.astroport;

import com.objogate.wl.UnsynchronizedProber;
import com.objogate.wl.web.AsyncWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import support.YoseChallenge;

import static org.hamcrest.CoreMatchers.containsString;

public class PortfolioChallenge extends YoseChallenge {

    private AsyncWebDriver browser;

    @Before
    public void homePage() throws Exception {
        browser = new AsyncWebDriver( new UnsynchronizedProber(), new FirefoxDriver() );
        browser.navigate().to( "http://localhost:8000/" );
    }

    @After
    public void closeBrowser() {
        browser.quit();
    }

    @Test
    public void displaysLinkToAstroport() {
        browser.element( By.cssSelector( "a#astroport-link" ) ).assertExists();
        browser.element( By.cssSelector( "a#astroport-link" ) ).assertText( containsString( "Astroport" ) );
        browser.element( By.cssSelector( "a[href='/astroport']#astroport-link" ) ).assertExists();
    }
}
