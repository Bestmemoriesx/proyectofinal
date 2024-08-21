package api.sabores.peruanos.controller;

import api.sabores.peruanos.model.historial_producto;
import api.sabores.peruanos.dao.HistorialProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class HistorialProductoController {

    @Autowired
    private HistorialProductoDao historialProductoDao;

    @GetMapping("/historialproductos")
    public List<historial_producto> getAllHistorialProductos() {
        return historialProductoDao.findAll();
    }

    @GetMapping("/historialproducto/{id}")
    public Optional<historial_producto> getHistorialProductoById(@PathVariable Integer id) {
        return historialProductoDao.findById(id);
    }

    @PostMapping("/historialproducto")
    public historial_producto createHistorialProducto(@RequestBody historial_producto historial_producto) {
        return historialProductoDao.save(historial_producto);
    }
    
    @PutMapping("/historialproducto/{id}")
    public historial_producto updateHistorialProducto(@PathVariable Integer id, @RequestBody historial_producto historial_producto) {
        if (!historialProductoDao.existsById(id)) {
            throw new RuntimeException("Historial de Producto no encontrado");
        }
        historial_producto.setHistorialId(id);
        return historialProductoDao.save(historial_producto);
    }
    
    @DeleteMapping("/historialproducto/{id}")
    public void deleteHistorialProducto(@PathVariable Integer id) {
    	historialProductoDao.deleteById(id);
    }
}
