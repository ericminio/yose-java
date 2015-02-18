package worlds.astroport;

import com.objogate.wl.UnsynchronizedProber;
import com.objogate.wl.web.AsyncWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import support.SunHttpServer;
import yose.Routes;

public class FeedbackChallenge {

    private SunHttpServer server;
    private AsyncWebDriver browser;

    @Before
    public void startServer() throws Exception {
        server = new SunHttpServer( 8000 );
        server.serving( new Routes() );
        server.start();
        browser = new AsyncWebDriver( new UnsynchronizedProber(), new FirefoxDriver() );
        browser.navigate().to( "http://localhost:8000/astroport" );
    }

    @After
    public void stopServer() {
        server.stop();
        browser.quit();
    }

    @Test
    public void displaysInfoBoxWhenAppropriate() {
        browser.element( By.cssSelector( "#info.hidden" ) ).assertExists();

        browser.element( By.cssSelector( "input#ship" ) ).type( "Faucon" );
        browser.element( By.cssSelector( "button#dock" ) ).click();
        browser.element( By.cssSelector( "#info.hidden" ) ).assertDoesNotExist();

        browser.element( By.cssSelector( "input#ship" ) ).clear();
        browser.element( By.cssSelector( "input#ship" ) ).type( "Goldorak" );
        browser.element( By.cssSelector( "#info.hidden" ) ).assertExists();
    }
}
