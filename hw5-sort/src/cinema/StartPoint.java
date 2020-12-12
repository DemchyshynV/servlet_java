package cinema;

import cinema.enums.Days;

import java.util.Map;

public class StartPoint {

    public static void main(String[] args) {

        Time duration = new Time(2, 50);
        Time duration2 = new Time(1, 30);
        Time duration3 = new Time(2, 25);
        Time duration4 = new Time(1, 28);

        Movie aboutTime = new Movie("About time", duration);
        Movie theShallows = new Movie("The shallows", duration2);
        Movie homeAlone = new Movie("Home alone", duration3);
        Movie forrestGump = new Movie("Forrest Gump", duration4);
        Movie downhill = new Movie("Downhill", duration);

        Time startTime = new Time(10, 20);
        Time startTime2 = new Time(14, 10);
        Time startTime3 = new Time(11, 0);
        Time startTime4 = new Time(9, 5);

        Seance seance = new Seance(downhill, startTime);
        Seance seance2 = new Seance(theShallows, startTime3);
        Seance seance3 = new Seance(homeAlone, startTime3);
        Seance seance4 = new Seance(forrestGump, startTime4);
        Seance seance5 = new Seance(aboutTime, startTime3);
        Seance seance6 = new Seance(homeAlone, startTime2);
        Seance seance7 = new Seance(theShallows, startTime2);
        Seance seance8 = new Seance(forrestGump, startTime4);

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
