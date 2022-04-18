package eu.qwan.vendingmachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class VendingMachineTest {
    @Test
    public void trueIsNotFalse() {
        assertThat(true, is(equalTo(false)));
    }
}
