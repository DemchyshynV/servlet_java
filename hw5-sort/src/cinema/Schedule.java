package cinema;

import lombok.*;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@Data

public class Schedule {

    private Set<Seance> seances;

    public Schedule() {
        this.seances = new TreeSet<>();
    }

    public void addSeance(Seance seance) {
        if (this.seances.contains(seance)) {
            System.out.println(seance + " wasn't added, because in the schedule already exists seance which starts at the same time\n");
            return;
        }

        this.seances.add(seance);
        System.out.println(seance + " has been added\n");
    }

    public void removeSeance(Seance seance) {
        if (this.seances.isEmpty()) {
            System.out.println("\tcannot remove, because the schedule is empty\n");
            return;
        }

        Iterator<Seance> seanceIterator = this.seances.iterator();

        while (seanceIterator.hasNext()) {
            Seance film = seanceIterator.next();
            if (film.equals(seance)) {
                seanceIterator.remove();
                System.out.println("\t" + film + " has been removed\n");
                return;
            }
        }


        // or
//        boolean isRemoved = this.seances.removeIf(film -> film.equals(seance));
//
//        if (isRemoved) {
//            System.out.println("\t" + seance + " has been removed\n");
//            return;
//        }
//
        System.out.println("\t" + seance + " doesn't exists in the schedule\n");
    }
}
