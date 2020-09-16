package menager;

import domain.Tiket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Manager manager = new Manager();
    private Tiket tik1 = new Tiket(1, 5682.35, "VKO", "SIP", 286);
    private Tiket tik2 = new Tiket(2, 5850.89, "DME", "AER", 199);
    private Tiket tik3 = new Tiket(3, 4235.34, "SVO", "MMK", 256);
    private Tiket tik4 = new Tiket(4, 3852.00, "BKA", "MMK", 304);

    @BeforeEach
    public void before() {
        manager.save(tik1);
        manager.save(tik2);
        manager.save(tik3);
        manager.save(tik4);
    }

    @Test
    void searchByFrom_() {
        Tiket[] expented = new Tiket[]{tik2};
        Tiket[] actual = manager.searchBy("DME", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOf() {
        Tiket[] expented = new Tiket[]{tik4, tik1};
        Tiket[] actual = manager.searchBy("BKA", "SIP");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchBy_Of() {
        Tiket[] expented = new Tiket[]{tik1};
        Tiket[] actual = manager.searchBy("", "SIP");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByOfFrom() {
        Tiket[] expented = new Tiket[]{};
        Tiket[] actual = manager.searchBy("AER", "BKA");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchBy__() {
        Tiket[] expented = new Tiket[]{};
        Tiket[] actual = manager.searchBy("", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOfOf() {
        Tiket[] expented = new Tiket[]{tik4, tik3, tik2};
        Tiket[] actual = manager.searchBy("DME", "MMK");
        assertArrayEquals(expented, actual);
    }
}