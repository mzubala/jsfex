package pl.bottega.jsfex.catalog.ui;

import pl.bottega.jsfex.catalog.model.Money;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

/**
 * Created by maciuch on 07.10.16.
 */
@Named
@RequestScoped
public class MoneyConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return new Money(Double.parseDouble(value));
        }
        catch(NumberFormatException nfe) {
            throw new ConverterException(new FacesMessage("Invalid number format"));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Money m = (Money) value;
        return String.format("$%d.%02d", m.intPart(), m.fracPart());
    }
}
