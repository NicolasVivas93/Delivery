package com.delivery.envios.service;

import com.delivery.envios.model.Envio;
import com.delivery.envios.repository.IEnvioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvioService implements IEnvioService {

    @Autowired
    private IEnvioRepository envioRepo;
    
    @Override
    public Envio createEnvio(Envio envio) {
        return envioRepo.save(envio);
    }

    @Override
    public List<Envio> getEnvios() {
        return envioRepo.findAll();
    }

    @Override
    public Envio getEnvioById(Long idEnvio) {
        return envioRepo.findById(idEnvio).orElse(null);
    }

    @Override
    public List<Envio> getEnvioPorDestinatario(Long idDestinatario) {
        return envioRepo.findEnviosPorDestinatario(idDestinatario);
    }

    @Override
    public Envio editEnvio(Envio envio) {
        return envioRepo.save(envio);
    }

    @Override
    public void deleteEnvio(Long idEnvio) {
        envioRepo.deleteById(idEnvio);
    }
    
}