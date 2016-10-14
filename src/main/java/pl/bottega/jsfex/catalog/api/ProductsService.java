package pl.bottega.jsfex.catalog.api;

import pl.bottega.jsfex.catalog.model.Product;
import pl.bottega.jsfex.catalog.model.Money;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by maciuch on 04.10.16.
 */
public class ProductsService {

    private static final Collection<Product> PRODUCTS = new LinkedList<>();

    static {
        PRODUCTS.add(new Product("Bike", new Money(100)));
        PRODUCTS.add(new Product("Car", new Money(200)));
        PRODUCTS.add(new Product("Horse", new Money(300)));
        PRODUCTS.add(new Product("Chainsaw", new Money(400)));
    }

    public Collection<Product> searchProducts() {
        return PRODUCTS;
    }

}
