package edu.unisabana.pizzafactory.model;

public abstract class PizzaFactory {

    public static PizzaFactory getFactory(String tipo) {
        if (tipo.equalsIgnoreCase("delgada")) {
            return new PizzaDelgadaFactory();
        } else if (tipo.equalsIgnoreCase("gruesa")) {
            return new PizzaGruesaFactory();
        } else if (tipo.equalsIgnoreCase("integral")) {
            return new PizzaIntegralFactory();
        }
        return null;
    }

    public abstract Amasador crearAmasador();

    public abstract Moldeador crearMoldeador();

    public abstract Horneador crearHorneador();
}
