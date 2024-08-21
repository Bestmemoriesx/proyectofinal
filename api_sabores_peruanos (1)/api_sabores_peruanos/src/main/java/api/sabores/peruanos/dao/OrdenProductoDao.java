package api.sabores.peruanos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import api.sabores.peruanos.model.orden_producto;

public interface OrdenProductoDao extends JpaRepository<orden_producto, Integer> {
}
