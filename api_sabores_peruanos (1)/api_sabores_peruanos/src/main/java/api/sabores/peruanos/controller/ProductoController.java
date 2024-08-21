package api.sabores.peruanos.controller;

import api.sabores.peruanos.model.Producto;
import api.sabores.peruanos.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    private ProductoDao productoDao;

    @GetMapping("/Producto")
    public List<Producto> getAllProductos() {
        return productoDao.findAll();
    }

    @GetMapping("/producto/{id}")
    public Optional<Producto> getProductoById(@PathVariable Integer id) {
        return productoDao.findById(id);
    }

    @PostMapping("/producto")
    public Producto createProducto(@RequestBody Producto Producto) {
        return productoDao.save(Producto);
    }
    
    @PutMapping("/producto/{id}")
    public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto Producto) {
        if (!productoDao.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        Producto.setProductoId(id);
        return productoDao.save(Producto);
    }
    
    @DeleteMapping("/producto/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        productoDao.deleteById(id);
    }
}
