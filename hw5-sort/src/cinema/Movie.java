package cinema;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode

public class Movie {

    private String title;
    private Time duration;

    public void setDuration(Time duration, Seance seance) {
        if (duration.getHour() == 0 && duration.getMin() == 0) {
            System.out.println("duration cannot equals zero");
            return;
        }

        if (seance == null) {
            System.out.println("cannot change duration, because season is null!");
            return;
        }

        this.duration = duration;
        seance.setEndTime();        // to update end time
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "movie=(title = " + title + ", duration = " + duration + ")";
    }
}
