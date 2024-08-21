package api.sabores.peruanos.controller;

import api.sabores.peruanos.model.LoginRequest;
import api.sabores.peruanos.model.cliente;
import api.sabores.peruanos.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/clientes")
    public List<cliente> getAllClientes() {
        return clienteDao.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Optional<cliente> getClienteById(@PathVariable Integer id) {
        return clienteDao.findById(id);
    }

    @PostMapping("/cliente")
    public cliente createCliente(@RequestBody cliente cliente) {
        return clienteDao.save(cliente);
    }
    
    @PutMapping("/cliente/{id}")
    public cliente updateCliente(@PathVariable Integer id, @RequestBody cliente cliente) {
        if (!clienteDao.existsById(id)) {
            throw new RuntimeException("cliente no encontrado");
        }
        cliente.setClienteId(id);
        return clienteDao.save(cliente);
    }
    
    @DeleteMapping("/cliente/{id}")
    public void deleteCliente(@PathVariable Integer id) {
        clienteDao.deleteById(id);
    }

    
    @PostMapping("/login")
    public cliente login(@RequestBody LoginRequest loginRequest) {
      
        return clienteDao.findByCorreoAndContraseña(loginRequest.getCorreo(), loginRequest.getContraseña())
                         .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
    }
}
