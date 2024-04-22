package com.delivery.destinatarios.repository;

import com.delivery.destinatarios.dto.EnvioDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "enviosApi", url = "http://localhost:9001/envios/porDestinatario")
public interface IEnviosApi {
    @GetMapping("/{idDestinatario}")
    public List<EnvioDTO> getEnviosPorDestinatario(@PathVariable("idDestinatario") Long idDestinatario);
}
