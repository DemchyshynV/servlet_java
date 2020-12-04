package atelier;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Atelier {

    private List<Clothing> clothing = new ArrayList<>();

    {
        clothing.add(new Dress(SizeOfClothing.S, 30.6, "pink"));
        clothing.add(new Dress(SizeOfClothing.L, 37.6, "red"));
        clothing.add(new Tie(SizeOfClothing.M, 25.7, "blue"));
        clothing.add(new Trousers(SizeOfClothing.XS, 32.8, "black"));
        clothing.add(new Trousers(SizeOfClothing.S, 41.8, "brown"));
        clothing.add(new TShirt(SizeOfClothing.XXS, 18.9, "green"));
    }

    public List<MensClothes> getMensWardrobe() {
        List<MensClothes> mensWardrobe = new ArrayList<>();

        for (Clothing item : clothing) {
            if (item instanceof MensClothes) {
                mensWardrobe.add((MensClothes) item);
            }
        }

        return mensWardrobe;
    }

    public List<WomensClothes> getWomensWardrobe() {
        List<WomensClothes> womensWardrobe = new ArrayList<>();

        for (Clothing item : clothing) {
            if (item instanceof WomensClothes) {
                womensWardrobe.add((WomensClothes) item);
            }
        }

        return womensWardrobe;
    }
}
