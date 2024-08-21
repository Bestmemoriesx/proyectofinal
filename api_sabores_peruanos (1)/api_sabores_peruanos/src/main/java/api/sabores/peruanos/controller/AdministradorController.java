package api.sabores.peruanos.controller;

import api.sabores.peruanos.model.administrador;
import api.sabores.peruanos.dao.AdministradorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AdministradorController {

    @Autowired
    private AdministradorDao administradorDao;

    @GetMapping("/administradores")
    public List<administrador> getAllAdministradores() {
        return administradorDao.findAll();
    }

    @GetMapping("/administrador/{id}")
    public Optional<administrador> getAdministradorById(@PathVariable Integer id) {
        return administradorDao.findById(id);
    }

    @PostMapping("/administrador")
    public administrador createAdministrador(@RequestBody administrador administrador) {
        return administradorDao.save(administrador);
    }

    @PutMapping("/administrador/{id}")
    public administrador updateAdministrador(@PathVariable Integer id, @RequestBody administrador administrador) {
        if (!administradorDao.existsById(id)) {
            throw new RuntimeException("administrador no encontrado");
        }
        administrador.setAdminId(id);
        return administradorDao.save(administrador);
    }
    
    @DeleteMapping("/administrador/{id}")
    public void deleteAdministrador(@PathVariable Integer id) {
    	administradorDao.deleteById(id);
    }
}
