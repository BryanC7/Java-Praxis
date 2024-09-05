package cl.praxis;

import org.junit.jupiter.api.*;
import servicios.Calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }
    
    @Test
    @DisplayName("Prueba de suma de dos números")
    void testSuma() {
        assertEquals(5, calculadora.suma(2, 3), "2 + 3 debería ser 5");
    }

    @Test
    @DisplayName("Prueba de resta de dos números")
    void testResta() {
        assertEquals(-1, calculadora.resta(2, 3), "2 - 3 debería ser -1");
    }

    @Test
    @DisplayName("Prueba de multiplicación de dos números")
    void testMultiplicacion() {
        assertEquals(6, calculadora.multiplicar(2, 3), "2 * 3 debería ser 6");
    }

    @Test
    @DisplayName("Prueba de división de dos números")
    void testDivision() {
        assertEquals(1.5, calculadora.division(3, 2), "3 / 2 debería ser 1.5");
    }
}
