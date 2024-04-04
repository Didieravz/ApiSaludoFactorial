package com.nttdata.ejercicioSpring;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class FactorialResponse {

    public FactorialResponse(int numero, BigDecimal factorial) {
        this.numero = numero;
        this.factorial = factorial;
    }
    
    
    private int numero;
    
    private BigDecimal factorial;
    
}
