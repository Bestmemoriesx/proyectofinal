package api.sabores.peruanos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import api.sabores.peruanos.model.Producto;

public interface ProductoDao extends JpaRepository<Producto, Integer> {
}
