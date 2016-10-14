package pl.bottega.jsfex.catalog.model;

/**
 * Created by maciuch on 07.10.16.
 */
public class Money {

    private int cents;

    public Money(int cents) {
        this.cents = cents;
    }

    public Money() {

    }

    public Money add(Money m) {
        return new Money(m.cents + cents);
    }

    public int intPart() {
        return cents / 100;
    }


    public int fracPart() {
        return cents % 100;
    }

    public Money times(int count) {
        return new Money(this.cents * count);
    }
}
