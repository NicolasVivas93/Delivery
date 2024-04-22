package com.delivery.envios.controller;

import com.delivery.envios.enums.Estado;
import com.delivery.envios.model.Envio;
import com.delivery.envios.service.IEnvioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private IEnvioService envioServ;
    
    @PostMapping("/crear")
    public @ResponseBody Envio createEnvio(@RequestBody Envio envio) {
        envio.setEstado(Estado.PENDIENTE);
        return envioServ.createEnvio(envio);
    }
    
    @GetMapping("/traer")
    public @ResponseBody List<Envio> getEnvios() {
        return envioServ.getEnvios();
    }
    
    @GetMapping("/traerId/{idEnvio}")
    public @ResponseBody Envio getEnvioById(@PathVariable("idEnvio") Long idEnvio) {
        return envioServ.getEnvioById(idEnvio);
    }
    
    @GetMapping("/porDestinatario/{idDestinatario}")
    public @ResponseBody List<Envio> getEnvioPorDestinatario(@PathVariable("idDestinatario") Long idDestinatario) {
        return envioServ.getEnvioPorDestinatario(idDestinatario);
    }
    
    @PutMapping("/editar")
    public @ResponseBody Envio editEnvio(@RequestBody Envio envio) {
        String estadoEnvio = envio.getEstado().name();
        
        if (estadoEnvio.equalsIgnoreCase("ACEPTADO")) {
            envio.setEstado(Estado.ACEPTADO);
        } else if (estadoEnvio.equalsIgnoreCase("RECHAZADO")) {
            envio.setEstado(Estado.RECHAZADO);
        } else if (estadoEnvio.equalsIgnoreCase("EN CAMINO")) {
            envio.setEstado(Estado.EN_CAMINO);
        } else if (estadoEnvio.equalsIgnoreCase("ENTREGADO")) {
            envio.setEstado(Estado.ENTREGADO);
        }
        
        envioServ.editEnvio(envio);
        return envioServ.getEnvioById(envio.getId());
    }
    
    @DeleteMapping("/eliminar/{idEnvio}")
    public String deleteEnvio(@PathVariable("idEnvio") Long idEnvio) {
        envioServ.deleteEnvio(idEnvio);
        return "Envio eliminado";
    }
}