package api.sabores.peruanos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import api.sabores.peruanos.model.historial_producto;

public interface HistorialProductoDao extends JpaRepository<historial_producto, Integer> {
}
