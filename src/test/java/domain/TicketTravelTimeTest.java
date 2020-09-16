package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTravelTimeTest {
    @Test
    public void shouldParametrizedWithProduct() {
        Ticket ticket = new Ticket();
        TicketTravelTime<Ticket> ticketTravelTime = new TicketTravelTime<>(ticket);
        Ticket value = ticketTravelTime.getValue();
        assertEquals(ticket, value);
    }

    @Test
    public void shouldParametrizedWithString() {
        String str = "Hello world";
        TicketTravelTime<String> stringBox = new TicketTravelTime<>(str);
        String value = stringBox.getValue();
        assertEquals(str, value);
    }
}