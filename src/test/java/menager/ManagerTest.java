package menager;

import domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Manager manager = new Manager();
    private Ticket tik1 = new Ticket(1, 5682.35, "VKO", "SIP", 286);
    private Ticket tik2 = new Ticket(2, 5850.89, "DME", "AER", 268);
    private Ticket tik3 = new Ticket(3, 4235.34, "SVO", "MMK", 256);
    private Ticket tik4 = new Ticket(4, 3852.00, "BKA", "MMK", 304);

    @BeforeEach
    public void before() {
        manager.save(tik1);
        manager.save(tik2);
        manager.save(tik3);
        manager.save(tik4);
    }

    @Test
    void searchByFrom_() {
        Ticket[] expented = new Ticket[]{tik2};
        Ticket[] actual = manager.searchBy("DME", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOf() {
        Ticket[] expented = new Ticket[]{tik4, tik1};
        Ticket[] actual = manager.searchBy("BKA", "SIP");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchBy_Of() {
        Ticket[] expented = new Ticket[]{tik1};
        Ticket[] actual = manager.searchBy("", "SIP");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByOfFrom() {
        Ticket[] expented = new Ticket[]{};
        Ticket[] actual = manager.searchBy("AER", "BKA");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchBy__() {
        Ticket[] expented = new Ticket[]{};
        Ticket[] actual = manager.searchBy("", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOfOf() {
        Ticket[] expented = new Ticket[]{tik4, tik3, tik2};
        Ticket[] actual = manager.searchBy("DME", "MMK");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOfOfComp() {
        Ticket ticket = new Ticket();
        Ticket[] expented = new Ticket[]{tik3, tik2, tik4};
        Ticket[] actual = manager.findAll("DME", "MMK", Comparator.comparingInt(Ticket::getTravelTime));
        assertArrayEquals(expented, actual);
    }
}