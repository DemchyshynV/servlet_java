package zooClub;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Pet implements Serializable {
    private String name;
    private String specie;
}
