package cinema;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class Movie {

    private String title;
    private Time duration;

    public void setDuration(Time duration, Seance seance) {
        if (seance == null) {
            System.out.println("cannot change duration, because season is null!");
            return;
        }

        this.duration = duration;
        seance.setEndTime();        // to update end time
    }

    @Override
    public String toString() {
        return "movie=(title = " + title + ", duration = " + duration + ")";
    }
}
