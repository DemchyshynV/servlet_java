package atelier;

import atelier.interfaces.MensClothes;
import atelier.interfaces.WomensClothes;

public class StartPoint {

    public static void main(String[] args) {

        Atelier atelier = new Atelier();

        System.out.println("men's wardrobe: ");
        for (MensClothes mensClothes : atelier.getMensWardrobe()) {
            System.out.println(mensClothes.getClass().getSimpleName() + ": " + mensClothes);
        }
        System.out.println("_________________________");

        System.out.println("women's wardrobe: ");
        for (WomensClothes womensClothes : atelier.getWomensWardrobe()) {
            System.out.println(womensClothes.getClass().getSimpleName() + ": " + womensClothes);
        }
        System.out.println("_________________________");



        for (MensClothes item : atelier.getMensWardrobe()) {
            item.dressMan();
        }
        System.out.println("_________________________");

        for (WomensClothes item : atelier.getWomensWardrobe()) {
            item.dressWoman();
        }
        System.out.println("_________________________");



        System.out.println("all clothing in atelier: ");
        for (Clothing clothing : atelier.getClothing()) {
            System.out.print(clothing.getClass().getSimpleName() + " with color: " + clothing.getColor() +
                             ", price: " + clothing.getPrice() + ", ");
            clothing.getSize().getDescription();
        }
    }
}
