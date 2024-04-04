package com.nttdata.ejercicioSpring;

import java.math.BigDecimal;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Didier Virguez Clase controladora del servicio saludo
 */
@RestController
@RequestMapping("/api")
public class SaludoController {

    //Inyeccion de negocio
    @Autowired
    private IFactorialService factorialService;

    //Metodo que retorna el saludo del equipo desarrollo
    @GetMapping("/hola")
    public SaludoResponse saludar() {
        return new SaludoResponse("Hola desde Desafio Binario");
    }

    //Metodo que realiza el llamado a negocio para calcular el factorial
    @GetMapping("/factorial/{numeroStr}")
    public FactorialResponse calcularFactorial(@PathVariable String numeroStr) {

        // Convertir la cadena a un BigDecimal para manejar números grandes y decimales
        BigDecimal numero = new BigDecimal(numeroStr);

        // Verificar si el número es un número entero sin decimales
        if (numero.scale() != 0) {
            throw new IllegalArgumentException("El parámetro proporcionado contiene decimales.");
        }

        // Convertir el número a un entero para realizar el cálculo del factorial
        int num = numero.intValue();

        BigDecimal factorial = factorialService.calcularFactorial(num);
        return new FactorialResponse(num, factorial);
    }

}
