package cl.praxis.restaurante.javaapp;

import cl.praxis.restaurante.javaapp.models.Detalle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaAppTest {
    public static List<Detalle> detalles = new ArrayList<>();
    public static List<Detalle> detallesVacia = new ArrayList<>();
    public static List<Detalle> detallesNegativos = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        detalles.clear();
        detalles.add(new Detalle(1, 3, 3, "Entrada"));
        detalles.add(new Detalle(2, 6, 3, "Plato Principal"));
        detalles.add(new Detalle(3, 7, 4, "Postre"));
        detalles.add(new Detalle(4, 18, 5, "Plato Principal"));
        detalles.add(new Detalle(5, 20, 10, "Entrada"));
    }

    @Test
    public void verficarCalculoSimpleTest() {
        CalculoDescuento descuentoSimple = new CalculoSimple();
        List<Double> descuentosResultado = descuentoSimple.calculoDescuento(detalles);
        List<Double> descuentosEsperados = Arrays.asList(0.0, 0.05, 0.04, 0.3, 0.15);

        assertEquals(descuentosResultado, descuentosEsperados);
    }

    @Test
    public void verificarCalculoComplejoTest() {
        CalculoDescuento descuentoComplejo = new CalculoComplejo();
        List<Double> descuentosResultado = descuentoComplejo.calculoDescuento(detalles);
        List<Double> descuentosEsperados = Arrays.asList(0.0, 0.15, 0.2, 0.0, 0.3);

        assertEquals(descuentosResultado, descuentosEsperados);
    }

    @Test
    public void verificarCalculoConListaVaciaTest() {

        CalculoDescuento descuentoSimple = new CalculoSimple();
        List<Double> descuentosResultado = descuentoSimple.calculoDescuento(detallesVacia);
        List<Double> descuentosEsperados = Collections.emptyList();

        assertEquals(descuentosResultado, descuentosEsperados);
    }

    @Test
    public void verificarCalculoConElementoNuloTest() {
        detalles.add(null);
        CalculoDescuento descuentoSimple = new CalculoSimple();

        assertThrows(NullPointerException.class, () -> {
            descuentoSimple.calculoDescuento(detalles);
        });
    }

    @Test
    public void verificarCalculoConValoresNegativosTest() {
        detallesNegativos.add(new Detalle(1, -5, -3, "Entrada"));
        CalculoDescuento descuentoSimple = new CalculoSimple();
        List<Double> descuentosResultado = descuentoSimple.calculoDescuento(detallesNegativos);
        List<Double> descuentosEsperados = Arrays.asList(0.0);

        assertEquals(descuentosResultado, descuentosEsperados);
    }
}
