package eu.qwan.vendingmachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class VendingMachineTest {
    private VendingMachine machine = new VendingMachine();

    @Test
    public void choicelessMachineDeliversNothing() {
        assertThat(machine.deliver(Choice.COLA), is(equalTo(Optional.empty())));
    }

    @Test
    public void choosingColaDeliversCoke() {
        machine.configureChoice(Choice.COLA, Can.COKE);
        assertThat(machine.deliver(Choice.COLA), is(equalTo(Optional.of(Can.COKE))));
    }

}
