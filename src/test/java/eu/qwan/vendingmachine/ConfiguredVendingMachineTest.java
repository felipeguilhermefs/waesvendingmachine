package eu.qwan.vendingmachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ConfiguredVendingMachineTest {
    private VendingMachine machine = new VendingMachine();

    @BeforeEach
    public void setup() {
        machine.configureChoice(Choice.FIZZY_ORANGE, Can.FANTA);
        machine.configureChoice(Choice.COLA, Can.COKE);
    }

    @Test
    public void deliversNothingOnUnconfiguredChoice() {
        assertThat(machine.deliver(Choice.BEER), is(equalTo(Optional.empty())));
    }

    @Test
    public void deliversCokeWhenChoosingCola() {
        assertThat(machine.deliver(Choice.COLA), is(equalTo(Optional.of(Can.COKE))));
    }

    @Test
    public void deliversFantaWhenChoosingFizzyOrange() {
        assertThat(machine.deliver(Choice.FIZZY_ORANGE), is(equalTo(Optional.of(Can.FANTA))));
    }
}
