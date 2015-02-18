package worlds.astroport;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;
import support.LoadDocument;

import static org.junit.Assert.assertThat;
import static org.testinfected.hamcrest.dom.DomMatchers.hasUniqueSelector;

public class DockerForm {

    Element view;

    @Before
    public void thisPage() throws Exception {
        view = LoadDocument.from( "src/yose/worlds/astroport/astroport.html" );
    }

    @Test
    public void hasTheExpectedInputField() {
        assertThat( view, hasUniqueSelector( "input#ship" ) );
    }

    @Test
    public void hasTheExpectedDockingTrigger() {
        assertThat( view, hasUniqueSelector( "button#dock" ) );
    }
}
