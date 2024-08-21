package api.sabores.peruanos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import api.sabores.peruanos.model.cliente;

public interface ClienteDao extends JpaRepository<cliente, Integer> {
    Optional<cliente> findByCorreoAndContraseña(String correo, String contraseña);
}
