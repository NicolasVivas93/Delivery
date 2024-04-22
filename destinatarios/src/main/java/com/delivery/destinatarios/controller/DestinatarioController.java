package com.delivery.destinatarios.controller;

import com.delivery.destinatarios.dto.EnvioDTO;
import com.delivery.destinatarios.model.Destinatario;
import com.delivery.destinatarios.service.IDestinatarioService;
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
@RequestMapping("/destinatario")
public class DestinatarioController {
        
    @Autowired
    private IDestinatarioService destinatarioServ;
    
    @PostMapping("/crear")
    public @ResponseBody Destinatario createDestinatario(@RequestBody Destinatario destinatario) {
        return destinatarioServ.createDestinatario(destinatario);
    } 
    
    @GetMapping("/traer")
    public @ResponseBody List<Destinatario> getDestinatarios() {
        return destinatarioServ.getDestinatarios();
    }
    
    @GetMapping("/traerPorId/{idDest}")
    public @ResponseBody Destinatario getDestinatarioById(@PathVariable("idDest") Long idDest) {
        return destinatarioServ.getDestinatarioById(idDest);
    }
    
    @GetMapping("/envios/{idDestinatario}")
    public @ResponseBody List<EnvioDTO> getEnviosPorDestinatario(@PathVariable("idDestinatario") Long idDestinatario) {
        return destinatarioServ.getEnviosPorDestinatario(idDestinatario);
    }
    
    @PutMapping("/editar")
    public @ResponseBody Destinatario editDestinatario(@RequestBody Destinatario destinatario) {
        destinatarioServ.editDestinatario(destinatario);
        return destinatarioServ.getDestinatarioById(destinatario.getId());
    }
    
    @DeleteMapping("/eliminar/{idDestinatario}")
    public String deleteDestinatario(@PathVariable("idDestinatario") Long idDestinatario) {
        destinatarioServ.deleteDestinatario(idDestinatario);
        return "Destinatario eliminado";
    }
}