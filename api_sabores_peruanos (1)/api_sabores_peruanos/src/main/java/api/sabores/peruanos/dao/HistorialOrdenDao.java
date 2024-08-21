package api.sabores.peruanos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import api.sabores.peruanos.model.historial_orden;

public interface HistorialOrdenDao extends JpaRepository<historial_orden, Integer> {
}
