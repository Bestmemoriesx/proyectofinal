package api.sabores.peruanos.controller;

import api.sabores.peruanos.model.notificacion;
import api.sabores.peruanos.dao.NotificacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class NotificacionController {

    @Autowired
    private NotificacionDao notificacionDao;

    @GetMapping("/notificacion")
    public List<notificacion> getAllNotificaciones() {
        return notificacionDao.findAll();
    }

    @GetMapping("/notificacion/{id}")
    public Optional<notificacion> getNotificacionById(@PathVariable Integer id) {
        return notificacionDao.findById(id);
    }

    @PostMapping("/notificacion")
    public notificacion createNotificacion(@RequestBody notificacion notificacion) {
        return notificacionDao.save(notificacion);
    }
    
    @PutMapping("/notificacion/{id}")
    public notificacion updateNotificacion(@PathVariable Integer id, @RequestBody notificacion notificacion) {
        if (!notificacionDao.existsById(id)) {
            throw new RuntimeException("notificacion no encontrado");
        }
        notificacion.setNotificacionId(id);
        return notificacionDao.save(notificacion);
    }
    
    @DeleteMapping("/notificacion/{id}")
    public void deleteNotificacion(@PathVariable Integer id) {
    	notificacionDao.deleteById(id);
    }
}
