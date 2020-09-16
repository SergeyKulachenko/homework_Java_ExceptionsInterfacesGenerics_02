package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

public class TicketTravelTime<T> implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }

    private T value;

    public TicketTravelTime(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
    public boolean isEmpty() {
        return value == null;
    }
}
