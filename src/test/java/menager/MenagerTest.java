package menager;

import domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MenagerTest {
    private Menager menager = new Menager();
    private Ticket tik1 = new Ticket(1, 5682.35, "VKO", "SIP", 286);
    private Ticket tik2 = new Ticket(2, 5850.89, "DME", "AER", 268);
    private Ticket tik3 = new Ticket(3, 4235.34, "SVO", "MMK", 256);
    private Ticket tik4 = new Ticket(4, 3852.00, "BKA", "MMK", 304);

    @BeforeEach
    public void before() {
        menager.save(tik1);
        menager.save(tik2);
        menager.save(tik3);
        menager.save(tik4);
    }

    @Test
    void searchByFrom_() {
        Ticket[] expented = new Ticket[]{tik2};
        Ticket[] actual = menager.searchBy("DME", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOf() {
        Ticket[] expented = new Ticket[]{tik4, tik1};
        Ticket[] actual = menager.searchBy("BKA", "SIP");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchBy_Of() {
        Ticket[] expented = new Ticket[]{tik1};
        Ticket[] actual = menager.searchBy("", "SIP");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByOfFrom() {
        Ticket[] expented = new Ticket[]{};
        Ticket[] actual = menager.searchBy("AER", "BKA");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchBy__() {
        Ticket[] expented = new Ticket[]{};
        Ticket[] actual = menager.searchBy("", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOfOf() {
        Ticket[] expented = new Ticket[]{tik4, tik3, tik2};
        Ticket[] actual = menager.searchBy("DME", "MMK");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOfOfComp() {
        Ticket[] expented = new Ticket[]{tik3, tik2, tik4};
        Ticket[] actual = menager.findAll("DME", "MMK", Comparator.comparing(Ticket::getTravelTime));
        assertArrayEquals(expented, actual);
    }
}