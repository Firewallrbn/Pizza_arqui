
package edu.unisabana.pizzafactory.consoleview;

import edu.unisabana.pizzafactory.model.Amasador;
import edu.unisabana.pizzafactory.model.ExcepcionParametrosInvalidos;
import edu.unisabana.pizzafactory.model.Horneador;
import edu.unisabana.pizzafactory.model.Ingrediente;
import edu.unisabana.pizzafactory.model.Moldeador;
import edu.unisabana.pizzafactory.model.PizzaDelgadaFactory;
import edu.unisabana.pizzafactory.model.PizzaFactory;
import edu.unisabana.pizzafactory.model.PizzaGruesaFactory;
import edu.unisabana.pizzafactory.model.PizzaIntegralFactory;
import edu.unisabana.pizzafactory.model.Tamano;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */
public class PreparadorPizza {

    private final PizzaFactory factory;

    public PreparadorPizza(PizzaFactory factory) {
        this.factory = factory;
    }

    public static void main(String args[]) {
        try {
            Ingrediente[] ingredientes = new Ingrediente[] { new Ingrediente("queso", 1), new Ingrediente("jamon", 2) };

            // Thin Crust
            PizzaFactory thinFactory = PizzaFactory.getFactory("delgada");
            PreparadorPizza ppThin = new PreparadorPizza(thinFactory);
            System.out.println("--- Preparando Pizza Delgada ---");
            ppThin.prepararPizza(ingredientes, Tamano.MEDIANO);

            // Thick Crust
            PizzaFactory thickFactory = PizzaFactory.getFactory("gruesa");
            PreparadorPizza ppThick = new PreparadorPizza(thickFactory);
            System.out.println("\n--- Preparando Pizza Gruesa ---");
            ppThick.prepararPizza(ingredientes, Tamano.MEDIANO);

            // Integral Crust
            PizzaFactory integralFactory = PizzaFactory.getFactory("integral");
            PreparadorPizza ppIntegral = new PreparadorPizza(integralFactory);
            System.out.println("\n--- Preparando Pizza Integral ---");
            ppIntegral.prepararPizza(ingredientes, Tamano.MEDIANO);

        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE,
                    "Problema en la preparacion de la Pizza", ex);
        }
    }

    public void prepararPizza(Ingrediente[] ingredientes, Tamano tam)
            throws ExcepcionParametrosInvalidos {
        Amasador am = factory.crearAmasador();
        Horneador hpd = factory.crearHorneador();
        Moldeador mp = factory.crearMoldeador();

        am.amasar();
        if (tam == Tamano.PEQUENO) {
            mp.moldearPizzaPequena();
        } else if (tam == Tamano.MEDIANO) {
            mp.moldearPizzaMediana();
        } else {
            throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:" + tam);
        }
        aplicarIngredientes(ingredientes);
        hpd.hornear();
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES!:{0}", Arrays.toString(ingredientes));

        // CODIGO DE LLAMADO AL MICROCONTROLADOR

    }

}
