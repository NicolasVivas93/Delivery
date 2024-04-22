package com.delivery.envios.repository;

import com.delivery.envios.model.Envio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnvioRepository extends JpaRepository<Envio, Long> {
    
    @Query(value = "SELECT * FROM envio WHERE id_destinatario = :idDestinatario", nativeQuery = true)
    public List<Envio> findEnviosPorDestinatario(Long idDestinatario);
}