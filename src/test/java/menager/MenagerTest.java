package menager;

import domain.Tiket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenagerTest {
    private Menager menager = new Menager();
    private Tiket tik1 = new Tiket(1, 5682.35, "VKO", "SIP", 286);
    private Tiket tik2 = new Tiket(2, 5850.89, "DME", "AER", 199);
    private Tiket tik3 = new Tiket(3, 4235.34, "SVO", "MMK", 256);
    private Tiket tik4 = new Tiket(4, 3852.00, "BKA", "MMK", 304);

    @BeforeEach
    public void before() {
        menager.save(tik1);
        menager.save(tik2);
        menager.save(tik3);
        menager.save(tik4);
    }

    @Test
    void searchByFrom_() {
        Tiket[] expented = new Tiket[]{tik2};
        Tiket[] actual = menager.searchBy("DME", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOf() {
        Tiket[] expented = new Tiket[]{tik4, tik1};
        Tiket[] actual = menager.searchBy("BKA", "SIP");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchBy_Of() {
        Tiket[] expented = new Tiket[]{tik1};
        Tiket[] actual = menager.searchBy("", "SIP");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByOfFrom() {
        Tiket[] expented = new Tiket[]{};
        Tiket[] actual = menager.searchBy("AER", "BKA");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchBy__() {
        Tiket[] expented = new Tiket[]{};
        Tiket[] actual = menager.searchBy("", "");
        assertArrayEquals(expented, actual);
    }

    @Test
    void searchByFromOfOf() {
        Tiket[] expented = new Tiket[]{tik4, tik3, tik2};
        Tiket[] actual = menager.searchBy("DME", "MMK");
        assertArrayEquals(expented, actual);
    }
}