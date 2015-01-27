import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TddReadyTest {

    @Test
    public void canAssert() {
        assertThat( 1 + 1, equalTo( 2 ) );
    }
}
