package com.delivery.envios.service;

import com.delivery.envios.model.Envio;
import java.util.List;

public interface IEnvioService {
    
    public Envio createEnvio(Envio envio);
    
    public List<Envio> getEnvios();
    public Envio getEnvioById(Long idEnvio);
    public List<Envio> getEnvioPorDestinatario(Long idDestinatario);
    
    public Envio editEnvio(Envio envio);
    public void deleteEnvio(Long idEnvio);
    
}