# Pizza Factory - Implementación de Patrones Creacionales

Este proyecto ilustra el uso del patrón Fábrica Abstracta para desacoplar la lógica de preparación de pizzas de los detalles de implementación de sus ingredientes y procesos.

## Arquitectura de la Solución

Para cumplir con los estándares de diseño sugeridos en la [referencia de clase](https://github.com/CesarAVegaF312/DYAS-GoF-FactoryMethod-ReferenceExample), se ha implementado el patron de fabrica abtracta.

### 1. Desacoplamiento de la Instanciación
Originalmente, el cliente instanciaba directamente las fábricas concretas. Ahora, la clase base `PizzaFactory` actúa como un punto de entrada centralizado:

## Guía de Ejecución

El punto de entrada es la clase `PreparadorPizza`, la cual demuestra el funcionamiento con los tres tipos de masa:

```java
// Obtención de la fábrica sin instanciación directa por el cliente
PizzaFactory factory = PizzaFactory.getFactory("integral");

// Preparación de la pizza delegando la creación de componentes a la fábrica
PreparadorPizza preparador = new PreparadorPizza(factory);
preparador.prepararPizza(ingredientes, Tamano.MEDIANO);
```

### Resultado Esperado
La consola mostrará los logs de ejecución específicos para cada tipo de masa, evidenciando que el comportamiento interno cambia dinámicamente según la fábrica provista.

