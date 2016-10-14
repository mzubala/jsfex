package pl.bottega.jsfex.cart.model;

import pl.bottega.jsfex.catalog.model.Money;
import pl.bottega.jsfex.catalog.model.Product;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by maciuch on 04.10.16.
 */
public class Cart {

    private Collection<CartItem> items = new HashSet<>();

    public void add(Product product) {
        CartItem i = items.stream().filter(it -> it.product.equals(product))
                .findFirst()
                .orElse(new CartItem(product));
        i.inc();
        items.add(i);
    }

    public int itemsCount() {
        return items.stream().map(i -> i.count).reduce(0, Integer::sum);
    }

    public class CartItem {

        private Product product;

        private int count;

        public CartItem(Product product) {
            this.product = product;
        }

        public void inc() {
            count++;
        }

        public String getName() {
            return product.getName();
        }

        public int getCount() {
            return count;
        }

        public Money getTotal() {
            return product.getPrice().times(count);
        }
    }

    public Collection<CartItem> getItems() {
        return items;
    }

    public Money getTotal() {
        return this.items.stream().
                reduce(new Money(),
                        (acc, i) -> acc.add(i.getTotal()),
                        (i1, i2) -> i1.add(i2)
                );
    }

}
