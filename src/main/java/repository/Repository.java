package repository;

import domain.Tiket;

public class Repository {
    private Tiket[] tikets = new Tiket[0];

    public void add(Tiket tiket) {       //добавить
        int leng = tikets.length + 1;
        Tiket[] temp = new Tiket[leng];
        System.arraycopy(tikets, 0, temp, 0, tikets.length);
        int lastInd = temp.length - 1;
        temp[lastInd] = tiket;
        tikets = temp;
    }

    public Tiket[] findAll() {            //получить список
        return tikets;
    }

    public void removeById(int id) {      //удалить
        int leng = tikets.length + 1;
        Tiket[] temp = new Tiket[leng];
        int index = 0;
        for (Tiket tiket : tikets) {
            if (tiket.getId() != id) {
                temp[index] = tiket;
                index++;
            }
        }
        tikets = temp;
    }
}
