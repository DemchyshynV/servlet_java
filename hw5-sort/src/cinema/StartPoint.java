package cinema;

import cinema.enums.Days;

import java.util.Map;

public class StartPoint {

    public static void main(String[] args) {

        Time duration = new Time(2, 50);
        Time duration2 = new Time(1, 30);
        Time duration3 = new Time(2, 25);
        Time duration4 = new Time(1, 28);

        Movie movie = new Movie("film1", duration);
        Movie movie2 = new Movie("film2", duration2);
        Movie movie3 = new Movie("film3", duration3);
        Movie movie4 = new Movie("film4", duration4);
        Movie movie5 = new Movie("film5", duration);

        Time startTime = new Time(10, 20);
        Time startTime2 = new Time(14, 10);
        Time startTime3 = new Time(11, 0);
        Time startTime4 = new Time(9, 5);

        Seance seance = new Seance(movie5, startTime);
        Seance seance2 = new Seance(movie2, startTime3);
        Seance seance3 = new Seance(movie3, startTime3);
        Seance seance4 = new Seance(movie4, startTime4);
        Seance seance5 = new Seance(movie, startTime3);
        Seance seance6 = new Seance(movie3, startTime2);
        Seance seance7 = new Seance(movie2, startTime2);
        Seance seance8 = new Seance(movie4, startTime4);

//        Schedule schedule = new Schedule();
//        schedule.addSeance(seance);
//        schedule.addSeance(seance3);
//        schedule.addSeance(seance6);

        Cinema cinema = new Cinema(new Time(9, 0), new Time(20, 30));
        cinema.addSeance(Days.SATURDAY, seance);
        cinema.addSeances(Days.FRIDAY, seance, seance3, seance2);
        cinema.addSeance(Days.SUNDAY, seance);
//        cinema.addSeances(Days.MONDAY, seance, seance3, seance2);
//        cinema.addSeances(Days.MONDAY, seance);
        cinema.addSeance(Days.MONDAY, seance);

        cinema.removeMovie(movie);
//        cinema.removeMovie(movie5);
//        cinemaIterator(cinema);
//
        cinema.removeSeance(Days.FRIDAY, seance3);
        cinemaIterator(cinema);
    }

    public static void cinemaIterator(Cinema cinema) {
        if (cinema.getCinema().isEmpty()) {
            System.out.println("there are no seances in the cinema");
        }

        for (Map.Entry<Days, Schedule> daysScheduleEntry : cinema.getCinema().entrySet()) {
            System.out.println("\n\t" + daysScheduleEntry.getKey() + ":");

            for (Seance film : daysScheduleEntry.getValue().getSeances()) {
                System.out.println("\t\t" + film + "\n");
            }
        }
    }
}
