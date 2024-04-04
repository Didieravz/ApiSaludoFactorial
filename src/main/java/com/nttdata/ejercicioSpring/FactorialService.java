
package com.nttdata.ejercicioSpring;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 * @author usuario
 * Clase de negocio que implementa los metodos del factorial
 */
@Service
public class FactorialService implements IFactorialService{
    
    //Metodo que calcula el factorial de un numero
    @Override
    public BigDecimal calcularFactorial(int numero) {
        
        //Verifica que el numero no sea menor a 0
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser mayor o igual a cero.");
        } else if (numero == 0 || numero == 1) {
            return BigDecimal.ONE;
        } else {
            BigDecimal factorial = BigDecimal.ONE;
            for (int i = 2; i <= numero; i++) {
                factorial = factorial.multiply(BigDecimal.valueOf(i));
            }
            return factorial;
        }
    } 
    
}
