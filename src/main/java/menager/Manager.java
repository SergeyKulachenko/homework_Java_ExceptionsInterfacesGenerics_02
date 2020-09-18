package menager;

import domain.Ticket;
import repository.Repository;

import java.util.Arrays;
import java.util.Comparator;

public class Manager {
    Repository repositoryM = new Repository();

    public void save(Ticket tiket) {
        repositoryM.add(tiket);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket tik : repositoryM.findAll()) {
            Ticket[] temp = new Ticket[result.length + 1];
            if (tik.getAirportFrom().equals(from) || tik.getAirportTo().equals(to)) {
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = tik;
                result = temp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket tik : repositoryM.findAll()) {
            Ticket[] temp = new Ticket[result.length + 1];
            if (tik.getAirportFrom().equals(from) || tik.getAirportTo().equals(to)) {
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = tik;
                result = temp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }


    Comparator<Ticket> ticketComparator = new Comparator<Ticket>() {
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return o1.getTravelTime() - (o2.getTravelTime());
        }
    };

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket tik : repositoryM.findAll()) {
            Ticket[] temp = new Ticket[result.length + 1];
            if (tik.getAirportFrom().equals(from) || tik.getAirportTo().equals(to)) {
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = tik;
                result = temp;
            }
        }
        Arrays.sort(result, ticketComparator);
        return result;
    }
}
