package cinema;

import cinema.enums.Days;
import lombok.*;

import java.util.Iterator;
import java.util.TreeMap;

@Getter
@EqualsAndHashCode
@ToString

public class Cinema {

    private final TreeMap<Days, Schedule> cinema;
    private Time open;
    private Time close;

    public Cinema(Time open, Time close) {
        this.cinema = new TreeMap<>();
        this.setOpen(open);
        this.setClose(close);
    }

    public void setOpen(Time open) {
        if (open.getHour() < 9 || open.getHour() > 12) {
            System.out.println("incorrect open time");
            return;
        }

        this.open = open;
    }

    public void setClose(Time close) {
        if (close.getHour() < 20 || close.getHour() > 24) {
            System.out.println("incorrect close time");
            return;
        }

        this.close = close;
    }


    public void addSeances(Days day, Seance ...seances) {
        if (this.getOpen() == null || this.getClose() == null) {
            System.out.println("set correct open and close time and then add films to the cinema\n");
            return;
        }

        if (!this.cinema.containsKey(day)) {
            this.addSeancesIfDayIsNotInTheSchedule(day, seances);
            return;
        }

        this.addSeancesIfDayIsInTheSchedule(day, seances);
    }


    public void addSeance(Days day, Seance seance) {
        if (this.getOpen() == null || this.getClose() == null) {
            System.out.println("set correct open and close time and then add films to the cinema\n");
            return;
        }

        if (this.schedulesChecker(seance)) {
            System.out.println("cannot add " + seance + " because the cinema is closed at such time");
            return;
        }

        if (this.cinema.containsKey(day)) {
            this.cinema.get(day).addSeance(seance);
            return;
        }

        this.addSeancesIfDayIsNotInTheSchedule(day, seance);
    }


    public void removeMovie(Movie movie) {
        if (this.cinema.values().isEmpty()) {
            System.out.println("\tcannot remove, because the schedule is empty\n");
            return;
        }

        int moviesQuantityBeforeRemoval = 0;
        int moviesQuantityAfterRemoval = 0;

        Iterator<Schedule> scheduleIterator = this.cinema.values().iterator();

        while (scheduleIterator.hasNext()) {
            Schedule schedule = scheduleIterator.next();
            moviesQuantityBeforeRemoval += schedule.getSeances().size();

            schedule.getSeances().removeIf(seance -> seance.getMovie().equals(movie));
        }


        // or
//        for (Schedule schedule : this.cinema.values()) {
//            moviesQuantityBeforeRemoval += schedule.getSeances().size();
//            schedule.getSeances().removeIf(seance -> seance.getMovie().equals(movie));
//        }


        for (Schedule schedule : this.cinema.values()) {
            moviesQuantityAfterRemoval += schedule.getSeances().size();
        }

        if (moviesQuantityBeforeRemoval == moviesQuantityAfterRemoval) {
            System.out.println("\t" + movie + " is not in the cinema\n");
            return;
        }

        System.out.println("all seances with " + movie + " have been removed\n");
        this.removeDayFromCinemaWithoutSeances();
    }


    public void removeSeance (Days day, Seance seance) {
        if (this.cinema.values().isEmpty()) {
            System.out.println("\tcannot remove, because the schedules are empty\n");
            return;
        }

        if (!this.cinema.containsKey(day)) {
            System.out.println("\t" + day + " is not in the schedule in the cinema\n");
            return;
        }

//        Iterator<Seance> seanceIterator = this.cinema.get(day).getSeances().iterator();
//
//        while (seanceIterator.hasNext()) {
//            Seance film = seanceIterator.next();
//
//            if (film.equals(seance)) {
//                seanceIterator.remove();
//                System.out.println("\t" + film + " film has been removed\n");
//                this.removeDayFromCinemaWithoutSeances();
//                return;
//            }
//        }


        // or
        boolean isRemoved = this.cinema.get(day).getSeances().removeIf(film -> film.equals(seance));

        if (isRemoved) {
            System.out.println("\t" + seance + " film has been removed\n");
            this.removeDayFromCinemaWithoutSeances();
            return;
        }

        System.out.println("\t" + seance + " doesn't exists in the schedule on " + day + "\n");


        // or
//        this.cinema.get(day).removeSeance(seance);

        this.removeDayFromCinemaWithoutSeances();
    }


    public boolean schedulesChecker(Seance seance) {
        return seance.getStartTime().getHour() < this.getOpen().getHour() ||
               seance.getEndTime().getHour() > this.getClose().getHour() ||
               (seance.getEndTime().getHour() == this.getClose().getHour() && seance.getEndTime().getMin() > this.getClose().getMin()) ||
               (seance.getStartTime().getHour() == this.getOpen().getHour() && seance.getStartTime().getMin() < this.getOpen().getMin());
    }


    public void addSeancesIfDayIsNotInTheSchedule(Days day, Seance ...seances) {
        Schedule schedule = new Schedule();

        for (Seance seance : seances) {
            if (this.schedulesChecker(seance)) {
                System.out.println("cannot add " + seance + " because the cinema is closed at such time\n");

            } else {
                schedule.addSeance(seance);
            }
        }

        this.cinema.put(day, schedule);
    }


    public void addSeancesIfDayIsInTheSchedule(Days day, Seance ...seances) {
        for (Seance seance : seances) {
            if (this.schedulesChecker(seance)) {
                System.out.println("cannot add " + seance + " because the cinema is closed at such time\n");

            } else {
                this.cinema.get(day).addSeance(seance);
            }
        }
    }


    public void removeDayFromCinemaWithoutSeances() {
        // 1)
//        Iterator<Days> daysIterator = this.cinema.keySet().iterator();
//
//        while (daysIterator.hasNext()) {
//            Days day = daysIterator.next();
//
//            if (this.cinema.get(day).getSeances().isEmpty()) {
//                daysIterator.remove();
//            }
//        }


        // 2)
        this.cinema.keySet().removeIf(day -> this.cinema.get(day).getSeances().isEmpty());


        // 3)
//        for (Days day : this.cinema.keySet()) {
//            if (this.cinema.get(day).getSeances().isEmpty()) {
//                this.cinema.remove(day);
//            }
//        }
    }
}
