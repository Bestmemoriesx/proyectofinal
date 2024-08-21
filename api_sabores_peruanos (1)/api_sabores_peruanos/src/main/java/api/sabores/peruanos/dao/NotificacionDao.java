package api.sabores.peruanos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import api.sabores.peruanos.model.notificacion;

public interface NotificacionDao extends JpaRepository<notificacion, Integer> {
}
