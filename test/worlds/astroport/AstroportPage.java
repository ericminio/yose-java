package worlds.astroport;

import com.objogate.wl.UnsynchronizedProber;
import com.objogate.wl.web.AsyncWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import support.YoseChallenge;

import static org.hamcrest.CoreMatchers.not;

public class AstroportPage extends YoseChallenge {

    private AsyncWebDriver browser;

    @Before
    public void visitAstroport() throws Exception {
        browser = new AsyncWebDriver( new UnsynchronizedProber(), new FirefoxDriver() );
        browser.navigate().to( "http://localhost:8000/astroport" );
    }

    @After
    public void closeBrowser() {
        browser.quit();
    }

    @Test
    public void displaysAstroportName() {
        browser.element( By.id( "astroport-name" ) ).assertExists();
        browser.element( By.id( "astroport-name" ) ).assertText( not( "" ) );
    }

    @Test
    public void displayTheGates() {
        browser.element( By.cssSelector( "#gate-1 #ship-1" ) ).assertExists();
        browser.element( By.cssSelector( "#gate-2 #ship-2" ) ).assertExists();
        browser.element( By.cssSelector( "#gate-3 #ship-3" ) ).assertExists();
    }
}
