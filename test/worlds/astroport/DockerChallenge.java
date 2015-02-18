package worlds.astroport;

import com.objogate.wl.UnsynchronizedProber;
import com.objogate.wl.web.AsyncWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import support.YoseChallenge;

import static org.hamcrest.CoreMatchers.equalTo;

public class DockerChallenge extends YoseChallenge {

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
    public void canDockAShipInFirstGate() {
        browser.element( By.cssSelector( "input#ship" ) ).type( "Faucon" );
        browser.element( By.cssSelector( "button#dock" ) ).click();

        browser.element( By.cssSelector( "#ship-1" ) ).assertText( equalTo( "Faucon" ) );
    }
}
