package api.sabores.peruanos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import api.sabores.peruanos.model.administrador;

public interface AdministradorDao extends JpaRepository<administrador, Integer> {
}