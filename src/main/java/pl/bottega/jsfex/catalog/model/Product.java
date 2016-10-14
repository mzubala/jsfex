package pl.bottega.jsfex.catalog.model;

/**
 * Created by maciuch on 04.10.16.
 */
public class Product {

    private String name;

    private Money price;

    public Product(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

}
