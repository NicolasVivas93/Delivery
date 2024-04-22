package com.delivery.destinatarios.service;

import com.delivery.destinatarios.dto.EnvioDTO;
import com.delivery.destinatarios.model.Destinatario;
import com.delivery.destinatarios.repository.IDestinatarioRepository;
import com.delivery.destinatarios.repository.IEnviosApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinatarioService implements IDestinatarioService {
    
    @Autowired
    private IDestinatarioRepository destinatarioRepo;
    
    @Autowired
    private IEnviosApi enviosApi;
    
    @Override
    public Destinatario createDestinatario(Destinatario destinatario) {
        return destinatarioRepo.save(destinatario);
    }

    @Override
    public List<Destinatario> getDestinatarios() {
        return destinatarioRepo.findAll();
    }

    @Override
    public Destinatario getDestinatarioById(Long idDest) {
        return destinatarioRepo.findById(idDest).orElse(null);
    }

    @Override
    public List<EnvioDTO> getEnviosPorDestinatario(Long idDestinatario) {
        return enviosApi.getEnviosPorDestinatario(idDestinatario);
    }

    @Override
    public Destinatario editDestinatario(Destinatario destinatario) {
        return destinatarioRepo.save(destinatario);
    }

    @Override
    public void deleteDestinatario(Long idDestinatario) {
        destinatarioRepo.deleteById(idDestinatario);
    }
    
}