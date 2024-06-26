package com.delivery.destinatarios.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class EnvioDTO {
    private Long id;
    private LocalDate fechaCreacion;    
    private String estado;
    private String descripcion;
}