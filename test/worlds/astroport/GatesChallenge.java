package worlds.astroport;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;
import support.LoadDocument;

import static org.junit.Assert.assertThat;
import static org.testinfected.hamcrest.dom.DomMatchers.hasUniqueSelector;

public class GatesChallenge {

    Element view;

    @Before
    public void thisPage() throws Exception {
        view = LoadDocument.from( "src/yose/worlds/astroport/astroport.html" );
    }

    @Test
    public void hasAGateForAFirstShip() {
        assertThat( view, hasUniqueSelector( "#gate-1 #ship-1" ) );
    }

    @Test
    public void hasAGateForASecondShip() {
        assertThat( view, hasUniqueSelector( "#gate-2 #ship-2" ) );
    }

    @Test
    public void hasAGateForAThirdShip() {
        assertThat( view, hasUniqueSelector( "#gate-3 #ship-3" ) );
    }

}
