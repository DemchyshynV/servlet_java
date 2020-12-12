package cinema;

import lombok.*;

@NoArgsConstructor
@Getter
@EqualsAndHashCode

public class Seance implements Comparable<Seance> {

    private Movie movie;
    private Time startTime;
    private Time endTime;

    public Seance(Movie movie, Time startTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.setEndTime();
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
        this.setEndTime();                        // to update end time
    }

    public void setEndTime() {
        int hour = this.startTime.getHour() + this.movie.getDuration().getHour();
        int min = this.startTime.getMin() + this.movie.getDuration().getMin();

        if (hour > 23) {
            hour -= 24;
        }

        if (min > 59) {
            hour += 1;
            min -= 60;
        }

        this.endTime = new Time(hour, min);
    }

    @Override
    public int compareTo(Seance seance) {
        int startHour = this.startTime.getHour() - seance.startTime.getHour();

        if (startHour != 0) {
            return startHour;
        }

        return this.startTime.getMin() - seance.startTime.getMin();
    }

    @Override
    public String toString() {
        return "Seance{" + movie +
                ", startTime = " + startTime +
                ", endTime = " + endTime +
                '}';
    }
}
