package com.delivery.destinatarios.service;

import com.delivery.destinatarios.dto.EnvioDTO;
import com.delivery.destinatarios.model.Destinatario;
import java.util.List;

public interface IDestinatarioService {
    
    public Destinatario createDestinatario(Destinatario destinatario);
    
    public List<Destinatario> getDestinatarios();
    public Destinatario getDestinatarioById(Long idDest);
    public List<EnvioDTO> getEnviosPorDestinatario(Long idDestinatario);
    
    public Destinatario editDestinatario(Destinatario destinatario);
    
    public void deleteDestinatario(Long idDestinatario);    
}
        