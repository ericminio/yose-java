package worlds.astroport;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;
import support.LoadDocument;

import static org.junit.Assert.assertThat;
import static org.testinfected.hamcrest.dom.DomMatchers.hasClassName;
import static org.testinfected.hamcrest.dom.DomMatchers.hasUniqueSelector;

public class FeedbackStartingPoint {

    Element view;

    @Before
    public void thisPage() throws Exception {
        view = LoadDocument.from( "src/yose/worlds/astroport/astroport.html" );
    }

    @Test
    public void hasTheExpectedInformationBox() {
        assertThat( view, hasUniqueSelector( "#info", hasClassName( "hidden" ) ) );
    }

    @Test
    public void displayTheGatesAsFree() {
        assertThat( view, hasUniqueSelector( "#gate-1", hasClassName( "free gate" ) ) );
        assertThat( view, hasUniqueSelector( "#gate-2", hasClassName( "free gate" ) ) );
        assertThat( view, hasUniqueSelector( "#gate-3", hasClassName( "free gate" ) ) );
    }
}
