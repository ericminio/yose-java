package worlds.start;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;
import support.LoadDocument;

import static org.junit.Assert.assertThat;
import static org.testinfected.hamcrest.dom.DomMatchers.hasUniqueSelector;

public class ShareChallenge {

    Element view;

    @Before
    public void thisPage() throws Exception {
        view = LoadDocument.from( "src/yose/worlds/start/home.html" );
    }

    @Test
    public void hasTheExpectedLinkToRepository() {
        assertThat( view, hasUniqueSelector( "a#repository-link" ) );
    }
}
