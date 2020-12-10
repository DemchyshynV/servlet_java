package products;

import products.enums.ProductType;

public class StartPoint {

    public static void main(String[] args) {

        Store store = new Store();
        Product product = new Product(9, "app7e", 0.5, ProductType.FRUITS, "Ukraine", "red");

        store.addProduct(product);

//        store.removeProduct("apple");

//        store.increasePrice(ProductType.FRUITS);

//        store.showPremiumProducts(7.7);

//        store.productsQuantityByProductType(ProductType.FRUITS);

//        store.averageProductsCost();
    }
}
