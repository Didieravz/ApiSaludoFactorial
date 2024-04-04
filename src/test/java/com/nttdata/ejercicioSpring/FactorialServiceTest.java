
package com.nttdata.ejercicioSpring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Didier Virguez
 * Clase encargada de realizar las pruebas unitarias del factorial
 */

@ExtendWith(MockitoExtension.class)
public class FactorialServiceTest {
    
    @Mock
    private FactorialService factorialService;

    @InjectMocks
    private FactorialService factorialServiceUnderTest;

    @Test
    public void testCalcularFactorial_NumeroPositivo() {
        // Defini el número para el cálculo del factorial
        int numero = 5;

        // Calcula el factorial esperado
        BigDecimal factorialEsperado = new BigDecimal("120");

        // Llama al método calcularFactorial del servicio real
        BigDecimal factorialCalculado = factorialServiceUnderTest.calcularFactorial(numero);

        // Verifica si el factorial calculado es igual al factorial esperado
        assertEquals(factorialEsperado, factorialCalculado);
    }
    
     @Test
    public void testCalcularFactorial_NumeroCero() {
        // Defini el número cero para el cálculo del factorial
        int numero = 0;

        // Calcula el factorial esperado
        BigDecimal factorialEsperado = BigDecimal.ONE;

        // Llama al método calcularFactorial del servicio real
        BigDecimal factorialCalculado = factorialServiceUnderTest.calcularFactorial(numero);

        // Verifica si el factorial calculado es igual al factorial esperado
        assertEquals(factorialEsperado, factorialCalculado);
    }
    
    @Test
    public void testCalcularFactorial_NumeroNegativo() {
        // Define un número negativo para el cálculo del factorial
        int numero = -5;

        // Verificar si se lanza una excepción IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            factorialServiceUnderTest.calcularFactorial(numero);
        });
    }
}
