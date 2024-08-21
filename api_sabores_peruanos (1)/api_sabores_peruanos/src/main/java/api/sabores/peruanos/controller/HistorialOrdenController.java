package api.sabores.peruanos.controller;

import api.sabores.peruanos.model.historial_orden;
import api.sabores.peruanos.dao.HistorialOrdenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class HistorialOrdenController {

    @Autowired
    private  HistorialOrdenDao historialOrdenDao;

    @GetMapping("/historialordenes")
    public List<historial_orden> getAllHistorialOrdenes() {
        return historialOrdenDao.findAll();
    }

    @GetMapping("/historialorden/{id}")
    public Optional<historial_orden> getHistorialOrdenById(@PathVariable Integer id) {
        return historialOrdenDao.findById(id);
    }

    @PostMapping("/historialorden")
    public historial_orden createHistorialOrden(@RequestBody historial_orden historial_orden) {
        return historialOrdenDao.save(historial_orden);
    }
    
    @PutMapping("/historialorden/{id}")
    public historial_orden updateHistorialOrden(@PathVariable Integer id, @RequestBody historial_orden historial_orden) {
        if (!historialOrdenDao.existsById(id)) {
            throw new RuntimeException("Historial de Orden no encontrado");
        }
        historial_orden.setHistorialId(id);
        return historialOrdenDao.save(historial_orden);
    }
    
    @DeleteMapping("/historialorden/{id}")
    public void deleteHistorialOrden(@PathVariable Integer id) {
    	historialOrdenDao.deleteById(id);
    }
}

