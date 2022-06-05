package eu.qwan.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PricedVendingMachineTest {
    CashRegister cashRegister = new CashRegister();
    private VendingMachine machine = new VendingMachine(cashRegister);

    @BeforeEach
    public void setup() {
        machine.configureChoice(Choice.FIZZY_ORANGE, Can.FANTA, 1.0f);
    }

    @Test
    public void deliversNothingWhenNotPaid() {
        assertThat(machine.deliver(Choice.FIZZY_ORANGE), is(equalTo(Optional.empty())));
    }

    @Test
    public void deliversWhenPaidThePriceExactly() {
        machine.insert(100);
        assertThat(machine.deliver(Choice.FIZZY_ORANGE), is(equalTo(Optional.of(Can.FANTA))));
    }

    @Test
    public void deliversWhenPaidMoreThanTheExactPrice() {
        machine.insert(200);
        assertThat(machine.deliver(Choice.FIZZY_ORANGE), is(equalTo(Optional.of(Can.FANTA))));
    }

    @Test
    public void deliversOnceForCredits() {
        machine.insert(100);
        machine.deliver(Choice.FIZZY_ORANGE);
        assertThat(machine.deliver(Choice.FIZZY_ORANGE), is(equalTo(Optional.empty())));
    }

    @Test
    public void deliversMoreThanOnceWhenCreditsAllow() {
        machine.insert(200);
        machine.deliver(Choice.FIZZY_ORANGE);
        assertThat(machine.deliver(Choice.FIZZY_ORANGE), is(equalTo(Optional.of(Can.FANTA))));
    }

    @Test
    public void deliversACanWhenPaidThatSpecificCan() {
        machine.configureChoice(Choice.COLA, Can.COKE, 2.0f);
        machine.insert(100);
        assertThat(machine.deliver(Choice.FIZZY_ORANGE), is(equalTo(Optional.of(Can.FANTA))));
    }

    @Test
    public void addsInserts() {
        machine.insert(50);
        machine.insert(50);
        assertThat(machine.deliver(Choice.FIZZY_ORANGE), is(equalTo(Optional.of(Can.FANTA))));
    }
}
