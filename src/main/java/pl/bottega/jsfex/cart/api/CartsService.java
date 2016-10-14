package pl.bottega.jsfex.cart.api;

import pl.bottega.jsfex.cart.model.Cart;
import pl.bottega.jsfex.catalog.model.Product;

public class CartsService {

	private static final Cart CART = new Cart();

	public void addToCart(Product product) {
		CART.add(product);
	}

	public Cart getCurrentCart() {
		return CART;
	}

}
