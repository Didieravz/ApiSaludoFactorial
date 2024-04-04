
package com.nttdata.ejercicioSpring;

import lombok.Data;

@Data
class SaludoResponse {

    public SaludoResponse(String mensaje) {
        this.mensaje = mensaje;
    }   
    
    private String mensaje;
    
    
}
