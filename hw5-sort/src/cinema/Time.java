package cinema;

import lombok.*;

@NoArgsConstructor
@Getter
@EqualsAndHashCode

public class Time {

    private int hour;
    private int min;

    public Time(int hour, int min) {
        this.setHour(hour);
        this.setMin(min);
    }

    private void setHour(int hour) {                      // only for constructor
        this.hourChecker(hour);
    }

    private void setMin(int min) {                        // only for constructor
        this.minChecker(min);
    }

    public void setHour(int hour, Seance seance) {       // for future changes
        if (seance == null) {
            System.out.println("cannot change hour, because season is null!");
            return;
        }

        this.hourChecker(hour);
        seance.setEndTime();                            // to update end time
    }

    public void setMin(int min, Seance seance) {        // for future changes
        if (seance == null) {
            System.out.println("cannot change min, because season is null!");
            return;
        }

        this.minChecker(min);
        seance.setEndTime();                            // to update end time
    }

    private void hourChecker(int hour) {
        if (hour < 0 || hour > 23) {
            System.out.println("hour cannot be less than zero or greater than 23");
            return;
        }

        this.hour = hour;
    }

    private void minChecker(int min) {
        if (min < 0 || min > 59) {
            System.out.println("min cannot be less than zero or greater than 59");
            return;
        }

        this.min = min;
    }

    @Override
    public String toString() {
        if (this.min < 10) {
            return this.hour + ":0" + this.min;
        }

        return this.hour + ":" + this.min;
    }
}
