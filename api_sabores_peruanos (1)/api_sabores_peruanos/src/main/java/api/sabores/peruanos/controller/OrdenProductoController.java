package api.sabores.peruanos.controller;

import api.sabores.peruanos.model.orden_producto;
import api.sabores.peruanos.dao.OrdenProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class OrdenProductoController {

    @Autowired
    private OrdenProductoDao ordenProductoDao;

    @GetMapping("/ordenproductos")
    public List<orden_producto> getAllOrdenes() {
        return ordenProductoDao.findAll();
    }

    @GetMapping("/ordenproducto/{id}")
    public Optional<orden_producto> getOrdenById(@PathVariable Integer id) {
        return ordenProductoDao.findById(id);
    }

    @PostMapping("/ordenproducto")
    public orden_producto createOrden(@RequestBody orden_producto orden_producto) {
        return ordenProductoDao.save(orden_producto);
    }
    
    @PutMapping("/ordenproducto/{id}")
    public orden_producto updateOrdenProducto(@PathVariable Integer id, @RequestBody orden_producto orden_producto) {
        if (!ordenProductoDao.existsById(id)) {
            throw new RuntimeException("orden_producto no encontrado");
        }
        orden_producto.setOrdenId(id);
        return ordenProductoDao.save(orden_producto);
    }
    
    @DeleteMapping("/ordenproducto/{id}")
    public void deleteOrdenProducto(@PathVariable Integer id) {
    	ordenProductoDao.deleteById(id);
    }
}

