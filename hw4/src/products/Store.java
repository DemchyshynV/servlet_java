package products;

import lombok.*;
import products.enums.ProductType;
import products.helper.Helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Data

public class Store {

    private List<Product> products = new ArrayList<>();

    {
        this.products.add(new Product(1, "phone", 200.88, ProductType.ELECTRONICS, "USA", "black"));
        this.products.add(new Product(2, "apple", 0.5, ProductType.FRUITS, "Ukraine", "red"));
        this.products.add(new Product(3, "skirt", 10.11, ProductType.CLOTHING, "CHINA", "blue"));
        this.products.add(new Product(4, "carrot", 0.3, ProductType.VEGETABLES, "Ukraine", "orange"));
        this.products.add(new Product(5, "TV", 105.8, ProductType.ELECTRONICS, "CHINA", "silver"));
        this.products.add(new Product(6, "shirt", 7.7, ProductType.CLOTHING, "Turkey", "white"));
        this.products.add(new Product(7, "earphones", 5.1, ProductType.ELECTRONICS, "CHINA", "white"));
    }


    public void addProduct(Product product) {
        for (Product productFromStore: products) {
            if (productFromStore.getId() == product.getId()) {
                System.out.println("product with the same id already exists");
                return;
            }
        }

        if (product.getPrice() <= 0) {
            System.out.println("incorrect price, the product mustn't cost zero or have negative price!");
            return;
        }

        if (product.getName().matches("(.*[0-9]+.*)")) {
            System.out.println("incorrect name, the name mustn't contain numbers!");
            return;
        }

        // or :D
//        for (String num : Helper.stringNumbersCreator()) {
//            if (product.getName().contains(num)) {
//                System.out.println("incorrect name, the name mustn't contain numbers!");
//                return;
//            }
//        }

        this.products.add(product);
        System.out.println("the product has been added.");
    }


    public void removeProduct(String name) {
//        int productNumbers = this.products.size();
//
//        this.products.removeIf(product -> product.getName().equals(name));
//
//        if (productNumbers == this.products.size()) {
//            System.out.println("the product hasn't been removed, there is no product with this name in the store.");
//            return;
//        }
//
//        System.out.println("the product has been removed.");

        // or
//        for (Product product : products) {
//            if (product.getName().equals(name)) {
//                this.products.remove(product);
//                System.out.println("the product has been removed.");
//                return;
//            }
//        }
//
//        System.out.println("the product hasn't been removed, there is no product with this name in the store.");

        // or
        Iterator<Product> productIterator = this.products.iterator();

        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getName().equals(name)) {
                productIterator.remove();
            }
        }
    }


    public void increasePrice (ProductType productType) {
        for (Product product : products) {
            if (product.getType().equals(productType)) {
                product.setPrice(product.getPrice() * 2);
            }
        }
    }


    public void showPremiumProducts(double price) {
        List<Product> premiumProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getPrice() > price) {
                premiumProducts.add(product);
            }
        }

        if (premiumProducts.isEmpty()) {
            System.out.println("the store has no products cost more than - " + price);
            return;
        }

        System.out.println("premium products in the store - " + premiumProducts.size() + " items: ");
        premiumProducts.forEach(System.out::println);
    }


    public void productsQuantityByProductType(ProductType productType) {
        int productsQuantity = 0;
        double totalCostOfProducts = 0;

        for (Product product : products) {
            if (product.getType().equals(productType)) {
                productsQuantity++;
                totalCostOfProducts += product.getPrice();
            }
        }

        if (productsQuantity == 0) {
            System.out.println("there is no products in the store with " + productType + " category");
            return;
        }

        System.out.println("quantity of products by " + productType + " category - " +
                           productsQuantity + "\ntotal cost of products - " + totalCostOfProducts);
    }


    public void averageProductsCost() {
        double totalCostOfProducts = 0;

        for (Product product : products) {
            totalCostOfProducts += product.getPrice();
        }

        System.out.println(totalCostOfProducts / this.products.size());
    }
}
