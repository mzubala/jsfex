package pl.bottega.jsfex.catalog.model;

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
